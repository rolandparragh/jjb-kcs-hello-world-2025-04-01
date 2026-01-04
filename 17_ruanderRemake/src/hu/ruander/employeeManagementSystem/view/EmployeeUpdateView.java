package hu.ruander.employeeManagementSystem.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import hu.ruander.employeeManagementSystem.model.dto.EmployeeCategoryDto;
import hu.ruander.employeeManagementSystem.model.dto.EmployeeDto;

public class EmployeeUpdateView extends JFrame {

	private static final long serialVersionUID = -14759495489221324L;
	
	private JTextField tfFirstName;
	private JTextField tfLastName;
	private JTextField tfDateOfBirth;
	private JTextField tfIdentityCard;
	private JTextField tfSalary;
	private JComboBox<EmployeeCategoryDto> cmbCategory;
	private JCheckBox chkStatus;
	private JButton btnUpdate;
	private JButton btnCancel;

    private static final Font DEFAULT_FONT = new Font("Tahoma", Font.PLAIN, 22);
    private static final Insets DEFAULT_INSETS = new Insets(5, 5, 5, 5);
    private static final Color BUTTON_COLOR = SystemColor.activeCaption;
	
	public EmployeeUpdateView(List<EmployeeCategoryDto> employeeCategories, int id) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Dolgozó módosítás, id: " + id);
		setBounds(100, 100, 650, 450);

		// GridBagLayout beállítás
		setLayout(new GridBagLayout());

		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.insets = DEFAULT_INSETS;
		gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;

		String[] labels = { 
				"Vezetéknév",
				"Keresztnév",
				"Szülétési idő",
				"Szig. szám",
				"Fizetés",
				"Kategória",
				"Állapot" 
		};

        Component[] inputComponents = createInputComponents(employeeCategories);
        setTextFieldInputCenter(inputComponents);

        for (int i = 0; i < labels.length; i++) {
        	gridBagConstraints.gridx = 0;
        	gridBagConstraints.gridy = i;
            add(createLabel(labels[i]), gridBagConstraints);

            gridBagConstraints.gridx = 1;
            add(inputComponents[i], gridBagConstraints);
        }

        // Mégsem gomb
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = labels.length;
        btnCancel = createButton("MÉGSEM", Color.YELLOW);
        add(btnCancel, gridBagConstraints);

        // Módosít gomb
        gridBagConstraints.gridx = 1;
        btnUpdate = createButton("MÓDOSÍT", BUTTON_COLOR);
        add(btnUpdate, gridBagConstraints);

		setVisible(true);
	}
	
    private Component[] createInputComponents(List<EmployeeCategoryDto> employeeCategories) {
        tfLastName = createTextField();
        tfFirstName = createTextField();
        tfDateOfBirth = createTextField();
        tfIdentityCard = createTextField();
        tfSalary = createTextField();
        cmbCategory = createComboBox(employeeCategories);
        chkStatus = new JCheckBox();

        return new Component[]{
                tfLastName, tfFirstName, tfDateOfBirth,
                tfIdentityCard, tfSalary, cmbCategory, chkStatus
        };
    }
	
    private JLabel createLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(DEFAULT_FONT);
        return label;
    }

    private JTextField createTextField() {
        JTextField tf = new JTextField(10);
        tf.setFont(DEFAULT_FONT);
        return tf;
    }
	
    private JButton createButton(String text, Color background) {
        JButton button = new JButton(text);
        button.setFont(DEFAULT_FONT);
        button.setBackground(background);
        return button;
    }
	
	public JButton getBtnUpdate() {
		return btnUpdate;
	}

	public JButton getBtnCancel() {
		return btnCancel;
	}
	
	private void setTextFieldInputCenter(Component[] fields) {
		for (Component field : fields) {
            if (field instanceof JTextField) {
                ((JTextField) field).setHorizontalAlignment(SwingConstants.CENTER);
            }
        }
	}
	
    private JComboBox<EmployeeCategoryDto> createComboBox(List<EmployeeCategoryDto> categories) {
        JComboBox<EmployeeCategoryDto> comboBox = new JComboBox<>(
                new EmployeeCategoryComboBoxModel(categories)
        );
        comboBox.setFont(DEFAULT_FONT);
        return comboBox;
    }
	
	public void setEmployeeData(EmployeeDto employeeDto) {
		tfFirstName.setText(employeeDto.getFirstName());
		tfLastName.setText(employeeDto.getLastName());
        tfDateOfBirth.setText(employeeDto.getDateOfBirth().toString());
        tfIdentityCard.setText(employeeDto.getIdentityCard());
        tfSalary.setText(String.valueOf(employeeDto.getSalary()));
        cmbCategory.setSelectedIndex(employeeDto.getEmployeeCategory().getId()-1); //Javítás
        chkStatus.setSelected(employeeDto.isStatus());
	}
	
	public EmployeeDto getEmployeeInputData(int id) {
		EmployeeDto employeeDto = new EmployeeDto(
				id,
				tfFirstName.getText(),
				tfLastName.getText(),
				LocalDate.parse(tfDateOfBirth.getText()),
				tfIdentityCard.getText(),
				Integer.parseInt(tfSalary.getText()),
				(EmployeeCategoryDto)(cmbCategory.getSelectedItem()),
				chkStatus.isSelected(),
				false);
		return employeeDto;
	}

	public void updateEmployeeButtonListener(ActionListener listener) {
		btnUpdate.addActionListener(listener);
	}
	
	public void cancelUpdateEmployeeButtonListener(ActionListener listener) {
		btnCancel.addActionListener(listener);
	}
}
