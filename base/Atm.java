import java.util.*;
import java.io.*;

class Atm {
	// main log in screen
	public static void main(String[] args) {
			// put up log in 
		Admin ad = new Admin();
		String info[] = new String[2];
		Scanner input = new Scanner(System.in);
		// ask for the information
		// put all the information in a string array 
		System.out.println("\n\nWelcome to the late bank\n"
						   +" Please enter your account number\n");
		
		info[0] = input.nextLine();
		System.out.println("Please enter your pin");
		info[1] = input.nextLine();
		
		System.out.println(info[0] + " " + info[1]);
			// take in account number and pin
		boolean keepGoing = true;
		ArrayList<User> users = ad.getUser();
		while(keepGoing) {
			// if the account number AND pin match admin call admin menu
			if(info[0].equals("00000") == true && info[1].equals("12345") == true) {
				ad.adminMenu();
				keepGoing = false;
			} else {
				System.out.println("inccorect input");
				keepGoing = false;
			} // end if
			// if the account number AND pin match an existing user call user menu
			for(User u: users) {
				if(u.getAccountNum().equals(info[0]) == true && u.getPin().equals(info[1])){
					int line = users.indexOf(u);
					u.userMenu();
					keepGoing = false;
				} // end if
			} // end for
		} // end while
	} // end main


}
