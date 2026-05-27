package bank_management_system;

import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.Connection;

public class Conn {
	
	Connection connection;
	Statement statement;
	
	public Conn() {
		
		try {
			// connection with MySQL by JDBC driver 
			connection =  DriverManager.getConnection("jdbc:mysql://localhost:3306/bankSystem","root","Sh@ikh585");
			statement = connection.createStatement();
			
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		
	}

}
