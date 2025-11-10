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

public class ProductListFrame {

	private JFrame frmListProduct;
	private JTable tableProduct;
	private JScrollPane spProductTable;

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
		frmListProduct.setBounds(100, 100, 1029, 500);
		frmListProduct.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmListProduct.getContentPane().setLayout(null);

		spProductTable = new JScrollPane();
		spProductTable.setBounds(10, 11, 993, 178);
		frmListProduct.getContentPane().add(spProductTable);

		tableProduct = new JTable();
		spProductTable.setColumnHeaderView(tableProduct);
		loadProducts();
	}

	public void loadProducts() {
		Database database = new Database();
		Connection con = database.createConnection();
		if (con != null) {
			System.out.println("Connection successful");
		} else {
			System.err.println("Connection failed");
		}

		String sql = "SELECT * FROM product ORDER BY id";
		ResultSet rs = database.query(sql);
		fillProductTableByRs(rs);
		setTableAlignCenter(tableProduct);
	}

	private void fillProductTableByRs(ResultSet rs) {
		tableProduct.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Id", "Leltárszám", "Név", "nettó ár (Ft)", "Raktármennyiség", "Állapot" }));
		try {
			while (rs.next()) {
				((DefaultTableModel) tableProduct.getModel()).addRow(new Object[] { 
						rs.getInt("id"),
						rs.getString("identity_number"), 
						rs.getString("name"), 
						rs.getInt("net_price"),
						rs.getInt("stock_amount"), 
						rs.getBoolean("status") ? "aktív" : "inaktív"

				});
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	private void setTableAlignCenter(JTable table) {
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		table.setDefaultRenderer(Object.class, centerRenderer);
	}

}
