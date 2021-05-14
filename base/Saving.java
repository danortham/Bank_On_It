import java.util.*;
import java.lang.*;

public class Saving extends Checking {
	
	private double P;
	private int T;
	private double A;
	
	/*
	public static void main(String[] args) {
	Saving s = new Saving();
	
	s.intrest();
	}
	*/
	public Saving() {
		this.balance = 0.00d;	
	} // end constructor
	
	public Saving(double balance) {
		this.balance = balance;
	}
		
	public void interest() {
	// apply intrest by asking how much time has passed 
	// get the time
	Scanner input = new Scanner(System.in);
	System.out.println("Enter an amount of time(months)");
	T = input.nextInt();
	P = this.balance;
	A = P*(1 + (.04 * T));
	A = Math.round(A * 100);
	A = A/100;
	this.setBalance(A);

	// plug all that into the equation and then add it to the balance

	}
} // end class def
