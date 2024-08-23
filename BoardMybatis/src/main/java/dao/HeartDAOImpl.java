package dao;

import org.apache.ibatis.session.SqlSession;

import utils.MybatisSqlSessionFactory;

public class HeartDAOImpl implements HeartDAO {

	SqlSession sqlSession = MybatisSqlSessionFactory.getSqlSessionFactory().openSession();
	
	
	@Override
	public void insertHeart(String memberId, Integer boardNum) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public Integer selectHeart(String memberId, Integer boardNum) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteHeart(String memberId, Integer boardNum) throws Exception {
		// TODO Auto-generated method stub

	}

}
