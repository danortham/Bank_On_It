# Bank on it

## Checking

* has a balance 
* set balance 
* get balance

## Saving

* is the child of Checking
* it also has interest method
	* asks for the amount of time past 
	* uses the formula to calculate it
	* sets the new saving balance

## user
### properties
- account number
- pin
- checking account
- saving account

***

### methods
1. getChecking
	* get the balance from checking class
2. depositChecking
	* get the currect checking balance 
	* ask how much the user wants to add
	* add that amount to the balance 
	* set new balance
3. WithdrawChecking
	* get the current checking balance
	* ask how much the user wants to take out
	* make sure that the user doesnt take out too much
	* subtract that amount from the balance 
	* set new balance
4. getSaving
	* same as getChecking
5. depositSaving
	* same as depositChecking
6. withdrawSaving
	* same as withdrawChecking
7. userSelection
	* print out all the options the user has
	* assign what they chose to a varibale 
	* return that
6. userMenu
	* run the userSelection 
	* assign the return value to a variable
	* whichever value they selected call that method
7. toString
	* turn all the user information into a string
8. getAccountNum 
	* return account number
9. getPin
	* return pin

***

## Admin

### methods
1. getUser
	* reads the file
	* gets the information and parses it
	* make user object with the information
	* make ArrayList 
	* store the objects in arraylist
2. adminMenu
	* same as userMenu but with admin methods
3. adminSelection
	* same as userSelection
4. addUser
	* ask for the account number and pin
	* put those together with the account balances
	* open the file
	* wrtie that information to the file
	* close the file
5. deleteuser
	* ask for the account number that you want deleted
	* get the arraylist of users
	* make sure that the account number that they typed in matched to an existing user
	* if that is true and both the accounts are empty 
	* then delete
6. delete
	* deltes the user from the file by replacing it with a blank
7. applyinterest
	* get all the users
	* for all the users 
	* run the interest function from Saving
	* write that to the file
	* close the file
8. listUser
	* get the users and put them in the ArrayList
	* run a for loop to get all the users
	* print each one out 
