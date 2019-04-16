package application;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class OutputController {
	
	@FXML
	private Label outputMonthly;
	
	public void setOutputMonthly(String text) {
		this.outputMonthly.setText(text);
	}
	
	@FXML
	private Label outputTotal;
	
	public void setOutputTotalAmount(String text) {
		this.outputTotal.setText(text);
	}
	
	@FXML
	private Label outputInterest;
	
	public void setOutputTotalInterest(String text) {
		this.outputInterest.setText(text);
	}
	
	@FXML
	private Label firstMonth;
	
	public void setfirstMonth(String text) {
		this.firstMonth.setText(text);
	}
}