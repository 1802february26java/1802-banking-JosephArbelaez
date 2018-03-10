package com.revature.controller;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.model.BankMember;
import com.revature.repository.BankMemberRepositoryJbdc;

public class Login {
	
	static Scanner scanner = new Scanner(System.in);
	
	public static String createAccount(){
		

		System.out.println("*~*~*~*~*Arbelaez Bank*~*~*~*~*~*");
		System.out.println("Returning customer?");
		System.out.println("Y = Yes, N = No");
		String newAccount = scanner.nextLine();
		newAccount = newAccount.toLowerCase();

		return newAccount;
	}

	public static int login(){
		String username = "";
		String password = "";
		String[] userCredentials = {username, password};

		BankMemberRepositoryJbdc repository = new BankMemberRepositoryJbdc();
			
			
		System.out.println("*~*~*~*~*~*Arbelaez Bank*~*~*~*~*~*");
		System.out.println("Enter your username.");
		userCredentials[0] = scanner.nextLine();
		System.out.println("Enter your password.");
		userCredentials[1] = scanner.nextLine();
		int custID = repository.recallUser(userCredentials[0], userCredentials[1]);

		return custID;
	}
	
	public static void newAccount(){
		BankMember member = new BankMember();
		BankMemberRepositoryJbdc repository = new BankMemberRepositoryJbdc();
		System.out.println("*~*~*~*~*~*Arbelaez Bank*~*~*~*~*~*");
		System.out.println("");
		System.out.println("Enter your first name.");
		member.setFirstName(scanner.nextLine());
		System.out.println("Enter your last (family) name.");
		member.setLastName(scanner.nextLine());
		System.out.println("Enter a Username.");
		member.setUserName(scanner.nextLine());
		System.out.println("Enter a password.");
		member.setPassword(scanner.nextLine());
		
		repository.insert(member);
	}
}
