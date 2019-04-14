package application;

public class FinanceCalculatorModel {
	
	public double getMonthlyPayment(double carPrice, double downPayment, double interest, double numberOfMonths) {
		double monthlyInterest = (interest / 100) / 12;
		double bottom = (1 - (Math.pow((1 + monthlyInterest), -numberOfMonths)));
		double top = (carPrice - downPayment) * monthlyInterest;
		double monthlyPayment = Math.round(top / bottom * 100.0) / 100.0;
		return monthlyPayment;
	}

	public double getTotalAmountPaid(double carPrice, double downPayment, double interest, double numberOfMonths) {
		double monthlyInterest = (interest / 100) / 12;
		double bottom = (1 - (Math.pow((1 + monthlyInterest), -numberOfMonths)));
		double top = (carPrice - downPayment) * monthlyInterest;
		double totalAmount = (Math.round(top / bottom * 100.0) / 100.0)*numberOfMonths;
		return totalAmount;
	}

	public double getTotalInterestPaid(double carPrice, double downPayment, double interest, double numberOfMonths) {
		double monthlyInterest = (interest / 100) / 12;
		double bottom = (1 - (Math.pow((1 + monthlyInterest), -numberOfMonths)));
		double top = (carPrice - downPayment) * monthlyInterest;
		double totalInterest = ((Math.round(top / bottom * 100.0) / 100.0)*numberOfMonths) - (carPrice - downPayment);
		return totalInterest;
	}
}
