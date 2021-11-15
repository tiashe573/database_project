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
			 String sql = "DROP TABLE IF EXISTS Reservation";
		        statement.executeUpdate(sql);
		        sql = "DROP TABLE IF EXISTS Room";
		        statement.executeUpdate(sql);
		        
		        sql = "DROP TABLE IF EXISTS Item_Charge";
		        statement.executeUpdate(sql);
		        sql = "DROP TABLE IF EXISTS Equipment_Charge";
		        statement.executeUpdate(sql);
		        sql = "DROP TABLE IF EXISTS Total_Charge";
		        statement.executeUpdate(sql);
		        sql = "DROP TABLE IF EXISTS Time";
		        statement.executeUpdate(sql);
		        sql = "DROP TABLE IF EXISTS Avalibity";
		        statement.executeUpdate(sql);
		        sql = "DROP TABLE IF EXISTS Proxy";
		        statement.executeUpdate(sql);
		        sql = "DROP TABLE IF EXISTS people";
		        statement.executeUpdate(sql);
		        sql = "DROP TABLE IF EXISTS address";
		        statement.executeUpdate(sql);
		        sql = "DROP TABLE IF EXISTS owner";
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
		        
		        sql = "CREATE TABLE Reservation ("
		                + "room_id int NOT NULL,"
		                + "Building VARCHAR(255),"
		                + "Floor VARCHAR(255),"
		                + "Date VARCHAR(255),"
		                + "Time VARCHAR(255),"
		                + "Period VARCHAR(255),"
		                + "Room_Charge VARCHAR(255),"
		                + "Guest_Name VARCHAR(255),"
		                + "PRIMARY KEY (room_id)"
		                + ")";
		        
		        statement.executeUpdate(sql);
		        
		        sql = "CREATE TABLE Item_Charge ("
		                + "room_id int NOT NULL,"
		                + "item_id int NOT NULL,"
		                + "total_item_charge VARCHAR(255),"
		                + "numbers int,"
		                + "item_description VARCHAR(255),"
		                + "PRIMARY KEY (room_id)"
		                + ")";
		        
		        statement.executeUpdate(sql);
		        
		        sql = "CREATE TABLE Equipment_Charge ("
		                + "room_id int NOT NULL,"
		                + "equipment_id int NOT NULL,"
		                + "total_equipment_charge VARCHAR(255),"
		                + "number int,"
		                + "equipment_description VARCHAR(255),"
		                + "PRIMARY KEY (room_id)"
		                + ")";
		        
		        statement.executeUpdate(sql);
		        
		        sql = "CREATE TABLE Total_Charge ("
		        		+ "room_id int NOT NULL,"
		                + "equipment_id int NOT NULL,"
		                + "item_id int,"
		                + "total_item_charge VARCHAR(255),"
		                + "PRIMARY KEY (room_id)"
		                + ")";
		        
		        
		        statement.executeUpdate(sql);
		        
		        sql = "CREATE TABLE Time ("
                        + "time_id int NOT NULL,"
		        		+ "start_date VARCHAR(255),"
		                + "start_time VARCHAR(255),"
		                + "end_date VARCHAR(255),"
		                + "end_time VARCHAR(255),"
		                + "PRIMARY KEY (time_id)"
		                + ")";
		        
		        statement.executeUpdate(sql);
		        
		        
		        sql = "CREATE TABLE Avalibity  ("
                        + "serial_number int NOT NULL,"
		        		+ "Room_ID int NOT NULL,"
		                + "time_ID int NOT NULL,"
		                + "PRIMARY KEY (serial_number)"
		                + ")";
		        statement.executeUpdate(sql);
		        
		        sql = "CREATE TABLE Proxy  ("
                        + "email char(50) NOT NULL,"
		        		+ "Passward char(50),"
		                + "Level int ,"
		                + "PRIMARY KEY (email)"
		                + ")";
		        statement.executeUpdate(sql);
		        
		        sql = "CREATE TABLE Owner  ("
                        + "owner_id int NOT NULL,"
		        		+ "owner_phone char(50) ,"
		                + "PRIMARY KEY (owner_id)"
		                + ")";
		        statement.executeUpdate(sql);
		        
		        sql = "CREATE TABLE Address  ("
                        + "Address char(50) NOT NULL,"
		        		+ "floor int NOT NULL,"
		                + "height int ,"
		                + "GIS_coordinate float ,"
		                + "size int,"
		                + "PRIMARY KEY (Address)"
		                + ")";
		        statement.executeUpdate(sql);
		        sql = "CREATE TABLE People  ("
                        + "e_id int NOT NULL,"
		        		+ "last_name char(50) NOT NULL,"
		                + "first_name char(50) NOT NULL,"
		                + "email char (50) NOT NULL,"
		                + "account_number int,"
		                + "PRIMARY KEY (e_id)"
		                + ")";
		        statement.executeUpdate(sql);
		        
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}