package org.ksr;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


public class TestClass1 {
	public static void main(String[] args) {
		try{			
			Connection con=JdbcConnectionUtil.getConnection();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select *from b_user");
			while(rs.next()){
				System.out.println(rs.getString("user_name"));
			}
		}catch(Exception exception){
			exception.printStackTrace();
		}
	}
}
