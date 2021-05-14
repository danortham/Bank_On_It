
public class Checking{
	protected double balance = 0.00d;
	
	/*
	public static void main(String[] args) {
		
	Checking c = new Checking();
	
	c.printBalance();
	c.setBalance(100.20d);
	c.printBalance();
	System.out.println(c.getBalance());

	c = new Checking(3.50d);
	c.printBalance();

	} // end main
	*/
	public Checking() {
		this.balance = 0.00d;
	} // end constructor

	public Checking(double balance){
		this.balance = balance;
	} // end constructor
	
	public void setBalance(double balance) {
		this.balance = balance;
	} // end set balance
	
	public double getBalance() {
		return this.balance;
	} // end get balance

	public void printBalance() {
		System.out.println("Balance: " + this.balance);
	}
}
