package org.ksr;

import java.sql.Connection;
import java.sql.Statement;

public class TestClass2 {

	public static void main(String[] args) {
		try{			
			Connection con=JdbcConnectionUtil.getConnection();
			Statement st=con.createStatement();
			int count=st.executeUpdate("update b_user set user_name='sudarshan reddy' where user_id=2");
			System.out.println("Updated records count :"+count);
		}catch(Exception exception){
			exception.printStackTrace();
		}
	}
}
