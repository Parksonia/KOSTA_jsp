package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dto.Account;

public class AccountDAOImpl implements AccountDAO {

	@Override
	public void insertAccount(Account acc) throws Exception {
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement pstmt = null;
		String sql = "insert into account (id,name,balance,type, grade) values (?,?,?,?,?)";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, acc.getId());
			pstmt.setString(2, acc.getName());
			pstmt.setInt(3, acc.getBalance());
			pstmt.setString(4, acc.getType());
			pstmt.setString(5,acc.getGrade());
			pstmt.executeQuery();
			conn.commit();// false 니까 커밋 필수 (insert,delete,update)
		} catch(SQLException e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			JDBCUtil.close(pstmt);
			JDBCUtil.close(conn);
		}

	}

	@Override
	public Account selectAccount(String id) throws Exception {
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = "select * from account where id=?";
		Account acc = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rset = pstmt.executeQuery();
			if(rset!=null && rset.next()) {
				String name = rset.getString("name");
				Integer balance = rset.getInt("balance");
				String type = rset.getString("type");
				String grade = rset.getString("grade");
				acc = new Account(id,name,balance,type,grade);
			}
		} catch(SQLException e) {
			e.printStackTrace();
	       //select 는 commit rollback필요 없음!
		} finally {
			JDBCUtil.close(rset);
			JDBCUtil.close(pstmt);
			JDBCUtil.close(conn);
		}
		
		return acc;
	}

	@Override
	public void updateBalance(Account acc) throws Exception {
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement pstmt = null;
		String sql = "update account set balance=? where id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, acc.getBalance());
			pstmt.setString(2, acc.getId());
			pstmt.executeUpdate();
			conn.commit(); //update니까 커밋!!
			
		} catch(SQLException e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			JDBCUtil.close(pstmt);
			JDBCUtil.close(conn);
		}
	}

	@Override
	public List<Account> selectAllAccount() throws Exception {
		List<Account> accs = new ArrayList<>();
		Connection conn = JDBCUtil.getConnection();
		Statement stmt = null;
		ResultSet rset = null;
		String sql = "select * from account";
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(sql);
			if(rset!=null) {
				while(rset.next()) {
					String id = rset.getString("id");
					String name = rset.getString("name");
					Integer balance = rset.getInt("balance");
					String type = rset.getString("type");
					String grade = rset.getString("grade");
					accs.add(new Account(id,name,balance,type, grade));
				}
			}
		} catch(SQLException e) {
			e.printStackTrace();
			
		} finally {
			JDBCUtil.close(rset);
			JDBCUtil.close(stmt);
			JDBCUtil.close(conn);
		}
		return accs;
	}

}
