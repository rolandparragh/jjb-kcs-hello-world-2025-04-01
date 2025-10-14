package firstGuiApp;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

public class Salute {

	private JFrame frmSalute;
	private JLabel lbResult;
	private JButton btnPrintResult;
	private JTextField tfName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Salute window = new Salute();
					window.frmSalute.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Salute() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSalute = new JFrame();
		frmSalute.setTitle("Üdvözlő alkalmazás");
		lbResult = new JLabel("");
		lbResult.setBackground(SystemColor.activeCaption);
		lbResult.setHorizontalAlignment(SwingConstants.CENTER);
		lbResult.setFont(new Font("Arial", Font.PLAIN, 16));
		lbResult.setBounds(202, 189, 480, 42);

		frmSalute.getContentPane().add(lbResult);
		// x y szél mag

		frmSalute.setBounds(400, 250, 870, 370);
		frmSalute.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSalute.getContentPane().setLayout(null);

		JLabel lblName = new JLabel("Név:");
		lblName.setFont(new Font("Arial", Font.PLAIN, 22));
		lblName.setBounds(94, 14, 98, 42);
		frmSalute.getContentPane().add(lblName);

		tfName = new JTextField();
		tfName.setFont(new Font("Arial", Font.PLAIN, 22));
		tfName.setHorizontalAlignment(SwingConstants.CENTER);
		tfName.setBounds(202, 14, 480, 42);
		frmSalute.getContentPane().add(tfName);
		tfName.setColumns(10);

		btnPrintResult = new JButton("ÜDVÖZLÉS");
		btnPrintResult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lbResult.setForeground(Color.BLACK);
				if (tfName.getText().isEmpty()) {

					lbResult.setText("Kérlek, adj meg egy nevet!");
					lbResult.setBackground(Color.RED);
					lbResult.setForeground(Color.WHITE);
					lbResult.setOpaque(true);
				} else {

					lbResult.setText("Üdvözöllek, " + tfName.getText() + "!");
					lbResult.setBackground(Color.GREEN);
					lbResult.setOpaque(true);
				}
			}
		});
		btnPrintResult.setForeground(SystemColor.desktop);
		btnPrintResult.setBackground(UIManager.getColor("infoText"));
		btnPrintResult.setFont(new Font("Arial", Font.PLAIN, 16));
		btnPrintResult.setBounds(333, 115, 170, 42);
		frmSalute.getContentPane().add(btnPrintResult);

		// Amennyiben nem ír be nevet piros háttérrel és fehér betűszinnel írjuk ki
		// hibaüzenetet!
		// Ha helyes akkor zöld színű háttér fekete betűszínnel
		// üdvööllek xy!!
	}
}
