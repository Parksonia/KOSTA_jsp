package dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import dto.Account;

public class BankDAO {
	
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mariadb://localhost:3306/testdb24","root","7564");
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void close(Connection conn) {
		try {
			if(conn!=null) conn.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Statement stmt) {
		try {
			if(stmt!=null) stmt.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(ResultSet rset) {
		try {
			if(rset!=null) rset.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void insertAccount(Account acc) {
		Connection conn = getConnection();
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
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(conn);
		}
	}
	
	public static Account selectAccount(String num) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = "select * from account where id=?";
		Account acc = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			rset = pstmt.executeQuery();
			if(rset!=null && rset.next()) {
				String name = rset.getString("name");
				Integer balance = rset.getInt("balance");
				String type = rset.getString("type");
				String grade = rset.getString("grade");
				acc = new Account(num,name,balance,type,grade);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
			close(conn);
		}
		
		return acc;
	}
	
	public static void updateBalance(Account acc) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		String sql = "update account set balance=? where id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, acc.getBalance());
			pstmt.setString(2, acc.getId());
			pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(conn);
		}
	}
	
	public static List<Account> selectAllAccount() {
		List<Account> accs = new ArrayList<>();
		Connection conn = getConnection();
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
			close(rset);
			close(stmt);
			close(conn);
		}
		return accs;
	}
}
