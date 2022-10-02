package com.masai.utility;

import java.sql.Connection;
import java.sql.SQLException;

public class DBMain {
	
	public static void main(String[] args) throws SQLException {
		
		Connection con = DBConnection.provideConnection();
		
		
		if(con != null) {
			System.out.println("Connected");
		}else {
			System.out.println("There is some Error while connecting to sql ");
		}
		
		
	}

}
