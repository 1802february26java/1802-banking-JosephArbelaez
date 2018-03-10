package com.revature.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.model.Transaction;
import com.revature.util.ConnectionUtil;

public class Database {
	private static Logger logger = Logger.getLogger(ConnectionUtil.class);
	
	public static double recallBalance(int custID) {
		logger.trace("Getting balance.");
		String customerString = Integer.toString(custID);
		double balance = 0;
		try(Connection connection = ConnectionUtil.getConnection()){
			logger.trace("Connection Successful");
			String sql = "SELECT BALANCE FROM CUSTOMER WHERE CUSTOMER_ID = ?";

			PreparedStatement statement = connection.prepareStatement(sql);
			int parameterIndex = 0;
			statement.setString(++parameterIndex, customerString);
			ResultSet result = statement.executeQuery();
			
			while(result.next()){
				balance = result.getDouble("BALANCE");
			}
			return balance;
		
		}catch (SQLException e){
			logger.error("Error connection to database Database.recallBalance");
		}
		return 0;
	}
	
	public static void newBalance(int custID, double newAmount) {
		logger.trace("Changing balance.");
		String customerString = Integer.toString(custID);
		String balanceString = Double.toString(newAmount);
		
		try(Connection connection = ConnectionUtil.getConnection()){
			logger.trace("Connection successful");
			String sql = "UPDATE CUSTOMER SET BALANCE = ? WHERE CUSTOMER_ID = ?";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			int parameterIndex = 0;
			statement.setString(++parameterIndex, balanceString);
			statement.setString(++parameterIndex, customerString);
			statement.executeQuery();
		
		}catch (SQLException e){
			logger.error("Error while updating queries.");
		}
	}
		public static void depositTransaction(int custID, double balance ,double newAmount) {
			logger.trace("Adding deposit transaction.");
			String customerString = Integer.toString(custID);
			String balanceString = Double.toString(balance);
			String newAmountString = Double.toString(newAmount);
			
			try(Connection connection = ConnectionUtil.getConnection()){
				logger.trace("Connection successful");
				String sql = "INSERT INTO TRANSACTION (CUSTOMER_ID,TRANSACTION_TYPE,PREVIOUS_BALANCE, CURRENT_BALANCE) VALUES (?,?,?,?)";
				
				PreparedStatement statement = connection.prepareStatement(sql);
				int parameterIndex = 0;
				statement.setString(++parameterIndex, customerString);
				statement.setString(++parameterIndex, "DEPOSIT");
				statement.setString(++parameterIndex, balanceString);
				statement.setString(++parameterIndex, newAmountString);
				logger.trace("Statement prepared successfully");
				statement.executeUpdate();
			
				logger.trace("Successful transaction update.");
			}catch (SQLException e){
				logger.error("Error while updating queries Database.withdraawlTransaction");
			}
	}
		public static void withdrawlTransaction(int custID, double balance ,double newAmount) {
			logger.trace("Adding withdrawl transaction.");
			String customerString = Integer.toString(custID);
			String balanceString = Double.toString(balance);
			String newAmountString = Double.toString(newAmount);
			
			try(Connection connection = ConnectionUtil.getConnection()){
				logger.trace("Connection successful");
				String sql = "INSERT INTO TRANSACTION (CUSTOMER_ID,TRANSACTION_TYPE,PREVIOUS_BALANCE, CURRENT_BALANCE) VALUES (?,?,?,?)";
				
				PreparedStatement statement = connection.prepareStatement(sql);
				int parameterIndex = 0;
				statement.setString(++parameterIndex, customerString);
				statement.setString(++parameterIndex, "WITHDRAW");
				statement.setString(++parameterIndex, balanceString);
				statement.setString(++parameterIndex, newAmountString);
				logger.trace("Statement prepared successfully");
				statement.executeUpdate();
			
				logger.trace("Successful transaction update.");
			}catch (SQLException e){
				logger.error("Error while updating queries Database.withdraawlTransaction");
			}
	}
		public static List<Transaction> selectAll(int custID) {
			logger.trace("Getting all Celebrities");
			String custIDString = Integer.toString(custID);
			try(Connection connection = ConnectionUtil.getConnection()){
				String sql = "SELECT * FROM TRANSACTION WHERE CUSTOMER_ID = ?";
				logger.trace("Getting statement object in get all celebrities.");
				PreparedStatement statement = connection.prepareStatement(sql);
				int parameterIndex = 0;
				statement.setString(++parameterIndex, custIDString);
				ResultSet result = statement.executeQuery();
				
				List<Transaction> list = new LinkedList<>();
				// If you're using an alias you can replace it in the while statement.
				while(result.next()){
					list.add(new Transaction(
							result.getInt("TRANSACTION_ID"),
							result.getString("TRANSACTION_DATE"),
							result.getString("TRANSACTION_TYPE"),
							result.getDouble("PREVIOUS_BALANCE"),
							result.getDouble("CURRENT_BALANCE")
							));	
				}
				for(int i = 0; i < list.size();i++)
					System.out.println(list.get(i));
				return list;
			}catch (SQLException e){
				logger.error("Error while selecting all celebrities.");
			}
			return null;
		}
}
