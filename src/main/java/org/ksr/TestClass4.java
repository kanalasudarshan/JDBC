package org.ksr;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class TestClass4 {

	public static void main(String[] args)throws Exception {
		Connection con=null;
		try{			
			con=JdbcConnectionUtil.getConnection();
			con.setAutoCommit(false);
			PreparedStatement pst_1=con.prepareStatement("update b_user set user_name=? where user_id=?");
			pst_1.setString(1, "A");
			pst_1.setInt(2, 1);
			int count=pst_1.executeUpdate();
			System.out.println("Updated records count :"+count);
			pst_1.close();
			PreparedStatement pst_2=con.prepareStatement("update b_user set is_active=? where user_id=?");
			pst_2.setString(1, "B");
			pst_2.setInt(2, 2);
			int count_2=pst_2.executeUpdate();
			System.out.println("Updated records count :"+count_2);
			pst_1.close();
			con.commit();
			con.close();
		}catch(Exception exception){
			exception.printStackTrace();		
		}
		finally{
			con.close();
		}
	}
}
