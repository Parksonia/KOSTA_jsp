package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dto.Board;

public class BoardDAOImpl implements BoardDAO {

	@Override
	public void insertBoard(Board board) throws Exception {
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement pstmt = null;
		String sql = "insert into board(subject,content,writer,filename)values(?,?,?,?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getSubject());
			pstmt.setString(2, board.getContent());
			pstmt.setString(3, board.getWriter());
			pstmt.setString(4, board.getFilename());
			pstmt.executeQuery();
			conn.commit();
		
		} catch (Exception e) {
			
			e.printStackTrace();
			conn.rollback();
		}finally {
			JDBCUtil.close(pstmt);
			JDBCUtil.close(conn);
			
		}
		
	}

	@Override
	public Board selectBoard(Integer num) throws Exception {
		Connection conn = JDBCUtil.getConnection();
		Board board = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql= "select * from board where num=?";
		
		try {
			pstmt= conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rset = pstmt.executeQuery();
			
			if(rset !=null && rset.next()) {
				board = new Board();
				board.setNum(rset.getInt("num"));
				board.setSubject(rset.getString("subject"));
				board.setContent(rset.getString("content"));
				board.setWriter(rset.getString("writer"));
				board.setFilename(rset.getString("filename"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rset);
			JDBCUtil.close(pstmt);
			JDBCUtil.close(conn);
		}
		
		
		return board;
	}

}
