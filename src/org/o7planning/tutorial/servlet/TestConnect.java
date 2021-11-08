package org.o7planning.tutorial.servlet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
public class TestConnect {
	private final static String url = "jdbc:mysql://localhost:3306/mytestsql";
	private final static String username = "root";
	private final static String password = "123456";

	public static void main(String args[]) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			Connection connect = DriverManager.getConnection(url, username, password);
			Statement statement = connect.createStatement();
			 String sql = "DROP TABLE IF EXISTS favorite_records";
		        statement.executeUpdate(sql);
		        sql = "DROP TABLE IF EXISTS Room";
		        statement.executeUpdate(sql);
		    
		        sql = "CREATE TABLE Room ("
		                + "room_id int NOT NULL,"
		                + "address VARCHAR(255) NOT NULL,"
		                + "description VARCHAR(255),"
		                + "owner_id int NOT NULL,"
		                + "capcity int,"
		                + "PRIMARY KEY (room_id)"
		                + ")";
		        
		        statement.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

