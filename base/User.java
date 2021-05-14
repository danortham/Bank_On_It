import java.util.*;
import java.io.*;
import java.lang.*;

public class User {

	private String accountNum;
	private String pin;
	Checking checkingAcc = new Checking();
	Saving savingAcc = new Saving();
	
	/*
	public static void main(String[] args) throws IOException {
	
	User us = new User();
	us.savingAcc.interest();
	
	u.getChecking();
	System.out.println(u.getChecking());
	u.getSaving();
	System.out.println(u.getSaving());

	u.depositChecking();
	System.out.println(u.getChecking());

	u.depositSaving();
	System.out.println(u.getSaving());	

	u.withdrawChecking();
	System.out.println(u.checkingAcc.balance);
	u.withdrawSaving();
	System.out.println(u.savingAcc.balance);
	
	//u.userSelection();
	System.out.println(u.userSelection());
	
	 
	us.userMenu();
	} // end main
	*/
	public User(){
		this.accountNum = accountNum;
		this.pin = pin; 
		this.checkingAcc = new Checking();
		this.savingAcc = new Saving();
	} // end constructor
	
	public User(String accountNum, String pin, double checking, double saving) {
		this.accountNum = accountNum;
		this.pin = pin;
		this.checkingAcc = new Checking();
		this.savingAcc = new Saving();
		checking = checkingAcc.balance;
		saving = savingAcc.balance;
	} // end constructor
	public String getAccountNum() {
		return this.accountNum;
	} // end getAccoutNum

	public String getPin() {
		return this.pin;
	} // end getPin
	
	public double getChecking() {
		return checkingAcc.getBalance();
	} // end get checking	
	public void depositChecking() {
		//get the checking balance		
		checkingAcc.getBalance();
		
		// ask how much the user wants to add
		Scanner input = new Scanner(System.in);

		boolean correct = false;
		while(!correct) {
			try {
				correct = true;
				System.out.println("How much would you like to deposit?" );
				String amount = input.nextLine();
				double temp = Double.parseDouble(amount);	
				// add that amount to the balance
				checkingAcc.balance = temp + checkingAcc.balance;
				// set the new balance
				checkingAcc.setBalance(checkingAcc.balance);
				} catch(NumberFormatException e) {
				System.out.println("ERROR! Please enter a number");
				correct = false;
				} // end try 
		} // end while
	} // end deposit checking
	
	public void withdrawChecking() {
		// get checking balance
		checkingAcc.getBalance();				
		// ask how much they want to withdraw
		Scanner input = new Scanner(System.in);

		System.out.println("This is your current balance: " + checkingAcc.balance);
		System.out.println("How much would you like to withdraw?");
		String amount = input.nextLine();
		double temp = Double.parseDouble(amount);
		// if the amount is greater than balance
		if(temp > checkingAcc.balance) {
		// send error
			System.out.println("ERROR! Can't withdraw that much, goodbye.");
		} else if(temp < checkingAcc.balance) {
		//else subtract from balance
			checkingAcc.balance = checkingAcc.balance - temp;
			// set new balance
			checkingAcc.setBalance(checkingAcc.balance);
		} else {
			System.out.println("Something went wrong");
		}// end if
	} // end withdrawchecking
	
	public void depositSaving() {
		// get the saving account balance
		savingAcc.getBalance();
		// ask how much the user wants to deposit
		Scanner input = new Scanner(System.in);

		boolean correct = false;
		while(!correct) {
			try {	
				correct = true;
				System.out.println("How much would you like to deposit? ");
				String amount = input.nextLine();
				double temp = Double.parseDouble(amount);
				// add the amount to the balance
				savingAcc.balance = temp + savingAcc.balance;
				// set the new balance
				savingAcc.setBalance(savingAcc.balance);
				} catch(NumberFormatException e) {
				System.out.println("ERROR! Please enter a number ");
				correct = false;
				} // end try

		} // end while
		
	} // end deposit saving

	public void withdrawSaving() {
	
		// get saving balance
		savingAcc.getBalance();				
		// ask how much they want to withdraw
		Scanner input = new Scanner(System.in);

		System.out.println("This is your current balance: " + savingAcc.balance);
		System.out.println("How much would you like to withdraw?");
		String amount = input.nextLine();
		double temp = Double.parseDouble(amount);
		// if the amount is greater than balance
		if(temp > savingAcc.balance) {
		// send error
			System.out.println("ERROR! Can't withdraw that much, goodbye.");
		} else if(temp < savingAcc.balance) {
		//else subtract from balance
			savingAcc.balance = savingAcc.balance - temp;
			// set new balance
			savingAcc.setBalance(savingAcc.balance);
		} else {
			System.out.println("Something went wrong");
		}// end if
	} // end withdraw saving

	public double getSaving() {
		return savingAcc.getBalance();
	} // end get saving

	public void userMenu() {
		boolean keepGoing = true;

		while(keepGoing) {
			int selection = userSelection();
			// whatever the user selected run that function
	
			if(selection == 1) {
				System.out.println("Your checking balance is: " + getChecking());

			} else if(selection == 2) {
				depositChecking();

			} else if(selection == 3) {
				withdrawChecking();

			} else if(selection == 4) {
				System.out.println("Your savings balance is: " + getSaving());
			
			} else if(selection == 5) {
				depositSaving();
			
			} else if(selection == 6) {
				withdrawSaving();

			} else if(selection == 7) {
				System.out.println("Have a good day!");
				keepGoing = false;
				try {
					File file = new File("accounts.txt");
					FileWriter fw = new FileWriter(file, false);

					fw.write(toString() + "\n");
					fw.close();
				} catch (Exception e) {
					System.out.println("Error");
				} // end try
			} else {
				System.out.println("Error, please try again!");
			} // end if

		} // end while 
	
	} // end user menu

	public int userSelection() {
		
		int selection = 0;
		Scanner input = new Scanner(System.in);
		// print out the menu that the user will select from
		System.out.println("\nPlease select an option \n");
		System.out.println("1) Get checking balance \n" + "2) Deposit into checking \n" + "3) Withdraw from checking \n"
				  + "4) Get savings balance \n" + "5) Deposit into savings \n" + "6) Withdraw from savings \n" + "7) Exit \n");
		
		selection = input.nextInt();
		return selection;
	} // end userselection

	public String toString() {
		// turn all the information into a string
		return this.accountNum + "," + this.pin + "," + this.checkingAcc.balance + "," + this.savingAcc.balance;
	} // end to string
}// end class def
