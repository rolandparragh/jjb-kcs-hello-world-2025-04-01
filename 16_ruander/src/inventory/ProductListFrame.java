package inventory;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ProductListFrame {

	private JFrame frmListProduct;
	private JButton btnConnectDB;
	private JTable tableProduct;
	private JScrollPane scrollPane;


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
		frmListProduct.setBounds(100, 100, 818, 576);
		frmListProduct.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmListProduct.getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 769, 188);
		frmListProduct.getContentPane().add(scrollPane);
		
		tableProduct = new JTable();
		tableProduct.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int rowIndex = tableProduct.rowAtPoint(e.getPoint());
			}
		});
		scrollPane.setViewportView(tableProduct);
		
		JButton btnNewProduct = new JButton("Új termék");
		btnNewProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showNewProductFrame();
			}
		});
		btnNewProduct.setBackground(SystemColor.activeCaption);
		btnNewProduct.setBounds(10, 225, 132, 34);
		frmListProduct.getContentPane().add(btnNewProduct);
		// Database database = new Database();
		 // database.CreateConnection();
		loadProduct();
	}
	
	
	public void loadProduct() {
		 Database database = new Database();
		 database.CreateConnection();
		 String sql = "SELECT * FROM product ORDER BY id;";
		 ResultSet rs = database.query(sql);
		 System.out.println(rs);
		 fillProductTable(rs);
	}
	
	private void fillProductTable(ResultSet rs) {
		tableProduct.setModel(
				new DefaultTableModel(new Object[][] {}, new String[] {"Id","Leltárszám","Név","nettó ár (Ft)","Raktármennyiség","Állapot"} ) );
		
		try {
			while(rs.next()) {
				((DefaultTableModel) tableProduct.getModel()).addRow(new Object[] {
						//rs.getInt(1),
						rs.getInt("id"),
						rs.getString("identity_number"), //product táblában van egy identity_number nevű oszlop
						rs.getString("name"), 
						rs.getInt("net_price"),
						rs.getInt("stock_amount"),
						rs.getBoolean("status") ? "aktív":"inaktív"
						
				});
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void showNewProductFrame() {
		new NewProductFrame(this);// this a productlistframe-re utal , innen nyitjuk meg az ablakot
		
	}
}
