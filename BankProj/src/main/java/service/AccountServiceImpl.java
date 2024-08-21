package service;

import java.util.List;

import dao.AccountDAO;
import dao.AccountDAOImpl;
import dao.BankDAO;
import dto.Account;

public class AccountServiceImpl implements AccountService {
	private AccountDAO accountDAO;
	public AccountServiceImpl() {
		accountDAO = new AccountDAOImpl();
	}
	
	@Override
	public Account makeAccount(Account acc) throws Exception {
		/* Account sacc = BankDAO.selectAccount(acc.getId()); */
		Account sacc = accountDAO.selectAccount(acc.getId());
		if(sacc!=null) throw new Exception("계좌번호 중복");
		// 계좌 DB에 저정
		BankDAO.insertAccount(acc);
		return acc;
	}

	@Override
	public Account deposit(String id, Integer money) throws Exception {
		/* Account sacc = BankDAO.selectAccount(id); */
		Account sacc = accountDAO.selectAccount(id);
		if(sacc==null) throw new Exception("계좌번호 오류");
		sacc.deposit(money); // account 의 deposit  메서드 호출하여 balance 업데이트
		BankDAO.updateBalance(sacc); // db에도 입금 후 업데이트 해줌
		return sacc;
		
	}

	@Override
	public Account withdraw(String id, Integer money) throws Exception {
		Account sacc = accountDAO.selectAccount(id);
		if(sacc==null) throw new Exception("계좌번호 오류");
		sacc.withdraw(money); // 출금
		BankDAO.updateBalance(sacc); // db도 출금 후 계좌 정보 업데이트		
		return sacc;
	}
	@Override
	public Account accountinfo(String id) throws Exception {
		Account sacc = accountDAO.selectAccount(id);
		if(sacc==null) throw new Exception("계좌번호 오류");
		return sacc;
	}
	@Override
	public List<Account> allacountinfo() throws Exception {
		List<Account> accs= accountDAO.selectAllAccount();
		if(accs == null) throw new Exception("조회 내역이 없습니다.");
		return accs;
	}
	@Override
	public void transfer(String sid, String rid, Integer money) throws Exception {
		Account sacc = accountDAO.selectAccount(sid);
		if(sacc==null) throw new Exception("보내는 계좌번호 오류");
		Account racc = accountDAO.selectAccount(rid);
		if(racc==null) throw new Exception("받는 계좌번호 오류");
		sacc.withdraw(money);
		racc.deposit(money);
		BankDAO.updateBalance(racc);
		BankDAO.updateBalance(sacc);
		
	}

	@Override
	public boolean doubleId(String id) throws Exception {
		Account saccount = accountDAO.selectAccount(id); 
		if(saccount == null) return false;  //사용가능 계좌 
		
		return true;
	}
}
