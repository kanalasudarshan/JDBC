package org.ksr;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class TestClass3 {

	public static void main(String[] args) {
		try{			
			Connection con=JdbcConnectionUtil.getConnection();
			PreparedStatement pst=con.prepareStatement("update b_user set user_name=? where user_id=?");
			pst.setString(1, "reddy");
			pst.setInt(2, 2);
			int count=pst.executeUpdate();
			System.out.println("Updated records count :"+count);
		}catch(Exception exception){
			exception.printStackTrace();
		}
	}
}
