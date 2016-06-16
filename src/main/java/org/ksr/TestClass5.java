package org.ksr;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Savepoint;

public class TestClass5 {

	public static void main(String[] args)throws Exception {
		Connection con=null;
		Savepoint savepoint=null;
		try{			
			con=JdbcConnectionUtil.getConnection();
			con.setAutoCommit(false);
			savepoint = con.setSavepoint("Savepoint1");
			PreparedStatement pst_1=con.prepareStatement("update b_user set user_name=? where user_id=?");
			pst_1.setString(1, "A1");
			pst_1.setInt(2, 1);
			int count=pst_1.executeUpdate();
			System.out.println("Updated records count :"+count);
			pst_1.close();
			PreparedStatement pst_2=con.prepareStatement("update b_user set is_active=? where user_id=?");
			pst_2.setString(1, "B1");
			pst_2.setInt(2, 2);
			int count_2=pst_2.executeUpdate();
			System.out.println("Updated records count :"+count_2);
			pst_1.close();
			con.commit();
			con.close();
		}catch(Exception exception){
			exception.printStackTrace();	
			con.rollback(savepoint);
		}
		finally{
			con.releaseSavepoint(savepoint);
			con.close();			
		}
	}
}
