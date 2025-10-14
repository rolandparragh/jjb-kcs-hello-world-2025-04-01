package rectangleExample;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class RectangleCalculate {

	private JFrame frame;
	private JLabel lblSideA;
	private JTextField txtfSideA;
	private JLabel lblSideB;
	private JTextField txtfSideB;
	private JButton btnCalculate;
	private JButton btnExit;
	private JLabel lblResult;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RectangleCalculate window = new RectangleCalculate();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RectangleCalculate() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 689, 417);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		lblSideA = new JLabel("A oldal");
		lblSideA.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblSideA.setBounds(38, 39, 46, 14);
		frame.getContentPane().add(lblSideA);

		lblSideB = new JLabel("B oldal");
		lblSideB.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblSideB.setBounds(38, 71, 46, 14);
		frame.getContentPane().add(lblSideB);

		txtfSideA = new JTextField();
		txtfSideA.setHorizontalAlignment(SwingConstants.CENTER);
		txtfSideA.setBounds(129, 36, 86, 20);
		frame.getContentPane().add(txtfSideA);
		txtfSideA.setColumns(10);

		txtfSideB = new JTextField();
		txtfSideB.setHorizontalAlignment(SwingConstants.CENTER);
		txtfSideB.setBounds(129, 68, 86, 20);
		frame.getContentPane().add(txtfSideB);
		txtfSideB.setColumns(10);

		btnCalculate = new JButton("Számítás");
		btnCalculate.setForeground(SystemColor.inactiveCaptionBorder);
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblResult.setVisible(true);
				lblResult.setOpaque(true);
				String sideA = txtfSideA.getText().trim().replace(',', '.');
				String sideB = txtfSideB.getText().trim().replace(',', '.');

				
				double area = 0;
				double perimeter = 0;
				try {
					if (sideA.isEmpty() || sideB.isEmpty()) {
						lblResult.setBackground(Color.red);
						outputText("Hiányzó adat");

					}
				else {
					area = calculateArea(Double.parseDouble(sideA), Double.parseDouble(sideB));
					perimeter = calculatePerimeter(Double.parseDouble(sideA), Double.parseDouble(sideB));
					lblResult.setBackground(Color.green);
					outputText(perimeter, area);}
				} catch (NumberFormatException e1) {
					lblResult.setBackground(Color.red);
					outputText("hibás Adat");
				}

			}
		});
		btnCalculate.setBackground(SystemColor.activeCaption);
		btnCalculate.setFont(new Font("Calibri", Font.PLAIN, 14));
		btnCalculate.setBounds(61, 99, 89, 23);
		frame.getContentPane().add(btnCalculate);

		lblResult = new JLabel("");
		lblResult.setHorizontalAlignment(SwingConstants.CENTER);
		lblResult.setVisible(false);
		lblResult.setBounds(38, 133, 177, 46);
		frame.getContentPane().add(lblResult);

		btnExit = new JButton("Kilép");
		btnExit.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				//exit codes: 0 --felhasználói kezdeményezés 
				System.exit(0);
			}

		});
		btnExit.setFont(new Font("Calibri", Font.PLAIN, 14));
		btnExit.setBounds(126, 185, 89, 23);
		frame.getContentPane().add(btnExit);
	}

	private double calculateArea(double a, double b) {
		return a * b;

	}

	private double calculatePerimeter(double a, double b) {

		return 2 * (a + b);

	}

	private void outputText(String message) {
		lblResult.setText(message);
		
	}

	private void outputText(double area, double perimeter) {
		lblResult.setText("Kerület: " + area + ", terület: " + perimeter);
	}

}
