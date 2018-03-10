package com.revature;

import java.util.List;
import java.util.Scanner;

import com.revature.controller.Database;
import com.revature.controller.Login;
import com.revature.controller.Transactions;
import com.revature.exception.LoginException;
import com.revature.model.BankMember;
/** 
 * Create an instance of your controller and launch your application.
 * 
 * Try not to have any logic at all on this class.
 */
public class Main {

	public static void main(String[] args) throws LoginException {
		Scanner scanner = new Scanner(System.in);
		// Ask the user if they have an account.

		String c = Login.createAccount();

		// Great! If they said yes then they continue, if
		// no, they have to create an account.

		if (c.contains("n")){
			Login.newAccount();
		}

		// Either way they have to log in.
		int custID;
		try {
			custID = Login.login();
		} catch (LoginException e) {
			throw new LoginException("Unable to login.");
		}

		// They select an transaction option.
		int d = Transactions.option();

		// Now to the money, honey!
		switch (d){
		case 1:
			Transactions.withdrawl(custID);
			break;
		case 2:
			Transactions.deposit(custID);
			break;
		case 3:
			Transactions.viewBalance(custID);
			break;
		case 4:
			Database.selectAll(custID);
		}
		System.exit(0);
	}
}
