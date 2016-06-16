package org.ksr;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Savepoint;
/**
 * 
 * @author skanala
 * 
 * 
 *  This class will illustrate about how to use savepoint in transactions
 *  
 *  To add savepoint first we have to make auto commit false
 *  Then add savepiont by using Savepoint class and pass savepoint object to rollback function in exception block 
 *
 */
public class TestClass7 {
	
	public static void main(String[] args)throws Exception {
		Connection con=null;
		Savepoint savepoint=null;
		try{			
			con=JdbcConnectionUtil.getConnection();
			con.setAutoCommit(false);
			savepoint = con.setSavepoint("Savepoint1");
			PreparedStatement pst_1=con.prepareStatement("update b_user set last_name=? where user_id=?");
			pst_1.setString(1, "A1");
			pst_1.setInt(2, 1);
			pst_1.addBatch();
			
			pst_1.setString(1, "B1");
			pst_1.setInt(2, 2);
			pst_1.addBatch();
			
			pst_1.setString(1, "A1");
			pst_1.setInt(2, 7);
			pst_1.addBatch();
			
			
			pst_1.setString(1, "B1");
			pst_1.setInt(2, 8);
			pst_1.addBatch();
			
			int[] count=pst_1.executeBatch();
			
			System.out.println("Updated records count :"+count.length);
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
