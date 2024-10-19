package com.klu.jdbccs;

import java.sql.*;

public class App 
{
    public static void main( String[] args )throws Exception
    {
        
    	
    	 String url = "jdbc:mysql://localhost:3306/klu";
    	 String username = "root";
         String password = "1997";
         
         Connection con = DriverManager.getConnection(url, username, password);

         CallableStatement stmt = con.prepareCall("{CALL getDetails()}");
         
         ResultSet rs = stmt.executeQuery();
         
         while(rs.next())
         {
        	 System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3));
         }
    	con.close();
    }
}
