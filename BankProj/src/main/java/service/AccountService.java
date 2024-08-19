package service;

import dto.Account;

public interface AccountService {
	Account makeAccount(Account acc) throws Exception;
	Account deposit(String id, Integer money) throws Exception;
	Account withdraw(String id,Integer money) throws Exception;
	Account accountinfo(String id) throws Exception;
}
