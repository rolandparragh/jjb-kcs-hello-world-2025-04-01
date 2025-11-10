package practice1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JCheckBox;

public class App {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App window = new App();
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
	public App() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 503, 588);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ferm1 ");
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(Color.RED);
		lblNewLabel.setBounds(0, 11, 477, 35);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Timer");
		lblNewLabel_1.setBounds(0, 69, 487, 35);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(0, 130, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(99, 130, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.setBounds(198, 130, 89, 23);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("New button");
		btnNewButton_3.setBounds(297, 130, 89, 23);
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("New button");
		btnNewButton_4.setBounds(388, 130, 89, 23);
		frame.getContentPane().add(btnNewButton_4);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(20, 164, 46, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("New label");
		lblNewLabel_2_1.setBounds(109, 164, 46, 14);
		frame.getContentPane().add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("New label");
		lblNewLabel_2_2.setBounds(208, 164, 46, 14);
		frame.getContentPane().add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("New label");
		lblNewLabel_2_3.setBounds(317, 164, 46, 14);
		frame.getContentPane().add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_2_4 = new JLabel("New label");
		lblNewLabel_2_4.setBounds(398, 164, 46, 14);
		frame.getContentPane().add(lblNewLabel_2_4);
		
		JLabel lblNewLabel_3 = new JLabel("Ferm1 ");
		lblNewLabel_3.setOpaque(true);
		lblNewLabel_3.setBackground(Color.RED);
		lblNewLabel_3.setBounds(0, 189, 477, 35);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_1_1 = new JLabel("Timer");
		lblNewLabel_1_1.setBounds(0, 247, 487, 35);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JButton btnNewButton_5 = new JButton("New button");
		btnNewButton_5.setBounds(0, 308, 89, 23);
		frame.getContentPane().add(btnNewButton_5);
		
		JButton btnNewButton_1_1 = new JButton("New button");
		btnNewButton_1_1.setBounds(99, 308, 89, 23);
		frame.getContentPane().add(btnNewButton_1_1);
		
		JButton btnNewButton_2_1 = new JButton("New button");
		btnNewButton_2_1.setBounds(198, 308, 89, 23);
		frame.getContentPane().add(btnNewButton_2_1);
		
		JButton btnNewButton_3_1 = new JButton("New button");
		btnNewButton_3_1.setBounds(297, 308, 89, 23);
		frame.getContentPane().add(btnNewButton_3_1);
		
		JButton btnNewButton_4_1 = new JButton("New button");
		btnNewButton_4_1.setBounds(388, 308, 89, 23);
		frame.getContentPane().add(btnNewButton_4_1);
		
		JLabel lblNewLabel_2_5 = new JLabel("New label");
		lblNewLabel_2_5.setBounds(20, 342, 46, 14);
		frame.getContentPane().add(lblNewLabel_2_5);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("New label");
		lblNewLabel_2_1_1.setBounds(109, 342, 46, 14);
		frame.getContentPane().add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("New label");
		lblNewLabel_2_2_1.setBounds(208, 342, 46, 14);
		frame.getContentPane().add(lblNewLabel_2_2_1);
		
		JLabel lblNewLabel_2_3_1 = new JLabel("New label");
		lblNewLabel_2_3_1.setBounds(317, 342, 46, 14);
		frame.getContentPane().add(lblNewLabel_2_3_1);
		
		JLabel lblNewLabel_2_4_1 = new JLabel("New label");
		lblNewLabel_2_4_1.setBounds(398, 342, 46, 14);
		frame.getContentPane().add(lblNewLabel_2_4_1);
	}
}
