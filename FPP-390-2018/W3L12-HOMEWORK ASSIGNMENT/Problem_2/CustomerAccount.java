package Problem_2;

public class CustomerAccount {
	String Cus_name;
	String Acc_No;
	double Balance;

	CustomerAccount(String Cus_name, String Acc_No,double Balance) {
		this.Cus_name = Cus_name;
		this.Acc_No = Acc_No;
		this.Balance= Balance;
	}

	public String getCus_name() {
		return Cus_name;
	}

	public void setCus_name(String Cus_name) {
		this.Cus_name = Cus_name;
	}

	public double getBalance() {
		if (this.Balance < 100.0)
			new AccountCheckingException("Your balance is below 100!");
		return Balance;
	}

	public void setBalance(double Balance) {
		this.Balance = Balance;
	}

	public void deposit(double amount) throws AccountCheckingException{
		if (amount < 0) {
			AccountCheckingException ace = new AccountCheckingException("Deposit amount cannot be negative");
			throw ace;
		}
		Balance = this.Balance + amount;

	}

	public void withdraw(double amount) throws AccountCheckingException {
		if (this.Balance < amount) {
			AccountCheckingException ax = new AccountCheckingException("Sorry!, you dont have"
					+ " sufficient balance to withdrow: withdraw amount shoud be <= " + this.Balance);
			throw ax;
		}
		if (this.Balance-amount<100){
			AccountCheckingException ax = new AccountCheckingException("Balance reach below $100");
			throw ax;
		}

		System.out.println("Your withdraw completed Successfull");
		this.Balance =this.Balance - amount;
	}
	@Override
	public String toString() {
		return "Name: " + Cus_name + " Acc_No: " + Acc_No + " Initial Saving: " + Balance;
	}
}
