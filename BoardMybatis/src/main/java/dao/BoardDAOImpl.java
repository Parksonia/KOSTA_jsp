package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import dto.Board;
import utils.MybatisSqlSessionFactory;

public class BoardDAOImpl implements BoardDAO {
	
	SqlSession sqlSession = MybatisSqlSessionFactory.getSqlSessionFactory().openSession();
	
	

	@Override
	public void insertBoard(Board board) throws Exception {
		
		sqlSession.insert("mapper.board.insertBoard",board);
		sqlSession.commit();
	}

	@Override
	public Board selectBoard(Integer num) throws Exception {
		
		return sqlSession.selectOne("mapper.board.selectBoard",num);
	}

	@Override
	public void updateBoard(Board board) throws Exception {
		sqlSession.update("mapper.board.updateBoard",board);
		sqlSession.commit();
	}

	@Override
	public List<Board> selectBoardList(Integer row) throws Exception {
		return sqlSession.selectList("mapper.board.selectBoardList",row);
	}

	@Override
	public void updateViewCnt(Integer num) throws Exception {
		sqlSession.update("mapper.board.updateViewCnt",num);
		sqlSession.commit();

	}

	@Override
	public Integer selectBoardCount() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
