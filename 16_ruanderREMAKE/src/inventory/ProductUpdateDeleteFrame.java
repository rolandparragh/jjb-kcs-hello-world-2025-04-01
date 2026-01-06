package inventory;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class ProductUpdateDeleteFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfIdentityNumber;
	private JTextField tfName;
	private JTextField tfNetPrice;
	private JTextField tfStockAmount;
	private JLabel lblIdentityNumber;
	private JLabel lblName;
	private JLabel lblNetPrice;
	private JLabel lblStockAmount;
	private JLabel lblStatus;
	private JComboBox cbStatus;
	private JButton btnDelete;
	private JButton btnUpdate;
	private JButton btnClose;
	private JPanel panelInput;
	private Connection connection = new Database().createConnection();

	// private Statement stm = null;
	// private Connection connection = new Database().createConnection();

	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ProductUpdateDeleteFrame(ProductListFrame productListFrame, int id) {
		setTitle("Termék módosítás és törlés, id: " + id);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(750, 80, 611, 689);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		panelInput = new JPanel();
		panelInput.setLayout(null);
		panelInput.setBounds(75, 33, 432, 335);
		contentPane.add(panelInput);

		lblIdentityNumber = new JLabel("Leltárszám:");
		lblIdentityNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblIdentityNumber.setFont(new Font("Arial", Font.BOLD, 14));
		lblIdentityNumber.setBounds(10, 22, 150, 39);
		panelInput.add(lblIdentityNumber);

		lblName = new JLabel("Név:");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setFont(new Font("Arial", Font.BOLD, 14));
		lblName.setBounds(10, 87, 150, 39);
		panelInput.add(lblName);

		lblNetPrice = new JLabel("Ár:");
		lblNetPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lblNetPrice.setFont(new Font("Arial", Font.BOLD, 14));
		lblNetPrice.setBounds(10, 150, 150, 39);
		panelInput.add(lblNetPrice);

		lblStockAmount = new JLabel("Raktármennyiség:");
		lblStockAmount.setHorizontalAlignment(SwingConstants.CENTER);
		lblStockAmount.setFont(new Font("Arial", Font.BOLD, 14));
		lblStockAmount.setBounds(10, 214, 150, 39);
		panelInput.add(lblStockAmount);

		lblStatus = new JLabel("Állapot:");
		lblStatus.setHorizontalAlignment(SwingConstants.CENTER);
		lblStatus.setFont(new Font("Arial", Font.BOLD, 14));
		lblStatus.setBounds(10, 274, 150, 39);
		panelInput.add(lblStatus);

		tfIdentityNumber = new JTextField();
		tfIdentityNumber.setHorizontalAlignment(SwingConstants.CENTER);
		tfIdentityNumber.setFont(new Font("Arial", Font.PLAIN, 16));
		tfIdentityNumber.setColumns(10);
		tfIdentityNumber.setBounds(170, 26, 242, 29);
		panelInput.add(tfIdentityNumber);

		tfName = new JTextField();
		tfName.setHorizontalAlignment(SwingConstants.CENTER);
		tfName.setFont(new Font("Arial", Font.PLAIN, 16));
		tfName.setColumns(10);
		tfName.setBounds(170, 91, 242, 29);
		panelInput.add(tfName);

		tfNetPrice = new JTextField();
		tfNetPrice.setHorizontalAlignment(SwingConstants.CENTER);
		tfNetPrice.setFont(new Font("Arial", Font.PLAIN, 16));
		tfNetPrice.setColumns(10);
		tfNetPrice.setBounds(170, 154, 242, 29);
		panelInput.add(tfNetPrice);

		tfStockAmount = new JTextField();
		tfStockAmount.setHorizontalAlignment(SwingConstants.CENTER);
		tfStockAmount.setFont(new Font("Arial", Font.PLAIN, 16));
		tfStockAmount.setColumns(10);
		tfStockAmount.setBounds(170, 218, 242, 29);
		panelInput.add(tfStockAmount);

		cbStatus = new JComboBox();
		cbStatus.setModel(new DefaultComboBoxModel(new String[] { "inaktív", "aktív" }));
		cbStatus.setFont(new Font("Arial", Font.PLAIN, 16));
		cbStatus.setBounds(170, 274, 150, 39);
		panelInput.add(cbStatus);

		btnClose = new JButton("BEZÁR");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnClose.setForeground(Color.WHITE);
		btnClose.setFont(new Font("Arial", Font.BOLD, 16));
		btnClose.setBackground(new Color(255, 165, 0));
		btnClose.setBounds(425, 558, 134, 56);
		contentPane.add(btnClose);

		btnUpdate = new JButton("MÓDOSÍT");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateProductById(id);
				productListFrame.loadProducts();
			}
		});
		btnUpdate.setForeground(Color.WHITE);
		btnUpdate.setFont(new Font("Arial", Font.BOLD, 16));
		btnUpdate.setBackground(SystemColor.activeCaption);
		btnUpdate.setBounds(350, 412, 153, 56);
		contentPane.add(btnUpdate);

		btnDelete = new JButton("TÖRÖL");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteProductById(id);
				productListFrame.loadProducts();

			}
		});
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setFont(new Font("Arial", Font.BOLD, 16));
		btnDelete.setBackground(new Color(255, 99, 71));
		btnDelete.setBounds(75, 412, 153, 56);
		contentPane.add(btnDelete);

		setVisible(true);
		loadProductById(id);
	}

	private void loadProductById(int id) {


		String sql = "SELECT * FROM product WHERE id ='" + id + "';";
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			if (rs.next()) {
				tfIdentityNumber.setText(rs.getString("identity_number"));
				tfName.setText(rs.getString("name"));
				tfNetPrice.setText(rs.getString("net_price"));
				tfStockAmount.setText(rs.getString("stock_amount"));
				cbStatus.setSelectedIndex(rs.getInt("status"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void deleteProductById(  int id) {
	
		String sql = "DELETE FROM product WHERE id= '" + id + "';";

		try {

			PreparedStatement ps = connection.prepareStatement(sql);
			ps.executeUpdate();
			dispose();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		resetInputFields();

	}
	
	
	private void updateProductById(int id) {
		
		String sql ="UPDATE product SET identity_number=?, name=?, net_price=?, stock_amount=?, status=? WHERE id='"+id+  "';";

		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, tfIdentityNumber.getText());
			ps.setString(2, tfName.getText());
			ps.setDouble(3, Double.parseDouble(tfNetPrice.getText()));
			ps.setInt(4, Integer.parseInt(tfStockAmount.getText()));
			ps.setInt(5, cbStatus.getSelectedIndex());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	private void resetInputFields() {
		tfIdentityNumber.setText("");
		tfName.setText("");
		tfNetPrice.setText("");
		tfStockAmount.setText("");
		cbStatus.setSelectedIndex(0);
	}

}
