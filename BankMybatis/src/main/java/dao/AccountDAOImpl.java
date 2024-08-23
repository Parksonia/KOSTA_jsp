package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import dto.Account;
import utils.MybatisSqlSessionFactory;

public class AccountDAOImpl implements AccountDAO {

	// MybatisSqlSessionFactory를 통해 SqlSession 생성
	SqlSession sqlSession = MybatisSqlSessionFactory.getSqlSessionFactory().openSession();
	
	
	@Override
	public void insertAccount(Account acc) throws Exception {
		
		//sql문 실행시켜! 해당 쿼리문에  Account 객체를 파라미터로 넘겨줄테니 라는 의미다~
		sqlSession.insert("mapper.account.insertAccount",acc);
		
		//자동커밋 안되니까 해줘야 함
		sqlSession.commit();

	}

	@Override
	public Account selectAccount(String id) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("mapper.account.selectAccount",id);
	}

	@Override
	public void updateBalance(Account acc) throws Exception {
		
		sqlSession.update("mapper.account.updateBalance",acc);
		sqlSession.commit();
	}

	@Override
	public List<Account> selectAllAccount() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("mapper.account.selectAllAccount");
	}

}
