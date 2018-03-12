package com.revature.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.revature.exception.LoginException;
import com.revature.model.BankMember;
import com.revature.util.ConnectionUtil;

public class BankMemberRepositoryJbdc implements BankMemberRepository{
	private static Logger logger = Logger.getLogger(ConnectionUtil.class);

	public boolean insert(BankMember member) {
		try(Connection connection = ConnectionUtil.getConnection()){

			int parameterIndex = 0;
			String sql = "INSERT INTO CUSTOMER(LAST_NAME, FIRST_NAME, USERNAME, PASSWORD) VALUES(?,?,?,?)";

			logger.trace("Getting statement object in insert Celebrity.");
			// Set up of parameters
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(++parameterIndex, member.getFirstName());
			statement.setString(++parameterIndex, member.getLastName());
			statement.setString(++parameterIndex, member.getUserName());
			statement.setString(++parameterIndex, member.getPassword());

			logger.trace("Parameters for insertion of Celebrity set.");
			//Executing parameter
			if(statement.executeUpdate() > 0){
				logger.trace("Member inserted sucessfully.");
				return true;
			}
		} catch (SQLException e){
			logger.error("Exception thrown while inserting new Celebrity.", e);
		}
		return false;
	}

	public static int recallUser(String username, String password) throws LoginException{
		logger.trace("Getting all User");
		int custID = 0;
		try(Connection connection = ConnectionUtil.getConnection()){
			String sql = "SELECT CUSTOMER_ID FROM CUSTOMER WHERE USERNAME = ? AND PASSWORD = ?";
			logger.trace("Getting statement object in get all celebrities.");

			PreparedStatement statement = connection.prepareStatement(sql);
			int parameterIndex = 0;
			statement.setString(++parameterIndex, username);
			statement.setString(++parameterIndex, password);
			ResultSet result = statement.executeQuery();
			logger.trace("Query executed successfully.");
			while(result.next()){
				custID = result.getInt("CUSTOMER_ID");
				logger.trace("CustID inserted correctly");
			}
			return custID;

		}catch (SQLException e){
			throw new LoginException("Login Failed.");
		}
	}
}
