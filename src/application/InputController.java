package application;


import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class InputController {
	
	private OutputController outputController;
	
	@FXML
	private ComboBox<String> userCredit;

	@FXML
	private Label creditExplain;
	
	@FXML
	private TextField userCarPrice;
	
	@FXML
	private TextField userMonths;
	
	@FXML
	public void initialize() {
		userCredit.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				switch (newValue) {
				case "Super prime (781-850)":
					creditExplain.setText("Based on your score, the average rate is 3.68% (new) or 4.34% (used).");
					break;
				case "Prime (661-780)":
					creditExplain.setText("Based on your score, the average rate is 4.56% (new) or 5.97% (used).");
					break;
				case "Subprime (501-600)":
					creditExplain.setText("Based on your score, the average rate is 11.89% (new) or 16.14% (used).");
					break;
				case "Nonprime (601-660)":
					creditExplain.setText("Based on your score, the average rate is 7.52% (new) or 10.34% (used).");
					break;
				default:
					creditExplain.setText(
							"Based on your score, the average rate is 14.41% (new) or 19.98% (used). Consider buying an inexpensive used car and refinancing in 6-12 months.");
				}
			}
		});
	}
	
	public void injectOutputController(OutputController outputController) {
		this.outputController = outputController;
	}
	
	@FXML
	public void handleCarPriceAction(KeyEvent event) {
		// May change based on calculation
		outputController.setOutputMonthly(userCarPrice.getText());
	}
	
	// TODO: Write more key handler in fxml and this inputcontroller like above function
	// May need to declare more data fields at the top with @FXML...
}
