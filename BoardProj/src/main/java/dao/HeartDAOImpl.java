package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class HeartDAOImpl implements HeartDAO {

	@Override
	public void insertHeart(String memberId, Integer boardNum) throws Exception {
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement pstmt  = null;
		String sql = "insert into heart(mem_id,board_num) values(?,?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			pstmt.setInt(2, boardNum);
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
	public Integer selectHeart(String memberId, Integer boardNum) throws Exception {
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Integer heartNum = null;
		String sql = "select num from heart where mem_id=? and board_num =?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			pstmt.setInt(2, boardNum);
			rs = pstmt.executeQuery();
			if(rs!=null && rs.next()) {
				heartNum = rs.getInt("num");
			}
		} catch (Exception e) {
			e.printStackTrace();
			
		}finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(pstmt);
			JDBCUtil.close(conn);
		}
		
		
		return heartNum;
	}

	@Override
	public void deleteHeart(String memberId,Integer boardNum) throws Exception {
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement pstmt = null;
		String sql = "delete from heart where mem_id=? and board_num=?";
		
		try {
			pstmt =conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			pstmt.setInt(2,boardNum);
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

}
