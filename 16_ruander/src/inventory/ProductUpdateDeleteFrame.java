package inventory;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ProductUpdateDeleteFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public ProductUpdateDeleteFrame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(550, 80, 473, 486);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIdentityNumber = new JLabel("Leltárszám");
		lblIdentityNumber.setBounds(41, 14, 75, 14);
		contentPane.add(lblIdentityNumber);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(126, 11, 86, 20);
		contentPane.add(textField);
		
		JLabel lblName = new JLabel("Név");
		lblName.setBounds(41, 57, 46, 14);
		contentPane.add(lblName);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(126, 54, 86, 20);
		contentPane.add(textField_1);
		
		JLabel lblNetPrice = new JLabel("Ár:");
		lblNetPrice.setBounds(41, 111, 46, 14);
		contentPane.add(lblNetPrice);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(126, 108, 86, 20);
		contentPane.add(textField_2);
		
		JLabel lblStockAmount = new JLabel("Raktár mennyiség:");
		lblStockAmount.setBounds(10, 159, 106, 14);
		contentPane.add(lblStockAmount);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(126, 156, 86, 20);
		contentPane.add(textField_3);
		
		JLabel lblStatus = new JLabel("Állapot");
		lblStatus.setBounds(41, 214, 46, 14);
		contentPane.add(lblStatus);
		
		JComboBox cBaStatus = new JComboBox(new Object[]{});
		cBaStatus.setBounds(126, 210, 89, 22);
		contentPane.add(cBaStatus);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(41, 265, 89, 23);
		contentPane.add(btnUpdate);
		
		JButton btnExit = new JButton("Bezár");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnExit.setOpaque(false);
		btnExit.setBackground(SystemColor.textHighlight);
		btnExit.setBounds(343, 383, 89, 23);
		contentPane.add(btnExit);
		
		
		setVisible(true);

	}

}
