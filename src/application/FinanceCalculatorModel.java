package application;

public class FinanceCalculatorModel {
	
	private double monthlyPayment;
	private double totalAmount;
		
	public double getMonthlyPayment(double carPrice, double downPayment, double interest, double numberOfMonths) {
		if (numberOfMonths == 0) {
			this.monthlyPayment = 0;
			return this.monthlyPayment;
		}
		else if (interest == 0) {
			this.monthlyPayment = Math.round((carPrice - downPayment) / numberOfMonths * 100.00) / 100.0;
			return this.monthlyPayment;
		}
		else {
			double monthlyInterest = (interest / 100) / 12;
			double bottom = (1 - (Math.pow((1 + monthlyInterest), -numberOfMonths)));
			double top = (carPrice - downPayment) * monthlyInterest;
			this.monthlyPayment = top / bottom;
			return this.monthlyPayment;
		}
	}

	public double getTotalAmountPaid(double numberOfMonths) {
		this.totalAmount = this.monthlyPayment * numberOfMonths;
		return this.totalAmount;
	}

	public double getTotalInterestPaid(double interest, double carPrice, double downPayment) {
		if (interest == 0) {
			return 0;
		}
		else {
			double totalInterest = this.totalAmount - (carPrice - downPayment);
			return totalInterest;
		}
	}
	
	//TODO: Edit so that all monthly payments added together = carprice 
}
