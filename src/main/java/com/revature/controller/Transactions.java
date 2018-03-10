package com.revature.controller;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Transactions {

	static Scanner scanner = new Scanner(System.in);
	
	public static int option(){
		System.out.println("*~*~*~*~*~*Arbelaez Bank*~*~*~*~*~*");
		System.out.println("Welcome!");
		System.out.println("What would you like to do today? Type the number of the choice.");
		System.out.println("");
		System.out.println("Withdraw = 1");
		System.out.println("Deposit = 2");
		System.out.println("View Balance = 3");
		System.out.println("View Transactions = 4");
		int option = scanner.nextInt();
		
		return option;
	}
	public static void withdrawl(int custID){
		double balance = Database.recallBalance(custID);
		System.out.println("*~*~*~*~*~*Arbelaez Bank*~*~*~*~*~*");
		System.out.println("Current Balance: " + balance);
		System.out.println("");
		System.out.println("How much would you like to withdrawl?");
		double amount = scanner.nextDouble();

		double newAmount = (balance - amount);
		Database.newBalance(custID,newAmount);
		Database.withdrawlTransaction(custID, balance, newAmount);
		System.out.println("");
		System.out.println("Your balance is now: " + newAmount);
		System.out.println("");
		System.out.println("Thank you for visiting Arbelaez Bank!");
	}
	
	public static void deposit(int custID){
		double balance = Database.recallBalance(custID);
		System.out.println("*~*~*~*~*~*Arbelaez Bank*~*~*~*~*~*");
		System.out.println("Current Balance: " + balance);
		System.out.println("");
		System.out.println("How much would you like to deposit?");
		double amount = scanner.nextDouble();
	
		double newAmount = (balance + amount);
		Database.newBalance(custID,newAmount);
		Database.depositTransaction(custID, balance, newAmount);
		System.out.println("");
		System.out.println("Your balance is now: " + newAmount);
		System.out.println("");
		System.out.println("Thank you for visiting Arbelaez Bank!");
	}
	
	public static double viewBalance(int custID){
		double balance = Database.recallBalance(custID);
		System.out.println("*~*~*~*~*~*Arbelaez Bank*~*~*~*~*~*");
		System.out.println("Current Balance: " + balance);
		return balance;
	}
	
}
