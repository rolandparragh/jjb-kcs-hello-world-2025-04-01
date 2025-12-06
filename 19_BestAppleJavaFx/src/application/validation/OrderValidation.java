package application.validation;

import javafx.scene.control.TextField;

public class OrderValidation {

	// Java varargs - változó számú paraméterre alkalmazható
	// isValid(tfName);
	// isValid(tfName, tfEmail);
	public boolean isValid(TextField... fields) {
		for (TextField textField : fields) {
			if (textField.getText() == null || textField.getText().trim().isEmpty()) {
				return false; // early return
			}
		}
		try {
			int amount = Integer.parseInt(fields[fields.length - 1].getText());
			return amount>0;
		} catch (NumberFormatException e) {
			return false;
		}
	}	
	
}
