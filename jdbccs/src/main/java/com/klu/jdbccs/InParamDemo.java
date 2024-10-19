package com.klu.jdbccs;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class InParamDemo {

	public static void main(String[] args)throws Exception
	{
		
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/klu", "root","1997");
		
		CallableStatement stmt = con.prepareCall("{CALL getDetailsByEmpID(?)}");
		
		stmt.setInt(1,1003 );
		
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()) {
			
			
       	 System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3));
			
			
		}
		
    con.close();
	}

}
