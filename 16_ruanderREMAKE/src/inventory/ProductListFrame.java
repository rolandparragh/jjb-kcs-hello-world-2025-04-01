package inventory;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;

public class ProductListFrame {

	private JFrame frmListProduct;
	private JTable tableProduct;
	private JScrollPane spProductTable;
	private JButton btnNewProduct;
	private JButton btnSearch;
	private JTextField tfSearch;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductListFrame window = new ProductListFrame();
					window.frmListProduct.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ProductListFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmListProduct = new JFrame();
		frmListProduct.setTitle("Termék CRUD ");
		frmListProduct.setBounds(100, 100, 1029, 500);
		frmListProduct.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmListProduct.getContentPane().setLayout(null);

		spProductTable = new JScrollPane();
		spProductTable.setBounds(10, 11, 993, 178);
		frmListProduct.getContentPane().add(spProductTable);

		tableProduct = new JTable();
		tableProduct.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int rowIndex = tableProduct.rowAtPoint(e.getPoint());
				showUpdateDelteFrame(rowIndex);

			}
		});
		spProductTable.setColumnHeaderView(tableProduct);

		btnNewProduct = new JButton("Új termék");
		btnNewProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showNewProductFrame();

			}
		});
		btnNewProduct.setBackground(SystemColor.activeCaption);
		btnNewProduct.setBounds(37, 261, 89, 23);
		frmListProduct.getContentPane().add(btnNewProduct);
		
		btnSearch = new JButton("Keresés");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchByName();
			}
		});
		btnSearch.setBackground(SystemColor.activeCaption);
		btnSearch.setBounds(37, 316, 89, 23);
		frmListProduct.getContentPane().add(btnSearch);
		
		tfSearch = new JTextField();
		tfSearch.setBounds(136, 317, 179, 20);
		frmListProduct.getContentPane().add(tfSearch);
		tfSearch.setColumns(10);
		loadProducts();
	}

	public void loadProducts() {
		Database database = new Database();
		database.createConnection();
		String sql = "SELECT * FROM product ORDER BY id";
		ResultSet rs = database.query(sql);
		fillProductTableByRs(rs);
		setTableAlignCenter(tableProduct);
		// System.out.println(rs); azonosító vagy null, ha null akkor nem sikerült
	}

	private void fillProductTableByRs(ResultSet rs) {

		// feltölti a headert
		tableProduct.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Id", "Leltárszám", "Név", "nettó ár (Ft)", "Raktármennyiség", "Állapot" }));
		try {
			while (rs.next()) {
				((DefaultTableModel) tableProduct.getModel()).addRow(new Object[] {

						// rs kvázi egy kurzor, amíg van következő addig csinálja a db-n belül,
						// fetching data, navigating, getting column values, closing
						rs.getInt("id"), rs.getString("identity_number"), rs.getString("name"), rs.getInt("net_price"),
						rs.getInt("stock_amount"), rs.getBoolean("status") ? "aktív" : "inaktív"

				});
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void setTableAlignCenter(JTable table) {
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		table.setDefaultRenderer(Object.class, centerRenderer);
	}

	private void showUpdateDelteFrame(int rowIndex) {
		int id = Integer.parseInt(tableProduct.getModel().getValueAt(rowIndex, 0).toString());
		new ProductUpdateDeleteFrame(this, id);
	}

	private void showNewProductFrame() {
		new NewProductFrame(this); // this a ProductFrameListre utal, innel nyitjuk meg az ablakot
		// a konstrukturaba beletesszük a szülőt

	}
	public void searchByName() {
		if(!tfSearch.getText().isEmpty()) {
		Database database = new Database();
		database.createConnection();
		String sql = "SELECT * FROM product  WHERE name LIKE '%"+tfSearch.getText().toLowerCase().trim() +"%' ORDER BY id;";
		ResultSet rs = database.query(sql);
		fillProductTableByRs(rs);
		setTableAlignCenter(tableProduct);
		}else {
			loadProducts();
			
		}
		
	}
}
