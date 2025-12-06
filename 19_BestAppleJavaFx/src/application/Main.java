package application;
	
import java.util.List;

import application.dao.OrderDao;
import application.dao.ProductDao;
import application.model.Order;
import application.model.Product;
import application.service.OrderService;
import application.validation.OrderValidation;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class Main extends Application {
	
	private GridPane root;
	private TextField tfName, tfEmail, tfPhone, tfAddress, tfCity, tfPostalCode,tfAmount;
	private CheckBox chkReducePrice;
	private ComboBox<Product> cmbProductTypes;
	private Button btnOrder;
	
	private final ProductDao productDao = new ProductDao();
	private final OrderDao orderDao = new OrderDao();
	
	@Override
	public void start(Stage primaryStage) {
		try {
			//Database database = new Database();
			//System.out.println(database.createConnection());
			
			// Code Challenge:
			// Alakítsuk ki a felületet a mintaképek szerint.
			// Ahol lehet használjunk ciklust, metódust a komponensek létrehozására!
			// Minden formázás (betűszín, betűméret, kinézet) a css-be kerüljön!
			// A pipálható mező kivételével mindegyik mező kötelező, készítsuk el a validációt!
			// Hiányzó adat esetén felugró ablakban (Alert) tájékoztassuk a felhasználót!
			// Amennyiben sikeres a validáció írjuk ki a vásárlás összértékét a minta szerint!
			// Sikeres DB mentést követően ürítsük ki a beviteli mezőket! 
			
			root = createFormLayout();
			String[] labels = generateLabelText();
			TextField[] fields = populateInputFields();
			String[] promptTexts = generatePromptText();

			for (int i = 0; i < labels.length; i++) {
				createTextFieldInput(labels[i], fields[i], promptTexts[i], i);
			}
			
			createProductComboBox(labels.length);
			createReducePriceCheckBox(labels.length + 1);
			createOrderButton(labels.length+2);
			
			
			Scene scene = new Scene(root,1000,700);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			primaryStage.setTitle("BestApple - Almarendelés");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	private GridPane createFormLayout() {
		GridPane pane = new GridPane();
		pane.setAlignment(Pos.CENTER);
		pane.setHgap(20);
		pane.setVgap(20);
		pane.setPadding(new Insets(25));
		pane.getStyleClass().add("grid");
		return pane;
	}
	
	private TextField[] populateInputFields() {
		tfName = new TextField();
		tfEmail = new TextField();
		tfPhone = new TextField();
		tfPostalCode = new TextField();
		tfCity = new TextField();
		tfAddress = new TextField();
		tfAmount = new TextField();
		
		TextField[] fields = {
				tfName, tfEmail, tfPhone, tfPostalCode, tfCity, tfAddress, tfAmount
		};
		return fields;
	}
	
	private String[] generateLabelText() {
		String[] labels = {"Megrendelő neve*:", "Email*:","Telefon*:","Irányítószám*:","Város*:","Cím*:","Mennyiség*:"};
		return labels;
	}
	
	private String[] generatePromptText() {
		String[] text = {"pld. Teszt Elek", "Pld. tesztelek@teszt.hu","Pld. 555-5555","Pld. 1111","Pld. Budapest","Pld. Fő u. e","Pld. 3"};
		return text;
	}
	
	private void createTextFieldInput(String labelText, TextField textfield,String promptText, int rowIndex) {
		Label label = new Label(labelText);
		textfield.setPromptText(promptText);
		GridPane.setConstraints(label, 0, rowIndex);
		GridPane.setConstraints(textfield, 1, rowIndex);
		root.getChildren().addAll(label,textfield);
	}
	
	private void createProductComboBox(int rowIndex) {
		cmbProductTypes = new ComboBox<>();
		List<Product> products = productDao.getAll();
		cmbProductTypes.getItems().addAll(products);
		cmbProductTypes.getSelectionModel().selectFirst();
		GridPane.setConstraints(cmbProductTypes, 1, rowIndex);
		root.getChildren().add(cmbProductTypes);
	}
	
	private void createReducePriceCheckBox(int rowIndex) {
		chkReducePrice = new CheckBox("Csökkentett ár");
		GridPane.setConstraints(chkReducePrice, 1, rowIndex);
		root.getChildren().add(chkReducePrice);
	}
	
	private void createOrderButton(int rowIndex) {
		btnOrder = new Button("Megrendelés");
		btnOrder.getStyleClass().add("btn-order");
		btnOrder.setOnAction(e->handleOrder());
		GridPane.setConstraints(btnOrder, 1, rowIndex);
		root.getChildren().add(btnOrder);
	}
	
	private void handleOrder() {
		try {
			OrderValidation orderValidator = new OrderValidation();
			if (!orderValidator.isValid(tfName, tfEmail, tfPhone, 
					tfPostalCode, tfCity, tfAddress, tfAmount)) {
				showAlert(Alert.AlertType.ERROR, "A megrendelés sikertelen :(,", "Hiányzó adat(ok)!!!");
			} else {
			
			OrderService orderService = new OrderService(orderDao);
			Order order = orderService.createOrder(
					tfName.getText(),
					tfEmail.getText(),
					tfPhone.getText(),
					tfPostalCode.getText(),
					tfCity.getText(),
					tfAddress.getText(),
					Integer.parseInt(tfAmount.getText()),
					cmbProductTypes.getSelectionModel().getSelectedItem(),
					chkReducePrice.isSelected()
			);
	        showAlert(Alert.AlertType.INFORMATION, "Sikeres megrendelés!", "Köszönjük a rendelését,"
	        		+ " \nVégösszeg: "+orderService.calculateTotal(order) + "Ft");
	        clearForm();
			}
		} catch (NumberFormatException e) {
			showAlert(Alert.AlertType.ERROR, "A megrendelés sikertelen :(,", "Hibás mennyiségi formátum, egész szám legyen!!!");
		} catch (Exception e) {
			showAlert(Alert.AlertType.ERROR, "A megrendelés sikertelen :(,", "Ismeretlen hiba történt!!!");
		}
	}
	
	private void clearForm() {
	    tfName.clear();
	    tfEmail.clear();
	    tfPhone.clear();
	    tfPostalCode.clear();
	    tfCity.clear();
	    tfAddress.clear();
	    tfAmount.clear();
	    chkReducePrice.setSelected(false);
	    cmbProductTypes.getSelectionModel().selectFirst();
	}
	
	private void showAlert(Alert.AlertType type, String title, String message) {
		Alert alert = new Alert(type);
		alert.setTitle(title);
		alert.setContentText(message);
		alert.show();
	}
}
