package mouseEventsExample;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class App {

	private JFrame frmMouseEvents;
	private JLabel lblMouseEvent;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App window = new App();
					window.frmMouseEvents.setVisible(true);
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
		frmMouseEvents = new JFrame();
		frmMouseEvents.setTitle("Egéresemények");
		frmMouseEvents.setBounds(100, 100, 832, 550);
		frmMouseEvents.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMouseEvents.getContentPane().setLayout(null);
		
		lblMouseEvent = new JLabel("Húzzuk ide az egeret! ");
		lblMouseEvent.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				updateResultLable("Egér belépett a területre", Color.cyan, Color.magenta);
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				updateResultLable("Egér kilépett a területről", Color.blue, Color.white);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				updateResultLable("Kattintás történt", Color.yellow, Color.black);

			}
		});
		lblMouseEvent.setBackground(SystemColor.activeCaption);
		lblMouseEvent.setOpaque(true);
		lblMouseEvent.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMouseEvent.setHorizontalAlignment(SwingConstants.CENTER);
		lblMouseEvent.setBounds(0, 0, 409, 511);
		frmMouseEvents.getContentPane().add(lblMouseEvent);
	}
	
	private void updateResultLable(String message, Color backgroundColor, Color foregroundColor)
	{
		lblMouseEvent.setText(message);
		lblMouseEvent.setBackground(backgroundColor);
		lblMouseEvent.setForeground(foregroundColor);
		
	}

}
