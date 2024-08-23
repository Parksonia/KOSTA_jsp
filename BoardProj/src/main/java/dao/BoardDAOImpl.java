package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dto.Board;

public class BoardDAOImpl implements BoardDAO {

	@Override
	public void insertBoard(Board board) throws Exception {
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement pstmt = null;
		String sql = "insert into board(subject,content,writer,filename,dfilename)values(?,?,?,?,?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getSubject());
			pstmt.setString(2, board.getContent());
			pstmt.setString(3, board.getWriter());
			pstmt.setString(4, board.getFilename());
			pstmt.setString(5, board.getDfilename());
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
				board.setCreate_date(rset.getDate("create_date"));
				board.setView_cnt(rset.getInt("view_cnt"));
				board.setDfilename(rset.getString("dfilename"));
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

	@Override
	public void updateBoard(Board board) throws Exception {
		Connection conn = JDBCUtil.getConnection(); //커넥션풀에서 커넥션객체 가져오기
		PreparedStatement pstmt = null;
		String sql = "";
		
		if(board.getFilename() ==null) {
			sql = "update board set subject=?, content=? where num=?";
		}else {
			sql = "update board set subject=?, content=?, filename=? where num=?";
		}
	
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getSubject());
			pstmt.setString(2, board.getContent());
			
			if(board.getFilename() == null) {
				pstmt.setInt(3,board.getNum());
			}else {
				pstmt.setString(3,board.getFilename());
				pstmt.setInt(4,board.getNum());
				
			}
			pstmt.executeUpdate();
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
	public List<Board> selectBoardList(Integer row) throws Exception {
		 
		 Connection conn = JDBCUtil.getConnection();
		 PreparedStatement pstmt = null;
		 ResultSet rset = null;
		 // 최신글부터 보이도록 정렬 
		 // limit 0부터~10개 가져오기
		 String sql ="select * from board order by num desc limit ?,10"; 		 
		 List<Board> list = new ArrayList<>();
		 
		 try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, row-1);
			rset = pstmt.executeQuery();
			if(rset !=null) {
				while(rset.next()) {
					Board board = new Board();
					board.setNum(rset.getInt("num"));
					board.setWriter(rset.getString("writer"));
					board.setSubject(rset.getString("subject"));
					board.setContent(rset.getString("content"));
					board.setFilename(rset.getString("filename"));
					board.setCreate_date(rset.getDate("create_date"));
					board.setView_cnt(rset.getInt("view_cnt"));
					board.setDfilename(rset.getString("dfilename"));
					list.add(board);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			
		}finally {
			JDBCUtil.close(rset);
			JDBCUtil.close(pstmt);
			JDBCUtil.close(conn);
		}
		 
		 return list;
	}

	@Override
	public void updateViewCnt(Integer num) throws Exception {
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement pstmt = null;
		String sql ="update board set view_cnt=view_cnt+1 where num=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
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
	// 전체 게시글 수  가져오기 
	@Override
	public Integer selectBoardCount() throws Exception {
		Connection conn = JDBCUtil.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		Integer cnt = 0;
		String sql = "select count(*) from board";
		
		try {
			stmt = conn.createStatement();
			rs  = stmt.executeQuery(sql);
			if(rs!=null && rs.next()) {
				cnt = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(stmt);
			JDBCUtil.close(conn);
		}
		
		return cnt;
	}

}
