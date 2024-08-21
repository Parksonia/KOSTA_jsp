package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dto.Member;

public class MemberDAOImpl implements MemberDAO {

	@Override
	public void insertMember(Member member) throws Exception {
		Connection conn = JDBCUtil.getConnection(); // db 커넥션 객체 생성
		PreparedStatement pstmt = null;
		String sql = "insert into member(id,name,password,email,address)"
				+ "values(?,?,?,?,?)";
		try {
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, member.getId()); // ? 1번부터 셋팅
		pstmt.setString(2,member.getName());
		pstmt.setString(3,member.getPassword());
		pstmt.setString(4,member.getEmail());
		pstmt.setString(5,member.getAddress());
		pstmt.executeQuery(); // 셋팅값 쿼리로 올리기 
		conn.commit(); // insert는 commit필수
		
		} catch (Exception e) {
		e.printStackTrace();
		conn.rollback();
		}finally {
			JDBCUtil.close(pstmt);
			JDBCUtil.close(conn);
		}
		
	}

	@Override
	public Member selectMember(String id) throws Exception {
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Member member = null;
		try {
		String sql = "select * from member where id=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,id);
		rset = pstmt.executeQuery(); // select문은 commit rollback필요 없음
		if(rset !=null && rset.next()) {
			
			/* String rsetid = rset.getString("id"); 굳이 없어도됨 */
			String name = rset.getString("name");
			String password = rset.getString("password");
			String email = rset.getString("email");
			String address = rset.getString("address");
			member = new Member(id,name,password,email,address);
		}
		
		}catch(Exception e) {
			e.printStackTrace();
			
		}finally {
			JDBCUtil.close(rset);
			JDBCUtil.close(pstmt);
			JDBCUtil.close(conn);
		}
		
		return member;
	}

}
