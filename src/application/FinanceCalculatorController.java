package application;

import javafx.fxml.FXML;

public class FinanceCalculatorController {
	
	@FXML
	private InputController inputController;
	
	@FXML
	private OutputController outputController;
	
	@FXML
	public void initialize() {
		inputController.injectOutputController(outputController);
	}
}
