package com.revature.repository;

import com.revature.exception.LoginException;
import com.revature.model.BankMember;

public interface BankMemberRepository {

	public boolean insert(BankMember member);

}
