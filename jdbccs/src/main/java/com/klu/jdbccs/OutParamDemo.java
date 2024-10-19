package com.klu.jdbccs;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

public class OutParamDemo {

	public static void main(String[] args) throws Exception
	{
		
		
		Connection  con = DriverManager.getConnection("jdbc:mysql://localhost:3306/klu","root","1997");
		
		CallableStatement stmt = con.prepareCall("{CALL getDetailsByOutParam(?)}");
		
		stmt.registerOutParameter(1, Types.INTEGER);
		
		
		stmt.execute();
		
		int cnt = stmt.getInt(1);
		System.out.println("No. of rows present in employee table: "+ cnt);
		con.close();

	}

}
