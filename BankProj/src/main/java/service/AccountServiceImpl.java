package service;

import dao.BankDAO;
import dto.Account;

public class AccountServiceImpl implements AccountService {

	@Override
	public Account makeAccount(Account acc) throws Exception {
		Account sacc = BankDAO.selectAccount(acc.getId());
		if(sacc!=null) throw new Exception("계좌번호 중복");
		// 계좌 DB에 저정
		BankDAO.insertAccount(acc);
		return acc;
	}

	@Override
	public Account deposit(String id, Integer money) throws Exception {
		Account sacc = BankDAO.selectAccount(id);
		if(sacc==null) throw new Exception("계좌번호 오류");
		sacc.deposit(money); // account 의 deposit  메서드 호출하여 balance 업데이트
		BankDAO.updateBalance(sacc); // db에도 입금 후 업데이트 해줌
		return sacc;
		
	}

	@Override
	public Account withdraw(String id, Integer money) throws Exception {
		Account sacc = BankDAO.selectAccount(id);
		if(sacc==null) throw new Exception("계좌번호 오류");
		sacc.withdraw(money); // 출금
		BankDAO.updateBalance(sacc); // db도 출금 후 계좌 정보 업데이트		
		return sacc;
	}
	@Override
	public Account accountinfo(String id) throws Exception {
		Account sacc = BankDAO.selectAccount(id);
		if(sacc==null) throw new Exception("계좌번호 오류");
		return sacc;
	}
}
