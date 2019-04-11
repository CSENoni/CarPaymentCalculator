package application;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class OutputController {
	
	@FXML
	private Label outputMonthly;
	
	//TODO: Get more fields from output fields here like above...
	
	public void setOutputMonthly(String text) {
		this.outputMonthly.setText(text);
	}
	
	//TODO: Write methods to return output fields here like above...
}
