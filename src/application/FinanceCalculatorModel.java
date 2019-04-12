package application;

public class FinanceCalculatorModel {
	// TODO: fill out these functions here and add more or less arguments if needed
	
	public double getMonthlyPayment(double carPrice, double downPayment, double interest, double numberOfMonths) {
		double monthlyInterest = (interest / 100) / 12;
		double bottom = (1 - (Math.pow((1 + monthlyInterest), -numberOfMonths)));
		double top = (carPrice - downPayment) * monthlyInterest;
		double monthlyPayment = Math.round(top / bottom * 100.0) / 100.0;
		return monthlyPayment;
	}

	public double getTotalAmountPaid() {
		return 0.0;
	}

	public double getTotalInterestPaid() {
		return 0.0;
	}
}
