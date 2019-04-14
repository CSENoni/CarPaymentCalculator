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
	
	private FinanceCalculatorModel model;
	
	@FXML
	private ComboBox<String> userCredit;

	@FXML
	private Label creditExplain;
	
	@FXML
	private TextField userCarPrice;
	
	@FXML
	private TextField userMonths;
	
	@FXML
	private TextField userDown;
	
	@FXML
	private TextField userInterest;
	
	@FXML
	public void initialize() {
		this.model = new FinanceCalculatorModel();
		userCredit.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				switch (newValue) {
				case "Super prime (781-850)":
					creditExplain.setText("Based on your score, the average rate is 3.08% (new) or 3.76% (used).");
					break;
				case "Prime (661-780)":
					creditExplain.setText("Based on your score, the average rate is 4.56% (new) or 5.97% (used).");
					break;
				case "Nonprime (601-660)":
					creditExplain.setText("Based on your score, the average rate is 7.52% (new) or 10.34% (used).");
					break;
				case "Subprime (501-600)":
					creditExplain.setText("Based on your score, the average rate is 11.89% (new) or 16.14% (used).");
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
		calculateAndShowMonthlyPayment();
		calculateAndShowTotalAmount();
		calculateAndShowTotalInterest();
	}
	
	@FXML
	public void handleMonthAction(KeyEvent event) {
		calculateAndShowMonthlyPayment();
		calculateAndShowTotalAmount();
		calculateAndShowTotalInterest();
	}
	
	@FXML
	public void handleDownAction(KeyEvent event) {
		calculateAndShowMonthlyPayment();
		calculateAndShowTotalAmount();
		calculateAndShowTotalInterest();
	}
	
	@FXML
	public void handleInterestAction(KeyEvent event) {
		calculateAndShowMonthlyPayment();
		calculateAndShowTotalAmount();
		calculateAndShowTotalInterest();
	}
	
	
	// TODO: Create methods for calculating other outputs
	// May need to declare more data fields at the top with @FXML...
	
	
	/******************Helper Functions************************/
	// Check to see if the string is empty or not
	private boolean isNotEmpty(String text) {
		return text != null && text.length() > 0;
	}
	
	// Calculate monthly payment. TODO: Improve the calculation
	private void calculateAndShowMonthlyPayment() {
		double price = (isNotEmpty(userCarPrice.getText())) ? Double.parseDouble(userCarPrice.getText()) : 0.0;
		double months = (isNotEmpty(userMonths.getText())) ? Double.parseDouble(userMonths.getText()) : 0.0;
		double downPayment = (isNotEmpty(userDown.getText())) ? Double.parseDouble(userDown.getText()) : 0.0;
		double interest = (isNotEmpty(userInterest.getText())) ? Double.parseDouble(userInterest.getText()) : 0.0;

		String monthlyPayment = "$" + model.getMonthlyPayment(price, downPayment, interest, months);
		outputController.setOutputMonthly(monthlyPayment);
		
	}
		
	private void calculateAndShowTotalAmount() {	
		double price = (isNotEmpty(userCarPrice.getText())) ? Double.parseDouble(userCarPrice.getText()) : 0.0;
		double months = (isNotEmpty(userMonths.getText())) ? Double.parseDouble(userMonths.getText()) : 0.0;
		double downPayment = (isNotEmpty(userDown.getText())) ? Double.parseDouble(userDown.getText()) : 0.0;
		double interest = (isNotEmpty(userInterest.getText())) ? Double.parseDouble(userInterest.getText()) : 0.0;
		
		String totalAmount = "$" + (model.getTotalAmountPaid(model.getMonthlyPayment(price, downPayment, interest, months), months));
		outputController.setOutputTotalAmount(totalAmount);
	}
		
	private void calculateAndShowTotalInterest() {
		double price = (isNotEmpty(userCarPrice.getText())) ? Double.parseDouble(userCarPrice.getText()) : 0.0;
		double months = (isNotEmpty(userMonths.getText())) ? Double.parseDouble(userMonths.getText()) : 0.0;
		double downPayment = (isNotEmpty(userDown.getText())) ? Double.parseDouble(userDown.getText()) : 0.0;
		double interest = (isNotEmpty(userInterest.getText())) ? Double.parseDouble(userInterest.getText()) : 0.0;
		
		String totalInterest = "S" + (model.getTotalInterestPaid(model.getTotalAmountPaid(model.getMonthlyPayment(price, downPayment, interest, months), months), price, downPayment));
		outputController.setOutputTotalInterest(totalInterest);
	}
}
