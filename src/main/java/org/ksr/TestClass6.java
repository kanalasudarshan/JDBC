package org.ksr;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Savepoint;
import java.sql.Statement;

public class TestClass6 {

	public static void main(String[] args)throws Exception {
		Connection con=null;
		Savepoint savepoint=null;
		try{			
			con=JdbcConnectionUtil.getConnection();
			con.setAutoCommit(false);
			savepoint = con.setSavepoint("Savepoint1");
		
			Statement st=con.createStatement();
			String sql_1="insert into b_user(user_name,first_name,last_name,is_active) values('A1','x','y',true)";
			st.addBatch(sql_1);
			String sql_2="insert into b_user(user_name,first_name,last_name,is_active) values('A2','x','y',true)";
			st.addBatch(sql_2);
			String sql_3="insert into b_user(user_name,first_name,last_name,is_active) values('A3','x','y',true)";
			st.addBatch(sql_3);
			String sql_4="insert into b_user(user_name,first_name,last_name,is_active) values('A4','x','y',true)";
			st.addBatch(sql_4);
			int[] count=st.executeBatch();	
			System.out.println(count.length);
			
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
