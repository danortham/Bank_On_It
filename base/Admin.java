import java.util.*;
import java.io.*;

public class Admin {

	
	/*
	public static void main(String[] args) {

	Admin a = new Admin();
		
	// a.addUser();
	// getUser();
	// System.out.println(getUser());
	//a.listUser();
	//a.deleteUser();
	//a.listUser();
	//a.applyInterest();
	//a.adminSelection();
	a.adminMenu();
	} // end main
	*/
	public static ArrayList<User> getUser(){
		// read the accounts file for users
		// make and array list of user objects
		ArrayList<User> users = new ArrayList<User>();
		File file = new File("accounts.txt");
		try {
			Scanner input = new Scanner(file);	
			// keep getting the user information from the file
			// put the information into user constructor
			// add the user object to the arrat
			while(input.hasNextLine()) {
				String temp = input.nextLine();
				String[] info = temp.split(",");
				String accountNum = info[0];
				String pin = info[1];
				double checking = Double.parseDouble(info[2]);
				double saving = Double.parseDouble(info[3]);
				User u = new User(accountNum, pin, checking, saving);
				users.add(u);		
			} // end while
		} catch (Exception e) {
			System.out.println("Error");
		}
		return users;
	} // end get user
	
	public void adminMenu() {
		boolean keepGoing = true;
		// get the selection and run that function
		while(keepGoing) {
			int selection = adminSelection();
			
			if(selection == 1) {
				addUser();
			} else if(selection == 2) {
				deleteUser();
			} else if(selection == 3) {
				listUser();
			} else if(selection == 4) {
				applyInterest();
			} else if(selection == 5) {
				System.out.println("Have a great day!");
				keepGoing = false;
			} else {
				System.out.println("Error, please try again!");
			} // end if	
		} // end while
	} // end admin menu

	public int adminSelection() {
		// print out the admins options
		int selection = 0;
		Scanner input = new Scanner(System.in);

		System.out.println("What would you like to do? \n" + "1) Add user \n" + "2) Delete User \n" + "3) List User \n" + "4) Apply interest \n" + "5) Exit \n");
		selection = input.nextInt();
		return selection;

	} // end admin selection

	public void addUser(){

		String accountNum, pin, accountInfo;
		Scanner input = new Scanner(System.in);
		// ask for the account number
		System.out.print("Please enter the account number\n");
		accountNum = input.nextLine();
		// ask for the pin
		System.out.println("Please enter the pin");
		pin = input.nextLine();
		// put all the information together
		accountInfo = accountNum + "," + pin + ",0.00,0.00\n";
	
		File file = new File("accounts.txt");
		BufferedWriter bw = null;
 		FileWriter fw = null;
		// wrtie the info to the file
		try {	
			fw = new FileWriter(file.getAbsoluteFile(), true);
			bw = new BufferedWriter(fw);
			bw.write(accountInfo);
		} catch (IOException e) {
			e.printStackTrace();
			
		} finally {
			try {
				bw.close();
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} // end try
	} // end addUser
	
	public void deleteUser() {
		// get all the users
		String accountNum;
		ArrayList<User> users = getUser();
		Scanner input = new Scanner(System.in);

		System.out.println("Please enter the number of the account you want to delete\n");
	
		accountNum = input.nextLine();
		try{
			// if the info matches and the accounts have no money in them delete
			for (User u: users) {
				if (u.getAccountNum().equals(accountNum) == true) {
					if (u.getChecking() == 0.0 && u.getSaving() == 0.0){
						int line = users.indexOf(u);
					
						delete("accounts.txt", line, 1);
						System.out.println("User terminated");
					} else {
						System.out.println("Failed to delete. Remove all funds!");
					} // end if
				} // end if
			} // end for
		} catch (Exception e) {
			System.out.println("error");
		}
	} // end delete user

	public void delete(String fileName, int sLine, int numLine) {
		try {
			
			BufferedReader breader = new BufferedReader(new FileReader(fileName));
			StringBuffer sb = new StringBuffer("");
			int lineNumber = 0;
			String line;
			
			while((line=breader.readLine())!=null){
				if(lineNumber<sLine||lineNumber>=sLine+numLine){
					sb.append(line+"\n");
				} // end if
				lineNumber++;
			} // end while
			breader.close();
			FileWriter fw = new FileWriter(new File(fileName));
			fw.write(sb.toString());
			fw.close();
		} catch (Exception e) {
			System.out.println("Error");
		} // end try
	} // end delete
			
	public void applyInterest() {
		ArrayList<User> users = getUser();
		// get all the users	
		File file = new File("accounts.txt");
		try {
			FileWriter fw = new FileWriter(file, false);
			// use the interest function on all the users
			for (User u: users) {
				u.getSaving();	
				u.savingAcc.interest();
			} // end for 
			for(User u: users) {
				fw.write(u.toString() + "\n");
				fw.close();	
			}
			
		} catch (Exception e) {
			System.out.println("Error");
		}	
		
		System.out.println("Interest applied to all savings accounts");
	} 

	public void listUser() {
		ArrayList<User> users = getUser();
		String temp = "";
		// for all the users in the arraylist
		for (User u: users) {
			temp = u.toString();
			// print out each user
			System.out.println(temp + "\n");			
		} // end for

	} // end list user

} // end class def
