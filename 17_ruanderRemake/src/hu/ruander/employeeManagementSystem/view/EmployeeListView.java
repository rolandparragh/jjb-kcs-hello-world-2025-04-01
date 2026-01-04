package hu.ruander.employeeManagementSystem.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel; 

import hu.ruander.employeeManagementSystem.model.dto.EmployeeDto;
import hu.ruander.employeeManagementSystem.utils.buttonColumnDemo.ButtonColumn;

public class EmployeeListView extends JFrame {

	// serial version id: azonosítja az osztályból létrejövő objektumot
	// objektum mentése, megjelenítése: pld. db-be vagy mem. vagy fájlba vagy csak
	// megjelenítésnél
	private static final long serialVersionUID = -8944558312968701450L;

	// A komponensek beállítása WindowBuilder nélkül
	private JPanel contentPane;
	private JTable tableEmployee;
	private JScrollPane scrollPaneEmployeeTable;
	private JButton btnNewEmployee;
	private ActionListener deleteListener;
	private ActionListener editListener;

	// Konstansok formázáshoz
	private static final Font DEFAULT_FONT = new Font("Tahoma", Font.PLAIN, 18);
	private static final Font BUTTON_FONT = new Font("Tahoma", Font.PLAIN, 20);
	private static final Color BUTTON_COLOR = SystemColor.activeCaption;

	public EmployeeListView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1400, 700);
		setTitle("Dolgozói nyilvántartás - MVP");

		initContentPane();
		initTable();
		initNewEmployeeButton();

		// MVP szabályát megszegjük - Presenter oldja majd meg...
//		EmployeeDao employeeDaoObj = new EmployeeDao();
//		List<EmployeeDto> employees = employeeDaoObj.getAll();
//		setModelToTableEmployeeList(employees);

		setVisible(true);
	}

	private void initContentPane() {
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
	}

	private void initTable() {
		scrollPaneEmployeeTable = new JScrollPane();
		scrollPaneEmployeeTable.setBounds(45, 51, 1300, 280);
		contentPane.add(scrollPaneEmployeeTable);

		tableEmployee = new JTable();
		tableEmployee.setFont(DEFAULT_FONT);
		tableEmployee.getTableHeader().setFont(DEFAULT_FONT);
		tableEmployee.setRowHeight(30);
		scrollPaneEmployeeTable.setViewportView(tableEmployee);
	}

	private void initNewEmployeeButton() {
		btnNewEmployee = new JButton("Új dolgozó");
		btnNewEmployee.setForeground(Color.white);
		btnNewEmployee.setBackground(BUTTON_COLOR);
		btnNewEmployee.setFont(BUTTON_FONT);
		btnNewEmployee.setBounds(45, 388, 290, 72);
		contentPane.add(btnNewEmployee);
	}

	public void setModelToTableEmployeeList(List<EmployeeDto> employees) {
		DefaultTableModel employeeListModel = createTableModel(employees);
		tableEmployee.setModel(employeeListModel);

		Action delete = setDeleteAction();
		Action update = setUpdateAction();
		tableEmployee.setModel(employeeListModel);

		ButtonColumn buttonUpdate = new ButtonColumn(tableEmployee, update, 7);
		ButtonColumn buttonDelete = new ButtonColumn(tableEmployee, delete, 8);

		buttonDelete.setMnemonic(KeyEvent.VK_D);
		buttonUpdate.setMnemonic(KeyEvent.VK_U);

		setTableCentered(tableEmployee);
	}

	private DefaultTableModel createTableModel(List<EmployeeDto> employees) {
		String[] columns = { "Id", "Név", "Születési dátum", "Szig. szám", "Fizetés", "Beosztás", "Állapot",
				"Szerkesztés", "Törlés" };

		DefaultTableModel model = new DefaultTableModel(columns, 0);

		for (EmployeeDto employee : employees) {
			model
					.addRow(
							new Object[] { employee.getId(), employee.getFullName(), employee.getDateOfBirth(),
									employee.getIdentityCard(), employee.getSalary(),
									employee.getEmployeeCategory().getName(), employee.getStatusText(), "Szerkesztés",
									"Törlés" });
		}
		return model;
	}

	private void setTableCentered(JTable table) {
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
		for (int i = 0; i < table.getColumnCount(); i++) {
			table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
			if (i == 1) {
				table.getColumnModel().getColumn(i).setMinWidth(180);
			}
		}
	}

	public void showEmployeeAddButtonListener(ActionListener listener) {
		btnNewEmployee.addActionListener(listener);
	}

	public void setDeleteListener(ActionListener listener) {
		this.deleteListener = listener;
	}

	public void setEditListener(ActionListener listener) {
		this.editListener = listener;
	}

	private Action createTableAction(String confirmMessage, ActionListener listener) {
		return new AbstractAction() {
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				JTable table = (JTable) e.getSource();
				int modelRow = Integer.parseInt(e.getActionCommand());
				int id = (Integer) table.getModel().getValueAt(modelRow, 0);

				boolean confirmed = true;
				if (confirmMessage != null) {
					int result = JOptionPane
							.showConfirmDialog(
									SwingUtilities.windowForComponent(table),
									confirmMessage + id,
									"Megerősítés",
									JOptionPane.YES_NO_OPTION);
					confirmed = result == JOptionPane.YES_OPTION;
				}

				if (confirmed && listener != null) {
					listener.actionPerformed(new ActionEvent(table, ActionEvent.ACTION_PERFORMED, String.valueOf(id)));
				}
			}
		};
	}

	private Action setDeleteAction() {
		return createTableAction("Valóban törli a következő elemet, id: ", deleteListener);
	}

	private Action setUpdateAction() {
		return createTableAction(
				null, // Nem kell megerősítés a szerkesztéshez
				editListener);
	}
}
