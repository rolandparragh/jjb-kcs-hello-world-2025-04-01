package bicycleShop;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.util.Comparator;
import java.util.NoSuchElementException;
import javax.swing.SwingConstants;

public class App {

	private JFrame frmBicycle;
	private JTable tblBicycle;
	private JButton btnCheapestMTB;
	private JButton btnNumberOfChildrenBicycles;
	private JButton btnTrekkingWriteFile;
	private JButton btnreadFile;
	private JButton btnRemoveIncorrectData;
	private JButton btnExit;

	private List<Bicycle> bicycles;
	private FileHandler fileHandler = new FileHandler();
	private JLabel lblChildrenBicycleCount;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		BicycleUtils bicycleUtils = new BicycleUtils();
		bicycleUtils.readFile();
		bicycleUtils.outputBicycleList();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App window = new App();
					window.frmBicycle.setVisible(true);
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
		frmBicycle = new JFrame();
		frmBicycle.setTitle("Kerékpárbolt ");
		frmBicycle.setBounds(100, 100, 1002, 691);
		frmBicycle.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBicycle.getContentPane().setLayout(null);

		btnreadFile = new JButton("Fájlbeolvasás");
		btnreadFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				BicycleUtils bicycleUtils = new BicycleUtils();
				bicycles = bicycleUtils.readFile("data_bicycle/bicycles.csv");
				DefaultTableModel model = getModelByBicycleArrayList();
				tblBicycle.setModel(model);

				btnCheapestMTB.setEnabled(true);
				btnNumberOfChildrenBicycles.setEnabled(true);
				btnTrekkingWriteFile.setEnabled(true);
				btnreadFile.setEnabled(true);
				btnRemoveIncorrectData.setEnabled(true);
				btnreadFile.setEnabled(false);
				btnRemoveIncorrectData.setEnabled(true);

			}
		});
		btnreadFile.setForeground(SystemColor.textHighlight);
		btnreadFile.setBackground(SystemColor.activeCaption);
		btnreadFile.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnreadFile.setBounds(697, 316, 279, 53);
		frmBicycle.getContentPane().add(btnreadFile);

		btnRemoveIncorrectData = new JButton("Hibás adat törlése");
		btnRemoveIncorrectData.setEnabled(false);
		btnRemoveIncorrectData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// removeRowWithWrongId();
				// System.out.println(getBicycleWrongPartNumber());
				deleteBicycleWrongPartNumber();
				System.out.println("incorrect data has been removed");
				btnRemoveIncorrectData.setEnabled(false);
			}
		});
		btnRemoveIncorrectData.setForeground(SystemColor.textHighlight);
		btnRemoveIncorrectData.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRemoveIncorrectData.setBackground(SystemColor.activeCaption);
		btnRemoveIncorrectData.setBounds(697, 380, 279, 53);
		frmBicycle.getContentPane().add(btnRemoveIncorrectData);

		btnCheapestMTB = new JButton("Legolcsóbb használt MTB");
		btnCheapestMTB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Bicycle cheapestUsedMtb = cheapestMTB();
				showOptionPane(frmBicycle, "Legolcsóbb használt mtn neve és ára:  " + cheapestUsedMtb.getName() + ""
						+ " / " + cheapestUsedMtb.getPrice() + " Ft", "Legolcsóbb használt mtb név/ár");
			}
		});
		btnCheapestMTB.setEnabled(false);
		btnCheapestMTB.setForeground(SystemColor.textHighlight);
		btnCheapestMTB.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCheapestMTB.setBackground(SystemColor.activeCaption);
		btnCheapestMTB.setBounds(20, 316, 279, 53);
		frmBicycle.getContentPane().add(btnCheapestMTB);

		btnNumberOfChildrenBicycles = new JButton("Gyerek kerékpárok száma");
		btnNumberOfChildrenBicycles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Number count = childrenBicycle();
				lblChildrenBicycleCount.setVisible(true);
				lblChildrenBicycleCount.setText(count.toString());

			}
		});
		btnNumberOfChildrenBicycles.setEnabled(false);
		btnNumberOfChildrenBicycles.setForeground(SystemColor.textHighlight);
		btnNumberOfChildrenBicycles.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNumberOfChildrenBicycles.setBackground(SystemColor.activeCaption);
		btnNumberOfChildrenBicycles.setBounds(20, 397, 279, 53);
		frmBicycle.getContentPane().add(btnNumberOfChildrenBicycles);

		btnTrekkingWriteFile = new JButton("Trekking - fréfi fájlbaír");
		btnTrekkingWriteFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<Bicycle> trekkingBikes = trekkingMaleBikes();
				fileHandler.writeBicycleFile(trekkingBikes, "data_bicycle/trekking_ferfi.csv", ';');
				showOptionPane(frmBicycle, "Sikeres fájl létrehozás", "Fájlbaírás sikeres");

			}
		});
		btnTrekkingWriteFile.setEnabled(false);
		btnTrekkingWriteFile.setForeground(SystemColor.textHighlight);
		btnTrekkingWriteFile.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnTrekkingWriteFile.setBackground(SystemColor.activeCaption);
		btnTrekkingWriteFile.setBounds(20, 490, 279, 53);
		frmBicycle.getContentPane().add(btnTrekkingWriteFile);

		btnExit = new JButton("Kilépés");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setForeground(Color.WHITE);
		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnExit.setBackground(Color.RED);
		btnExit.setBounds(780, 588, 196, 53);
		frmBicycle.getContentPane().add(btnExit);

		JScrollPane spBicycle = new JScrollPane();
		spBicycle.setBounds(20, 11, 956, 221);
		frmBicycle.getContentPane().add(spBicycle);

		tblBicycle = new JTable();
		spBicycle.setViewportView(tblBicycle);

		lblChildrenBicycleCount = new JLabel("New label");
		lblChildrenBicycleCount.setVisible(false);
		lblChildrenBicycleCount.setForeground(SystemColor.window);
		lblChildrenBicycleCount.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblChildrenBicycleCount.setHorizontalTextPosition(SwingConstants.CENTER);
		lblChildrenBicycleCount.setHorizontalAlignment(SwingConstants.CENTER);
		lblChildrenBicycleCount.setBackground(SystemColor.activeCaption);
		lblChildrenBicycleCount.setOpaque(true);
		lblChildrenBicycleCount.setBounds(309, 397, 219, 53);
		frmBicycle.getContentPane().add(lblChildrenBicycleCount);
	}

	private DefaultTableModel getModelByBicycleArrayList() {
		DefaultTableModel model = new DefaultTableModel(
				new Object[] { "Cikkszám", "Név", "Típus", "Ár", "Használt", "Kategória", "Rögzítés dátuma" }, 0);
		for (Bicycle bicycle : bicycles) {
			model.addRow(new Object[] { bicycle.getPartNumber(), bicycle.getName(), bicycle.getType(),
					bicycle.getPrice(), bicycle.getUsedText(), bicycle.getCategoryText(), bicycle.getCreatedDate() });
		}

		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		tblBicycle.setDefaultRenderer(Object.class, centerRenderer);
		return model;
	}

	/*
	 * jó megoldás de lehet tovább bontani, előbb index, majd törlés 2 metódusban
	 * private void removeRowWithWrongId() { DefaultTableModel model =
	 * (DefaultTableModel) tblBicycle.getModel(); for (int i = model.getRowCount() -
	 * 1; i >= 0; i--) { Object cellValue = model.getValueAt(i, 0); if (cellValue ==
	 * null || !Pattern.matches("[0-9]{6}", cellValue.toString())) {
	 * model.removeRow(i); bicycles.remove(i); } } }
	 */
	private int getBicycleWrongPartNumber() {
		int wrongPartNumberIndex = -1;
		for (int i = 0; i < bicycles.size(); i++) {
			if (bicycles.get(i).getPartNumber() == null
					|| !Pattern.matches("[0-9]{6}", bicycles.get(i).getPartNumber().toString())) {
				wrongPartNumberIndex = i;
			}
		}
		return wrongPartNumberIndex;
	}

	private void deleteBicycleWrongPartNumber() {
		int wrongPartNumberIndex = getBicycleWrongPartNumber();
		bicycles.remove(wrongPartNumberIndex);
		((DefaultTableModel) tblBicycle.getModel()).removeRow(wrongPartNumberIndex);
	}

	private Bicycle cheapestMTB() {
		return bicycles.stream().filter(b -> b.getType().equalsIgnoreCase("mtb")).filter(x -> x.isUsed() == true)
				.min(Comparator.comparing(Bicycle::getPrice)).orElseThrow(NoSuchElementException::new);
	}

	private Number childrenBicycle() {
		long count = bicycles.stream().filter(b -> b.getCategoryText().equalsIgnoreCase("gyermek")).count();
		return count > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) count;
	}

	private List<Bicycle> trekkingMaleBikes() {
		List<Bicycle> trekkingBikes = bicycles.stream()
				.filter(b -> b.getType().equalsIgnoreCase("trekking") && b.getCategoryText().equalsIgnoreCase("férfi"))
				.toList();

		return trekkingBikes;

	}

	private void showOptionPane(JFrame frmName, String messageBody, String messageTitle) {
		JOptionPane.showMessageDialog(frmName, messageBody, messageTitle, JOptionPane.PLAIN_MESSAGE);
	}
}
