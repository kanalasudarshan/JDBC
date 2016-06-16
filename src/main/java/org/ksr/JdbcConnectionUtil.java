package org.ksr;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcConnectionUtil {
	
	private static Connection con=null;
	private JdbcConnectionUtil(){}
	static{
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ksr","sudarshan","Admin123");
		}catch(Exception exception){
			exception.printStackTrace();
		}
	}
	public static Connection getConnection(){
		return con;
	}

}
