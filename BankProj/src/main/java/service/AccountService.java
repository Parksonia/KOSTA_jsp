package service;

import java.util.List;

import dto.Account;

public interface AccountService {
	Account makeAccount(Account acc) throws Exception;
	Account deposit(String id, Integer money) throws Exception;
	Account withdraw(String id,Integer money) throws Exception;
	Account accountinfo(String id) throws Exception;
	List<Account> allacountinfo() throws Exception;
	void transfer(String sid,String rid,Integer money) throws Exception;
}
