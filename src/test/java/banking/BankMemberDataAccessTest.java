package banking;

import org.apache.log4j.Logger;
import org.junit.Before;

import com.revature.model.BankMember;
import com.revature.repository.BankMemberRepositoryJbdc;

public class BankMemberDataAccessTest {

	private static Logger logger = Logger.getLogger(BankMemberDataAccessTest.class);
	
	private BankMemberRepositoryJbdc repository;
	
	// Mock Objects
	private BankMember memberTest;
	
	//@Before
	//public void setUp(){
		//repository = BankMemberRepositoryJbdc.getInstance();
		//memberTest = new BankMember(0, "Arbelaez", "Joseph", 10.0, "Jarbelaez", "password");
	//}
}
