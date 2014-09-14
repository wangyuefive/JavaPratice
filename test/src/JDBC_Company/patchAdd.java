package JDBC_Company;

import java.security.KeyStore.Builder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import JDBCTest.postgreSQL;

/**
 * 为了完成公司的 在批量修改终端上面的测试
 * @author wangyue
 *
 */
public class patchAdd {
	
	private static Logger logger = Logger.getLogger(postgreSQL.class);
	
	public static void main(String[] args) throws  InstantiationException, IllegalAccessException, ClassNotFoundException{
		System.setProperty("jdbc.drivers", "org.postgresql.Driver");
		String jdbc = System.getProperty("jdbc.drivers");
		
		String url ="jdbc:postgresql://192.216.3.145/ss3000i";
		String user="postgres";;
		String password="grespost2005";
		Connection conn =null ;
		try{
			conn= DriverManager.getConnection(url,user,password);
			if(conn.isValid(500))
				logger.info("conn is valid");
			//doAddTerminal(conn);
			doDeleteTerminal(conn);
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	private static int terminalID = 100;
	private static int usernoID = 50;
	private static int name = 3000 ;
	private static int terminalIP = 1;
	private static int totalCount =150;
	/**
	 * 添加tbl_terminal表中的终端
	 * @throws SQLException 
	 */
	
	private static void doAddTerminal(Connection conn) throws SQLException{
		Statement stat = conn.createStatement();
		StringBuilder builder = null;
		for(int i =100 ; i < 100+totalCount; i++){
			builder= new StringBuilder();
			builder.append("insert into tbl_bcterminal (terminalid,usernoid," +
				"relayid,name,terminalip,userno,issupportmp3) values(");
			builder.append(String.valueOf(terminalID + i) +",");
			builder.append(String.valueOf(usernoID + i) +",");
			builder.append("1,");
			builder.append("'"+String.valueOf(name + i)+"',");
			builder.append("'"+"127.0.0."+String.valueOf(terminalIP + i)+"',");
			builder.append("'"+String.valueOf(name + i)+ "',");
			builder.append("1)");
			String sql = builder.toString();
			logger.info(sql);
			stat.execute(sql);	
		}	
	}
	
	private static void doDeleteTerminal(Connection conn) throws SQLException{
		Statement stat = conn.createStatement();
		StringBuilder builder = null;
		for(int i = 0 ; i < totalCount; i++){
			builder= new StringBuilder();
			builder.append("delete from tbl_userno where userno='" + String.valueOf(name+i) + "'");
			String sql = builder.toString();
			logger.info(sql);
			stat.execute(sql);
		}
	}
}
