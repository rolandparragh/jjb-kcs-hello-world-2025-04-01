package inventory;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class NewProductFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfName;
	private JTextField tfNetPrice;
	private JTextField tfStockAmount;
	private JLabel lblIdentityNumber;
	private JLabel lblName;
	private JLabel lblNetPrice;
	private JLabel lblStockAmount;
	private JLabel lblStatus;
	private JComboBox cbStatus;
	private JTextField tfIdentityNumber;
	private JButton btnSave;
	private JButton btnClose;

	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "unchecked", "unchecked", "unchecked", "rawtypes", "rawtypes" })
	public NewProductFrame(ProductListFrame productListFrame) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(800, 100, 450, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblIdentityNumber = new JLabel("Leltárszám:");
		lblIdentityNumber.setBounds(60, 84, 65, 14);
		contentPane.add(lblIdentityNumber);

		lblName = new JLabel("Név:");
		lblName.setBounds(72, 131, 46, 14);
		contentPane.add(lblName);

		lblNetPrice = new JLabel("Ár:");
		lblNetPrice.setBounds(72, 187, 46, 14);
		contentPane.add(lblNetPrice);

		lblStockAmount = new JLabel("Raktár mennyiség:");
		lblStockAmount.setBounds(40, 232, 99, 14);
		contentPane.add(lblStockAmount);

		lblStatus = new JLabel("Állapot");
		lblStatus.setBounds(60, 281, 46, 14);
		contentPane.add(lblStatus);

		btnSave = new JButton("Mentés");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveNewProduct();
				productListFrame.loadProducts();

			}
		});
		btnSave.setBackground(SystemColor.textHighlight);
		btnSave.setBounds(272, 386, 89, 23);
		contentPane.add(btnSave);

		btnClose = new JButton("Bezár");
		btnClose.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				dispose();
			}
		});
		btnClose.setBackground(new Color(255, 153, 0));
		btnClose.setBounds(338, 451, 89, 23);
		contentPane.add(btnClose);

		tfIdentityNumber = new JTextField();
		tfIdentityNumber.setBounds(179, 81, 201, 20);
		contentPane.add(tfIdentityNumber);
		tfIdentityNumber.setColumns(10);

		tfName = new JTextField();
		tfName.setColumns(10);
		tfName.setBounds(179, 128, 201, 20);
		contentPane.add(tfName);

		tfNetPrice = new JTextField();
		tfNetPrice.setColumns(10);
		tfNetPrice.setBounds(175, 184, 201, 20);
		contentPane.add(tfNetPrice);

		tfStockAmount = new JTextField();
		tfStockAmount.setColumns(10);
		tfStockAmount.setBounds(175, 229, 201, 20);
		contentPane.add(tfStockAmount);
		cbStatus = new JComboBox();
		cbStatus.setBounds(176, 277, 201, 22);
		cbStatus.setModel(new DefaultComboBoxModel(new String[] { "inaktív", "aktív" }));
		contentPane.add(cbStatus);

		this.setVisible(true);
	}

	private void saveNewProduct() {

		// nem menti le külön változóba az objektumpéldányt hanem egyből meghívja a
		// create connectiont
		Connection connection = new Database().createConnection();
		// Statement vs. PreparedStatement
		// Sima Statement
//				String sql = "INSERT INTO product (identity_number, name, net_price, stock_amount, status) "
//						+ "VALUES ("+tfIdentityNumber.getText()... ; 
		// PreparedStatement - SQL injection kivédése

		// bind - összekötés: ? paramétereket összekötjük a java-s valtozókkal
		// első elem, első ? indexe 1 (nem 0-tól indexel)

		// PreparedStatement
		String sql = "INSERT INTO product (identity_number, name, net_price, stock_amount, status) "
				+ "VALUES (?,?,?,?,?);";

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
		resetInputFields();
	}

	private void resetInputFields() {

		tfIdentityNumber.setText("");
		tfName.setText("");
		tfNetPrice.setText("");
		tfStockAmount.setText("");
		cbStatus.setSelectedIndex(0);

	}

}
