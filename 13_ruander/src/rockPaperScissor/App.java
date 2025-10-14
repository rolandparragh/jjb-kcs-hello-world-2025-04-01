package rockPaperScissor;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class App {

	private JFrame frame;
	private JLabel lblPlayer;
	private JComboBox cBoxPlayerChoice;
	private JLabel lblComputer;
	private JLabel lblComputerChoice;
	private JLabel lblresult;
	Game game = new Game();
	Computer computer = new Computer();

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
		
		
		//frame
		frame = new JFrame();
		frame.setBounds(100, 100, 833, 465);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//end frame
		//Player
		
		lblPlayer = new JLabel("Játékos");
		lblPlayer.setBounds(52, 34, 62, 30);
		frame.getContentPane().add(lblPlayer);
		
		cBoxPlayerChoice = new JComboBox();
		cBoxPlayerChoice.setBounds(134, 38, 109, 22);
		frame.getContentPane().add(cBoxPlayerChoice);
		cBoxPlayerChoice.setModel(new DefaultComboBoxModel<>(Choosable.options));
		
		//end player
		// comp
		lblComputer = new JLabel("Gép");
		lblComputer.setBounds(548, 34, 59, 30);
		frame.getContentPane().add(lblComputer);
		
		lblComputerChoice = new JLabel("New label");
		lblComputerChoice.setVisible(false);
		lblComputerChoice.setBounds(627, 34, 99, 30);
		frame.getContentPane().add(lblComputerChoice);
		
		
		//end comp
		//result
		lblresult = new JLabel("New label");
		lblresult.setOpaque(true);
		lblresult.setVisible(false);
		lblresult.setBounds(217, 209, 429, 43);
		lblresult.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblresult.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblresult);
		
		JButton btnPlay = new JButton("Játék");
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblComputerChoice.setText(computer.chosen());
				lblComputerChoice.setVisible(true);
				lblresult.setVisible(true);
				String player = (String) cBoxPlayerChoice.getSelectedItem();
				String computer = lblComputerChoice.getText();

				if (player == null || computer == null || player.isEmpty() || computer.isEmpty()) {
				    lblresult.setText("Hiányzó választás!");
				    return;
				}

				lblresult.setText(Game.decideWinner(player, computer));

			}
		});
		btnPlay.setBounds(400, 175, 162, 23);
		btnPlay.setForeground(SystemColor.activeCaption);
		frame.getContentPane().add(btnPlay);
		
		//end result
	}
}
