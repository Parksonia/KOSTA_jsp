package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

/*커넥션 풀*/
public class JDBCUtil {
	public static Connection getConnection() {
		Connection conn =null;
		try {
			/* META-INF에 저장한 context.xml에 있는 데이터 소스 정보를 사용하여 db 커넥션 */
			Context initCtx = new InitialContext();
			Context envCtx = (Context)initCtx.lookup("java:comp/env");
			DataSource ds = (DataSource)envCtx.lookup("jdbc/kosta"); 
			conn=ds.getConnection(); // 생성된 커넥션 풀에서 하나를 가져오는 것 
			conn.setAutoCommit(false); // auto commit을 false로 했기때문에  커밋하지않으면 쿼리업데이트 안됨
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
		
	}
	public static void commit(Connection conn) {
		try {
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void rollback(Connection conn) {
		try {
			conn.rollback();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/* 에러 처리 하면서 종료 start */
	public static void close(Connection conn) {
		try {
			if(conn!=null) conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void close(Statement stmt) {
		try {
			if(stmt!=null) stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void close(ResultSet rset) {
		try {
			if(rset!=null) rset.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/* 에러 처리 end */
	
}
