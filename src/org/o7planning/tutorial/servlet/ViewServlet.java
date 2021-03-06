package org.o7planning.tutorial.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.xdevapi.Statement;

@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ViewServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {

			String dbDriver = "com.mysql.cj.jdbc.Driver";
	        String dbURL = "jdbc:mysql:// localhost:3306/";
	        // Database name to access
	        String dbName = "mytestsql";
	        String dbUsername = "root";
	        String dbPassword = "123456";
	  
	        Class.forName(dbDriver);
	        Connection con = DriverManager.getConnection(dbURL + dbName,
	                                                     dbUsername, 
	                                                     dbPassword);
	        PrintWriter out = response.getWriter();
	        out.print("Search result for room id:" + request.getParameter("room_id")+ " ");
			PreparedStatement st = con.prepareStatement("select * from room where room_id = ?");

			st.setInt(1, Integer.valueOf(request.getParameter("room_id")));
			
			ResultSet rs = st.executeQuery();
			
			String location = "";
		      
		      // iterate through the java resultset
		      while (rs.next())
		      {
		        int id = rs.getInt("room_id");
		        String address = rs.getString("address");
		        location = address;
		        String description = rs.getString("description");
		        int ownerid = rs.getInt("owner_id");
			       
		        int capcity = rs.getInt("capcity");
			      
		        
		        // print the results
		        out.print("Room id is " + id);
		        out.print(". address is " + address);
		        out.print(". Room description is " + description);
		        out.print(". Owner id is " + ownerid);
		        out.print(". Room capcity is " + capcity);
		      }

			// Execute the insert command using executeUpdate()
			// to make changes in database
		      
		      	st = con.prepareStatement("select * from Address where address = ?");

				st.setString(1, location);
				
				 while (rs.next())
			      {
			        int floor = rs.getInt("floor");
			        int height = rs.getInt("height");
				       
			        int gis = rs.getInt("gis_coordinate");
				    int size = rs.getInt("size");
			        
			        // print the results
			        out.print(". Floor is " + floor);
			        out.print(". Height is " + height + " feet. ");
			        out.print(". Gis Coordinate is " + gis);
			        out.print(". Room size is " + size + " square feet.");
			      }
			// Close all the connections
			st.close();
			con.close();

			// Get a writer pointer
			// to display the successful result
			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			String dbDriver = "com.mysql.cj.jdbc.Driver";
	        String dbURL = "jdbc:mysql:// localhost:3306/";
	        // Database name to access
	        String dbName = "mytestsql";
	        String dbUsername = "root";
	        String dbPassword = "123456";
	  
	        Class.forName(dbDriver);
	        Connection con = DriverManager.getConnection(dbURL + dbName,
	                                                     dbUsername, 
	                                                     dbPassword);
	        PrintWriter out = response.getWriter();
	        out.print("Search result for room id:" + request.getParameter("room_idV")+ " ");
			PreparedStatement st = con.prepareStatement("select * from Reservation where room_id = ?");

			st.setInt(1, Integer.valueOf(request.getParameter("room_idV")));
			
			ResultSet rs = st.executeQuery();
			
		      
		      // iterate through the java resultset
		      while (rs.next())
		      {
		        int id = rs.getInt("room_id");
		        String Building = rs.getString("Building");
		        String Floor = rs.getString("Floor");
		        String Date = rs.getString("Date");
			       
		        String Time = rs.getString("Time");
			       
		        String Period = rs.getString("Period");
			       
		        String Room_Charge = rs.getString("Room_Charge");
			       
		        String Guest_Name = rs.getString("Guest_Name");
			       
		        
		        // print the results
		        out.print("id is " + id);
		        out.print(". Building is " + Building);
		        out.print(". Floor is" + Floor);
		        out.print(". Date is " + Date);
		        out.print(". Time is" + Time);
		        out.print(". Period is " + Period);
		        out.print(". Room charge is " + Room_Charge);
		        out.print(". Guest name is " + Guest_Name);
		      }

			// Execute the insert command using executeUpdate()
			// to make changes in database

			// Close all the connections
			st.close();
			con.close();

			// Get a writer pointer
			// to display the successful result
			

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
