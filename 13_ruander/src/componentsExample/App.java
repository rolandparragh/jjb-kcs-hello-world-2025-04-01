package componentsExample;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.awt.Color;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JPasswordField;
import javax.swing.JToggleButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextArea;

public class App {

	private JFrame frmComponents;
	private JLabel lblName;
	private JComboBox cbFruits;
	private JButton btnPrintFruitResult;
	private JPanel panelFruit;
	private JLabel lbFruitResult;
	ButtonGroup cars;
	ButtonGroup carsType;
	private JButton btnCarOutput;
	private JLabel lblCar;
	private JCheckBox chckbxNewsLetter;
	private JButton btnPrintNewsLetter;
	private JLabel lblNewsLetter;
	private JPanel panelPassword;
	private JLabel lblToggleResult;
	private JToggleButton tglbtnActive;
	private JPanel panelToggle;
	private JTextArea txtrComment;
	private JLabel lblComment;
	private JButton btnPrintCommentResult;
	private JLabel lblCommentResult;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App window = new App();
					window.frmComponents.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public App() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void initialize() {
		frmComponents = new JFrame();
		frmComponents.setTitle("Komponensek példa");
		frmComponents.setBounds(100, 100, 938, 569);
		frmComponents.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmComponents.getContentPane().setLayout(null);

		panelFruit = new JPanel();
		panelFruit.setBounds(37, 25, 850, 125);
		frmComponents.getContentPane().add(panelFruit);
		panelFruit.setLayout(null);

		lblName = new JLabel("Név");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblName.setBounds(10, 25, 52, 33);
		panelFruit.add(lblName);

		cbFruits = new JComboBox();
		cbFruits.setModel(new DefaultComboBoxModel(
				new String[] { "alma", "szilva", "körte", "eper", "dinnye", "paradicsom", "barack" }));

		cbFruits.setBounds(312, 27, 155, 33);
		panelFruit.add(cbFruits);

		JTextField tfName = new JTextField();
		tfName.setHorizontalAlignment(SwingConstants.CENTER);
		tfName.setBounds(61, 27, 212, 33);
		panelFruit.add(tfName);
		tfName.setColumns(10);

		btnPrintFruitResult = new JButton("Kedvenc gyümölcs");
		btnPrintFruitResult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String name = tfName.getText();
				String fruit = (String) cbFruits.getSelectedItem();
				int index = cbFruits.getSelectedIndex();
				if (!name.isEmpty()) {
					lbFruitResult.setText(name + " kedvenc gyümölcse a(z) " + fruit + " - indexe: " + index);
				} else {
					lbFruitResult.setText("Kérem adja meg a nevét!");
				}
			}
		});
		btnPrintFruitResult.setForeground(Color.WHITE);
		btnPrintFruitResult.setBackground(SystemColor.activeCaption);
		btnPrintFruitResult.setBounds(514, 32, 191, 23);
		panelFruit.add(btnPrintFruitResult);

		lbFruitResult = new JLabel("");
		lbFruitResult.setHorizontalAlignment(SwingConstants.CENTER);
		lbFruitResult.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbFruitResult.setBounds(148, 71, 514, 32);
		panelFruit.add(lbFruitResult);

		JPanel panelCars = new JPanel();
		panelCars.setBounds(37, 150, 850, 148);
		frmComponents.getContentPane().add(panelCars);
		panelCars.setLayout(null);

		cars = new ButtonGroup();
		carsType = new ButtonGroup();

		JRadioButton rdbtnHonda = new JRadioButton("Honda");
		rdbtnHonda.setActionCommand("honda");
		rdbtnHonda.setSelected(true);
		rdbtnHonda.setBounds(18, 17, 102, 29);
		rdbtnHonda.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panelCars.add(rdbtnHonda);

		JRadioButton rdbtnToyota = new JRadioButton("Toyota");
		rdbtnToyota.setActionCommand("toyota");
		rdbtnToyota.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnToyota.setBounds(18, 55, 102, 29);
		panelCars.add(rdbtnToyota);

		JRadioButton rdbtnNissan = new JRadioButton("Nissan");
		rdbtnNissan.setActionCommand("nissan");
		rdbtnNissan.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnNissan.setBounds(18, 98, 102, 29);
		panelCars.add(rdbtnNissan);

		JRadioButton rdbtnOther = new JRadioButton("Other");
		rdbtnOther.setActionCommand("other");
		rdbtnOther.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnOther.setBounds(142, 98, 102, 29);
		panelCars.add(rdbtnOther);

		JRadioButton rdbtnSuv = new JRadioButton("SUV");
		rdbtnSuv.setActionCommand("suv");
		rdbtnSuv.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnSuv.setBounds(142, 55, 102, 29);
		panelCars.add(rdbtnSuv);

		JRadioButton rdbtnSedan = new JRadioButton("Sedan");
		rdbtnSedan.setActionCommand("sedan");
		rdbtnSedan.setSelected(true);
		rdbtnSedan.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnSedan.setBounds(142, 17, 102, 29);
		panelCars.add(rdbtnSedan);

		cars.add(rdbtnHonda);
		cars.add(rdbtnToyota);
		cars.add(rdbtnNissan);
		carsType.add(rdbtnSedan);
		carsType.add(rdbtnSuv);
		carsType.add(rdbtnOther);

		btnCarOutput = new JButton("Autó kiír");
		btnCarOutput.setActionCommand("");
		btnCarOutput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// lblCar.setBackground(SystemColor.activeCaption);

				String result = "Márka :" + cars.getSelection().getActionCommand() + ", kategória: "
						+ carsType.getSelection().getActionCommand();

				lblCar.setText(result);
				lblCar.setVisible(true);

			}
		});
		btnCarOutput.setBounds(322, 22, 89, 23);
		panelCars.add(btnCarOutput);

		lblCar = new JLabel("");
		lblCar.setVisible(false);
		lblCar.setBackground(SystemColor.activeCaption);
		lblCar.setHorizontalAlignment(SwingConstants.CENTER);
		lblCar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCar.setBounds(409, 55, 255, 66);
		lblCar.setOpaque(true);
		panelCars.add(lblCar);

		JPanel panelNewsLetter = new JPanel();
		panelNewsLetter.setBounds(37, 297, 369, 78);
		frmComponents.getContentPane().add(panelNewsLetter);
		panelNewsLetter.setLayout(null);

		chckbxNewsLetter = new JCheckBox("Hírlevél");
		chckbxNewsLetter.setFont(new Font("Tahoma", Font.PLAIN, 16));
		chckbxNewsLetter.setBounds(6, 7, 104, 23);
		panelNewsLetter.add(chckbxNewsLetter);

		btnPrintNewsLetter = new JButton("Hírlevél kiír");
		btnPrintNewsLetter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNewsLetter.setVisible(true);
				
				Color color = null;
				String resultText = "Hírlevelet kérte? ";
				if (chckbxNewsLetter.isSelected()) {
					resultText += "igen";
					color = Color.GREEN;
				} else {
					resultText += "nem";
					color = Color.RED;
				}
				lblNewsLetter.setBackground(color);
				lblNewsLetter.setText(resultText);
			}
		});
		btnPrintNewsLetter.setBounds(142, 10, 104, 21);
		panelNewsLetter.add(btnPrintNewsLetter);

		lblNewsLetter = new JLabel("");
		lblNewsLetter.setVisible(false);
		lblNewsLetter.setOpaque(true);
		lblNewsLetter.setBounds(16, 37, 300, 36);
		panelNewsLetter.add(lblNewsLetter);
		
		panelPassword = new JPanel();
		panelPassword.setBounds(405, 297, 482, 78);
		frmComponents.getContentPane().add(panelPassword);
		panelPassword.setLayout(null);
		
		JLabel lblPassword = new JLabel("Jelszó:");
		lblPassword.setBounds(10, 11, 85, 23);
		panelPassword.add(lblPassword);
		
		JPasswordField pwdFieldPassword = new JPasswordField();
		pwdFieldPassword.setBounds(126, 11, 241, 23);
		panelPassword.add(pwdFieldPassword);
		
		panelToggle = new JPanel();
		panelToggle.setBounds(37, 375, 369, 90);
		frmComponents.getContentPane().add(panelToggle);
		panelToggle.setLayout(null);
		
		tglbtnActive = new JToggleButton("Aktív");
		tglbtnActive.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(tglbtnActive.isSelected()) {
					lblToggleResult.setText("Aktív");
				}
				else {
					lblToggleResult.setText("Inaktív");
				}
			}
		});
		tglbtnActive.setBackground(SystemColor.activeCaption);
		tglbtnActive.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tglbtnActive.setBounds(10, 11, 121, 23);
		panelToggle.add(tglbtnActive);
		
		lblToggleResult = new JLabel("");
		lblToggleResult.setHorizontalAlignment(SwingConstants.CENTER);
		lblToggleResult.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblToggleResult.setBounds(154, 11, 121, 23);
		panelToggle.add(lblToggleResult);
		
		JPanel panel = new JPanel();
		panel.setBounds(405, 375, 482, 133);
		frmComponents.getContentPane().add(panel);
		panel.setLayout(null);
		
		lblComment = new JLabel("Megjegyzés:");
		lblComment.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblComment.setBounds(10, 0, 98, 34);
		panel.add(lblComment);
		
		txtrComment = new JTextArea();
		txtrComment.setFont(new Font("Monospaced", Font.PLAIN, 11));
		txtrComment.setText("Megjegyzés");
		txtrComment.setBounds(10, 32, 225, 90);
		panel.add(txtrComment);
		
		btnPrintCommentResult = new JButton("Megjegyzés kiír ");
		btnPrintCommentResult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblCommentResult.setText(txtrComment.getText());
				
			}
		});
		btnPrintCommentResult.setBounds(254, 8, 127, 23);
		panel.add(btnPrintCommentResult);
		
		lblCommentResult = new JLabel("");
		lblCommentResult.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCommentResult.setHorizontalAlignment(SwingConstants.CENTER);
		lblCommentResult.setBounds(245, 32, 227, 90);
		panel.add(lblCommentResult);
	}
}
