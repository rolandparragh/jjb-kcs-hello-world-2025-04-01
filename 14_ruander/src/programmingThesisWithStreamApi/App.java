package programmingThesisWithStreamApi;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.OptionalDouble;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class App {

	private JFrame frmStreamApi;
	private JLabel lblRandomNumbers;
	@SuppressWarnings("rawtypes")
	private JList listRandomNumbers;
	private List<Integer> numbers = new ArrayList<>();
	DefaultListModel<Integer> listModel;
	private JButton btnGenerateRandomNumbers;
	private JButton btnSum;
	private JButton btnAvg;
	private JButton btnSortAscending;
	private JButton btnsSortDecending;
	private JButton btnDividedByThree;
	private JLabel lblResult;
	private JButton btnMin;
	private JButton btnMax;
	private JButton btnExit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App window = new App();
					window.frmStreamApi.setVisible(true);
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
		frmStreamApi = new JFrame();
		frmStreamApi.setTitle("Programozási tételek- StreamAPI");
		frmStreamApi.setBounds(100, 100, 911, 611);
		frmStreamApi.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmStreamApi.getContentPane().setLayout(null);

		listRandomNumbers = new JList();
		listRandomNumbers.setFont(new Font("Tahoma", Font.PLAIN, 14));
		listRandomNumbers.setBounds(10, 81, 187, 481);
		// padding
		listRandomNumbers.setBorder(new EmptyBorder(50, 70, 10, 10));
		frmStreamApi.getContentPane().add(listRandomNumbers);

		lblRandomNumbers = new JLabel("20 véletlen szám (1-100)");
		lblRandomNumbers.setHorizontalAlignment(SwingConstants.CENTER);
		lblRandomNumbers.setFont(new Font("Arial", Font.BOLD, 14));
		lblRandomNumbers.setBounds(10, 11, 187, 63);
		frmStreamApi.getContentPane().add(lblRandomNumbers);

		btnGenerateRandomNumbers = new JButton("Véletlen számok generálása");
		btnGenerateRandomNumbers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numbers = fillNumber();
				fillListModel(numbers);

				btnGenerateRandomNumbers.setEnabled(false);
				btnAvg.setEnabled(true);
				btnDividedByThree.setEnabled(true);
				btnMax.setEnabled(true);
				btnMin.setEnabled(true);
				btnSortAscending.setEnabled(true);
				btnsSortDecending.setEnabled(true);
				btnSum.setEnabled(true);
			}
		});
		btnGenerateRandomNumbers.setBounds(260, 11, 251, 54);
		frmStreamApi.getContentPane().add(btnGenerateRandomNumbers);

		btnSum = new JButton("Összeg");
		btnSum.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JOptionPane.showMessageDialog(frmStreamApi, "A lista összege: " + sumOfNumbers(numbers), "Összeg",
						JOptionPane.PLAIN_MESSAGE);
			}
		});
		btnSum.setEnabled(false);
		btnSum.setBounds(260, 91, 251, 54);
		frmStreamApi.getContentPane().add(btnSum);

		btnsSortDecending = new JButton("Rendezés - csökkenő");
		btnsSortDecending.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sortNumbersDesc(numbers);
				fillListModel(numbers);
			}
		});
		btnsSortDecending.setEnabled(false);
		btnsSortDecending.setBounds(595, 91, 251, 54);
		frmStreamApi.getContentPane().add(btnsSortDecending);

		btnSortAscending = new JButton("Rendezés - növekvő");
		btnSortAscending.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sortNumbersAsc(numbers);
				fillListModel(numbers);
			}
		});
		btnSortAscending.setEnabled(false);
		btnSortAscending.setBounds(595, 11, 251, 54);
		frmStreamApi.getContentPane().add(btnSortAscending);

		btnAvg = new JButton("Átlag");
		btnAvg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblResult.setText("Átlag: " + getAvgOfNumbers(numbers).getAsDouble());
				lblResult.setVisible(true);

			}
		});
		btnAvg.setEnabled(false);
		btnAvg.setBounds(260, 175, 251, 54);
		frmStreamApi.getContentPane().add(btnAvg);

		btnDividedByThree = new JButton("3-mal oszthatóak darabszáma");
		btnDividedByThree.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JOptionPane.showMessageDialog(frmStreamApi, "A hárommal maradék nélkül osztható számok darabszáma: "+dividedByThree(numbers),"Maradék nélkül hárommal osztható számok darabszáma"
				,JOptionPane.PLAIN_MESSAGE);
				
			}
			
		});
		btnDividedByThree.setEnabled(false);
		btnDividedByThree.setBounds(595, 175, 251, 54);
		frmStreamApi.getContentPane().add(btnDividedByThree);

		btnMin = new JButton("Legkisebb elem értéke / indexe");
		btnMin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Integer min = getMinFromNumbers(numbers);
				String result = min + ", index utolsó előfordulása: " + numbers.lastIndexOf(min);
				JOptionPane.showMessageDialog(frmStreamApi, "A legkisebb elem értéke: " + result,
						"Legkisebb elem értéke / indexe", JOptionPane.PLAIN_MESSAGE);
			}
		});
		btnMin.setEnabled(false);
		btnMin.setBounds(260, 423, 251, 54);
		frmStreamApi.getContentPane().add(btnMin);

		btnMax = new JButton("Legnagyobb elem értéke / indexe");
		btnMax.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Integer max = getMaxFromNumbers(numbers);
				String maxResult = max + ", indexe utolsó előfordulása: " + numbers.lastIndexOf(max);
				JOptionPane.showMessageDialog(frmStreamApi, "A legnagyobb elem értéke: " + maxResult,
						"Legnagyobb elem értéke / indexe", JOptionPane.PLAIN_MESSAGE);

			}
		});
		btnMax.setEnabled(false);
		btnMax.setBounds(260, 508, 251, 54);
		frmStreamApi.getContentPane().add(btnMax);

		lblResult = new JLabel("");
		lblResult.setVisible(false);
		lblResult.setForeground(SystemColor.window);
		lblResult.setBackground(Color.GREEN);
		lblResult.setOpaque(true);
		lblResult.setHorizontalAlignment(SwingConstants.CENTER);
		lblResult.setBounds(260, 251, 585, 108);
		frmStreamApi.getContentPane().add(lblResult);

		btnExit = new JButton("KILÉP");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setForeground(Color.WHITE);
		btnExit.setBackground(Color.RED);
		btnExit.setBounds(687, 485, 198, 77);
		frmStreamApi.getContentPane().add(btnExit);
	}

	// 1.lépés Arraylist feltöltése véletlen számokkal
	private List<Integer> fillNumber() {
		Random random = new Random();

		for (int i = 0; i < 20; i++) {
			numbers.add(random.nextInt(100) + 1);
		}

		return numbers;
	}

	@SuppressWarnings("unchecked")
	private void fillListModel(List<Integer> numbers) {
		listModel = new DefaultListModel<Integer>();
		for (Integer number : numbers) {
			listModel.addElement(number);
		}
		listRandomNumbers.setModel(listModel);
	}

	/*
	 * //hagyományos módszer összegzés tétele private int sumOfNumbers(List<Integer>
	 * numbers) { int sum =0; for (int i = 0; i < numbers.size(); i++) { sum
	 * +=numbers.get(i); } return sum; }
	 */
	private int sumOfNumbers(List<Integer> numbers) {

		return numbers.stream().mapToInt(x -> x.intValue()).sum();
	}

	private OptionalDouble getAvgOfNumbers(List<Integer> numbers) {
		return numbers.stream().mapToInt(x -> x.intValue()).average();
	}

	private Integer getMinFromNumbers(List<Integer> numbers) {
		return numbers.stream().min(Integer::compareTo).orElse(0);
	}

	private void sortNumbersAsc(List<Integer> numbers) {
		Collections.sort(numbers);
	}

	private void sortNumbersDesc(List<Integer> numbers) {
		Collections.sort(numbers, Collections.reverseOrder());
	}

	private Integer getMaxFromNumbers(List<Integer> numbers) {
		return numbers.stream().max(Integer::compareTo).orElse(0);
	}

	private int dividedByThree(List<Integer> numbers) {
		return (int)numbers.stream()
        .filter(x -> x % 3 == 0)
        .count();
	}
}
