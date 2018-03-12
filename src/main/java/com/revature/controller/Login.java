package com.revature.controller;
import java.util.Scanner;
import com.revature.exception.LoginException;
import com.revature.model.BankMember;
import com.revature.repository.BankMemberRepositoryJbdc;

public class Login {

	static Scanner scanner = new Scanner(System.in);

	public static String createAccount(){

		System.out.println("*~*~*~*~*Arbelaez Bank*~*~*~*~*~*");
		System.out.println("Returning customer?");
		System.out.println("Y = Yes, N = No");

		String newAccount;
		newAccount = scanner.nextLine();
		newAccount = newAccount.toLowerCase();

		return newAccount;
	}

	public static int login() throws LoginException{
		String username = "";
		String password = "";
		String[] userCredentials = {username, password};
		int custID = 0;

		BankMemberRepositoryJbdc repository = new BankMemberRepositoryJbdc();


		System.out.println("*~*~*~*~*~*Arbelaez Bank*~*~*~*~*~*");
		System.out.println("Enter your username.");
		userCredentials[0] = scanner.nextLine();
		System.out.println("Enter your password.");
		userCredentials[1] = scanner.nextLine();
		
		try {
			custID = repository.recallUser(userCredentials[0], userCredentials[1]);
		} catch (LoginException e) {
			throw new LoginException("Login Failed.");
		}
		
		return custID;
	}

	public static void newAccount(){
		BankMember member = new BankMember();
		BankMemberRepositoryJbdc repository = new BankMemberRepositoryJbdc();
		String lowerCase;
		
		System.out.println("*~*~*~*~*~*Arbelaez Bank*~*~*~*~*~*");
		System.out.println("");
		System.out.println("Enter your first name.");
		lowerCase = scanner.nextLine();
		lowerCase = lowerCase.toLowerCase();
		member.setFirstName(lowerCase);
		System.out.println("Enter your last (family) name.");
		lowerCase = scanner.nextLine();
		lowerCase = lowerCase.toLowerCase();
		member.setLastName(lowerCase);
		System.out.println("Enter a Username.");
		lowerCase = scanner.nextLine();
		lowerCase = lowerCase.toLowerCase();
		member.setUserName(lowerCase);
		System.out.println("Enter a password.");
		lowerCase = scanner.nextLine();
		lowerCase = lowerCase.toLowerCase();
		member.setPassword(lowerCase);

		repository.insert(member);
	}
}
