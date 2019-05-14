package com.isamm.imedjaberi;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connecteur {
	
	/**
	 * Connection with DataBase (mySQL ) .. 
	 */
	public static Connection getConnection() {
        Connection connect = null ;
       
		try {
	        	 // i user a MYSQL 8.0.12 ..  
	        	Class.forName("com.mysql.cj.jdbc.Driver"); 
	        	connect = DriverManager.getConnection(CustomData.URL);
		}catch(Exception ex){
            System.out.println("error : "+ex);
        }
        return connect;
	}
	
	

}
