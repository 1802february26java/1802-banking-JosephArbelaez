package banking;

import static org.junit.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.revature.controller.Login;
import com.revature.controller.Transactions;
import com.revature.exception.InputException;
import com.revature.exception.LoginException;
import com.revature.repository.BankMemberRepositoryJbdc;

public class BankMemberDataAccessTest {

	private static final Transactions transactions = new Transactions();
	private static final Login loginClass = new Login();
	private static Logger logger = Logger.getLogger(BankMemberDataAccessTest.class);
	
	/*********************************************************
	 * Detecting Users Tests
	 * @throws LoginException 
	 *********************************************************/
	
	@Test
	public void checkUser22() throws LoginException{
		Object expected = 22;
		assertEquals(expected, BankMemberRepositoryJbdc.recallUser("Xeroph", "Arbelaez"));
	}
	
	@Test
	public void checkUser41() throws LoginException{
		Object expected = 41;
		assertEquals(expected, BankMemberRepositoryJbdc.recallUser("Cow", "1"));
	}
	@Test
	public void checkUser21() throws LoginException{
		Object expected = 21;
		assertEquals(expected, BankMemberRepositoryJbdc.recallUser("j", "j"));
	}
	
	/*********************************************************
	 * Check Balance Tests
	 *********************************************************/
	@Test
	public void checkBalance22() throws InputException{
		Object expected = 0.0;
		assertEquals(expected, Transactions.viewBalance(22));
	}
	
	@Test
	public void checkBalance21() throws InputException{
		Object expected = 0.0;
		assertEquals(expected, Transactions.viewBalance(21));
	}
	
	@Test
	public void checkBalance41() throws InputException{
		Object expected = 61.0;
		assertEquals(expected, Transactions.viewBalance(41));
	}
}
