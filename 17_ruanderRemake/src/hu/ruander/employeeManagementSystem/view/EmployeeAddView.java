package hu.ruander.employeeManagementSystem.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import hu.ruander.employeeManagementSystem.model.dto.EmployeeCategoryDto;
import hu.ruander.employeeManagementSystem.model.dto.EmployeeDto;

public class EmployeeAddView extends JFrame {

	private static final long serialVersionUID = 5140465143052642793L;
	private JTextField tfFirstName;
	private JTextField tfLastName;
	private JTextField tfDateOfBirth;
	private JTextField tfIdentityCard;
	private JTextField tfSalary;
	private JComboBox<EmployeeCategoryDto> cmbCategory;
	private JCheckBox chkStatus;
	private JButton btnSave;
	private JButton btnCancel;  static final Font DEFAULT_FONT = new Font("Tahoma", Font.PLAIN, 22);
	private static final Insets DEFAULT_INSETS = new Insets(5, 5, 5, 5);

	public EmployeeAddView(List<EmployeeCategoryDto> employeeCategories) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(600, 80, 450, 500);
		setTitle("Új dolgozó felvitel");
		initUI(employeeCategories);
	}

	private void initUI(List<EmployeeCategoryDto> employeeCategories) {
		// GridBagLayout
		setLayout(new GridBagLayout());

		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.insets = new Insets(5, 5, 5, 5);
		gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;

		gridBagConstraints.insets = DEFAULT_INSETS;
		gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;

		String[] labels = { "Vezetéknév", "Keresztnév", "Születési idő", "Szig. szám", "Fizetés", "Kategória",
				"Állapot", };

		Component[] components = createInputComponents(employeeCategories);
		setTextFieldInputCenter(components);

		chkStatus.setSelected(true);
		setTextFieldInputCenter(components);

		for (int i = 0; i < labels.length; i++) {
			gridBagConstraints.gridx = 0;
			gridBagConstraints.gridy = i;
			add(createLabel(labels[i]), gridBagConstraints);

			gridBagConstraints.gridx = 1;
			add(components[i], gridBagConstraints);
		}

		// Gombok
		gridBagConstraints.gridy = labels.length;

		gridBagConstraints.gridx = 0;
		btnCancel = createButton("MÉGSEM", Color.YELLOW);
		add(btnCancel, gridBagConstraints);

		gridBagConstraints.gridx = 1;
		btnSave = createButton("MENTÉS", SystemColor.activeCaption);
		add(btnSave, gridBagConstraints);
	}

	private JLabel createLabel(String text) {
		JLabel label = new JLabel(text);
		label.setFont(DEFAULT_FONT);
		return label;
	}

	private JTextField createTextField() {
		JTextField tf = new JTextField(10);
		tf.setFont(DEFAULT_FONT);
		return tf;
	}

	private JComboBox<EmployeeCategoryDto> createComboBox(List<EmployeeCategoryDto> categories) {
		JComboBox<EmployeeCategoryDto> comboBox = new JComboBox<>(new EmployeeCategoryComboBoxModel(categories));
		comboBox.setFont(DEFAULT_FONT);
		return comboBox;
	}

	private JButton createButton(String text, Color background) {
		JButton button = new JButton(text);
		button.setFont(DEFAULT_FONT);
		button.setBackground(background);
		return button;
	}

	private Component[] createInputComponents(List<EmployeeCategoryDto> employeeCategories) {
		tfLastName = createTextField();
		tfFirstName = createTextField();
		tfDateOfBirth = createTextField();
		tfIdentityCard = createTextField();
		tfSalary = createTextField();
		cmbCategory = createComboBox(employeeCategories);
		chkStatus = new JCheckBox();
		chkStatus.setSelected(true);

		return new Component[] { tfLastName, tfFirstName, tfDateOfBirth, tfIdentityCard, tfSalary, cmbCategory,
				chkStatus };
	}

	public JButton getBtnSave() {
		return btnSave;
	}

	public JButton getBtnCancel() {
		return btnCancel;
	}

	private void setTextFieldInputCenter(Component[] components) {
		for (Component component : components) {
			if (component instanceof JTextField) {
				((JTextField) component).setHorizontalAlignment(SwingConstants.CENTER);
			}
		}
	}

	public EmployeeDto getEmployeeDtoByInputData() {
		EmployeeDto employeeDto = new EmployeeDto(tfFirstName.getText(), tfLastName.getText(),
				LocalDate.parse(tfDateOfBirth.getText()), tfIdentityCard.getText(),
				Integer.parseInt(tfSalary.getText()), (EmployeeCategoryDto) cmbCategory.getSelectedItem(),
				chkStatus.isSelected(), false);
		return employeeDto;
	}

	public void saveEmployeeButtonListener(ActionListener listener) {
		btnSave.addActionListener(listener);
	}

	public void cancelEmployeeButtonListener(ActionListener listener) {
		btnCancel.addActionListener(listener);
	}

}
