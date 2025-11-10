package inventory;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JComboBox;

public class NewProductFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JLabel lblIdentityNumber;
	private JLabel lblName;
	private JLabel lblNetPrice;
	private JLabel lblStockAmount;
	private JLabel lblStatus;
	private JButton btnExit;
	private JTextField tFIdentityNumber;
	private JTextField tFName;
	private JTextField tFNetPrice;
	private JComboBox cBaStatus;
	private JButton btnSave;
	private JTextField tFStockAmount;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public NewProductFrame(ProductListFrame productListFrame) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(550, 80, 473, 486);
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel);
		panel.setLayout(null);

		lblIdentityNumber = new JLabel("Leltárszám");
		lblIdentityNumber.setBounds(41, 25, 75, 14);
		panel.add(lblIdentityNumber);

		tFIdentityNumber = new JTextField();
		tFIdentityNumber.setBounds(126, 22, 86, 20);
		panel.add(tFIdentityNumber);
		tFIdentityNumber.setColumns(10);

		lblName = new JLabel("Név");
		lblName.setBounds(41, 68, 46, 14);
		panel.add(lblName);

		tFName = new JTextField();
		tFName.setColumns(10);
		tFName.setBounds(126, 65, 86, 20);
		panel.add(tFName);

		lblNetPrice = new JLabel("Ár:");
		lblNetPrice.setBounds(41, 122, 46, 14);
		panel.add(lblNetPrice);

		tFNetPrice = new JTextField();
		tFNetPrice.setColumns(10);
		tFNetPrice.setBounds(126, 119, 86, 20);
		panel.add(tFNetPrice);

		lblStockAmount = new JLabel("Raktár mennyiség:");
		lblStockAmount.setBounds(10, 170, 106, 14);
		panel.add(lblStockAmount);

		tFStockAmount = new JTextField();
		tFStockAmount.setColumns(10);
		tFStockAmount.setBounds(126, 167, 86, 20);
		panel.add(tFStockAmount);

		lblStatus = new JLabel("Állapot");
		lblStatus.setBounds(41, 225, 46, 14);
		panel.add(lblStatus);

		btnExit = new JButton("Bezár");
		btnExit.setBackground(SystemColor.textHighlight);
		btnExit.setOpaque(false);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();

			}
		});
		btnExit.setBounds(343, 394, 89, 23);
		panel.add(btnExit);
		String status[] = { "Inaktív", "Aktív" };
		cBaStatus = new JComboBox(status);
		cBaStatus.setBounds(126, 221, 89, 22);
		panel.add(cBaStatus);

		btnSave = new JButton("Mentés");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveNewProduct();
				productListFrame.loadProduct();
				resetInputFields();
			}
		});
		btnSave.setBounds(41, 276, 89, 23);
		panel.add(btnSave);
		setVisible(true);

	}

	private void saveNewProduct() {
		Connection connection = new Database().CreateConnection();
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

		// eclipse rossz helyről importál: import com.mysql.jdbc.PreparedStatement;
		// helyesen java.sql
		// import java.sql.*
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, tFIdentityNumber.getText());
			ps.setString(2, tFName.getText());
			ps.setDouble(3, Double.parseDouble(tFNetPrice.getText()));
			ps.setInt(4, Integer.parseInt((tFStockAmount.getText())));
			ps.setInt(5, cBaStatus.getSelectedIndex());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void resetInputFields() {
		tFIdentityNumber.setText("");
		tFName.setText("");
		tFNetPrice.setText("");
		tFStockAmount.setText("");
		cBaStatus.setSelectedIndex(0);
	}
	
}
