package JDBCTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

public class postgreSQL {
	
	private static Logger logger = Logger.getLogger(postgreSQL.class);
	
	public static void main(String[] args) throws  InstantiationException, IllegalAccessException, ClassNotFoundException{
		System.setProperty("jdbc.drivers", "org.postgresql.Driver");
		String jdbc = System.getProperty("jdbc.drivers");
		logger.info("=====" + jdbc);
		
		//Class.forName("org.postgresql.Driver").newInstance();
		String url ="jdbc:postgresql://localhost/Mytest";
		    //myDB为数据库名
		String user="postgres";;
		String password="root123";
		Connection conn =null ;
		try{
			conn= DriverManager.getConnection(url,user,password);
			Statement stat = conn.createStatement();
			//stat.execute("create table greet(message char(20))");
			//stat.execute("insert into greet values('hello,word!')");
			stat.execute("drop table gohigh");
			stat.execute("create table gohigh (" +
								"name char(20) not null," +
								"id char(10) not null default '123456' primary key," +
								"sex char not null"
								+")");
			stat.execute("insert into gohigh values('luming','1736','m')");
			stat.execute("insert into gohigh values('chengqiang','1737','m')");
			stat.execute("insert into gohigh values('dashi','1738','m')");
			stat.execute("insert into gohigh values('wangyue','1739','m')");
			ResultSet set = stat.executeQuery("select * from gohigh as g order by id desc");
			while(set.next()){
				logger.info(set.getString("name") + set.getString("id") + set.getString("sex") );
			}
		
			
			
			logger.info("==============================");
			String sql2 = "select name,id,sex " +
					"from gohigh " +
					"where name=? ";
			PreparedStatement stat2 = conn.prepareStatement(sql2);
			stat2.setString(1, "wangyue");
			ResultSet set2 = stat2.executeQuery();
			while(set2.next()){
				logger.info(set.getString("name") + set.getString("id") + set.getString("sex") );
			}
			
			set.close();
			stat.close();
		}catch (SQLException e) {
			// TODO: handle exception
			for(Throwable t : e){
				logger.error(t.getMessage());
			}
		}finally{
			try {
				conn.close(); //关闭连接，释放JDBC资源
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
		}
		
	}

}
