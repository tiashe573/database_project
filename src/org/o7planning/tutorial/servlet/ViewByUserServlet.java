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

@WebServlet("/ViewByUserServlet")
public class ViewByUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ViewByUserServlet() {
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
	        out.print("search result for user id: " + request.getParameter("user")  + ". ");
			PreparedStatement st = con.prepareStatement("select * from people where account_number = ?");

			st.setString(1, request.getParameter("user"));
			
			ResultSet rs = st.executeQuery();
			
		      String useremail = "";
		      // iterate through the java resultset
		      while (rs.next())
		      {
		        int id = rs.getInt("e_id");
		        String Lname = rs.getString("last_name");
		        String Fname = rs.getString("first_name");
		        String email = rs.getString("email");
		        useremail =  rs.getString("email");
		      
		        int anumber = rs.getInt("account_number");
			       
		        
		        // print the results
		        out.print("id is " + id);
		        out.print(". Last name is " + Lname);
		        out.print(". First name is " + Fname);
		        out.print(". Email is " + email);
		        out.print(". account number is" + anumber);
		      }
		      
		      	st = con.prepareStatement("select * from proxy where email = ?");

				st.setString(1, useremail);
				
				rs = st.executeQuery();
				
			      
			      // iterate through the java resultset
			      while (rs.next())
			      {
			        
				    String password = rs.getString("password");
			        int number = rs.getInt("level");
				       
			        
			        // print the results
			        out.print(". user level is " + number);
			        out.print(". user password is " + password + ".");
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
	        out.print("search result for user id: " + request.getParameter("user")  + ". ");
	        PreparedStatement st = con.prepareStatement("select * from people where account_number = ?");

			st.setString(1, request.getParameter("user"));
			
			ResultSet rs = st.executeQuery();
			
		      String name = "";
		      // iterate through the java resultset
		      while (rs.next())
		      {
		        int id = rs.getInt("e_id");
		        String Lname = rs.getString("last_name");
		        String Fname = rs.getString("first_name");
		        name = Fname + ' ' + Lname;
		      
		        int anumber = rs.getInt("account_number");
			       
		        
		        // print the results
		      }
	        
			st = con.prepareStatement("select * from Reservation where Guest_name = ?");

			st.setString(1, name);
			rs = st.executeQuery();
			
		      
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
			       
			       
		        
		        // print the results
		        out.print("id is " + id);
		        out.print(". Building is " + Building);
		        out.print(". Floor is " + Floor);
		        out.print(". Date is " + Date);
		        out.print(". Time is" + Time);
		        out.print(". Period is " + Period);
		        out.print(". Room charge is " + Room_Charge);
		        out.print(". Guest name is " + name);
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
