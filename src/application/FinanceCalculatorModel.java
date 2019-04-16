package application;

public class FinanceCalculatorModel {
	
	private double monthlyPayment;
	private double totalAmount;
	private double firstMonth;
		
	public double getMonthlyPayment(double carPrice, double downPayment, double interest, double numberOfMonths) {
		if (numberOfMonths == 0) {
			this.monthlyPayment = 0;
			return this.monthlyPayment;
		}
		else if (interest == 0) {
			this.monthlyPayment = Math.round((carPrice - downPayment) / numberOfMonths * 100.0) / 100.0;
			return this.monthlyPayment;
		}
		else {
			double monthlyInterest = (interest / 100) / 12;
			double bottom = (1 - (Math.pow((1 + monthlyInterest), -numberOfMonths)));
			double top = (carPrice - downPayment) * monthlyInterest;
			this.monthlyPayment = Math.round(top / bottom * 100.0) / 100.0;
			return this.monthlyPayment;
		}
	}
	
	public double getfirstMonth(double carPrice, double downPayment, double interest, double months) {
		if (interest == 0) {
			if ((this.monthlyPayment * months) == (carPrice - downPayment)) {
				this.firstMonth = 0;
				return this.firstMonth;
			}
			else
				this.firstMonth = this.monthlyPayment + ((carPrice - downPayment) - (this.monthlyPayment * months));
				this.firstMonth = Math.round(this.firstMonth * 100.0) / 100.0;
				return this.firstMonth;
		}
		else {
			this.firstMonth = 0;
			return this.firstMonth;
		}
	}

	public double getTotalAmountPaid(double interest, double numberOfMonths) {
		if (this.firstMonth != 0) {
			this.totalAmount = (this.monthlyPayment * (numberOfMonths - 1)) + this.firstMonth;
			return this.totalAmount;
		}
		else {
			this.totalAmount = this.monthlyPayment * numberOfMonths;
			return this.totalAmount;
		}
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
}
