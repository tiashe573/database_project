package org.o7planning.tutorial.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.concurrent.TimeUnit;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.xdevapi.Statement;

@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServletOutputStream out = response.getOutputStream();

		out.println("<html>");
		out.println("<head><title>add Servlet</title></head>");

		out.println("<body>");
		out.println("This is my add Servlet");
		out.println("</body>");
		out.println("<html>");
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
	        out.print(request.getParameter("room_id"));
			PreparedStatement st = con.prepareStatement("INSERT INTO Reservation VALUES (?, ?, ?, ?, ?, ?, ?, ?)");

			st.setInt(1, Integer.valueOf(request.getParameter("room_id")));

			st.setString(2, request.getParameter("Building"));

			st.setString(3, request.getParameter("Floor"));

			st.setString(4, request.getParameter("Date"));

			st.setString(5, request.getParameter("Time"));
			
			st.setString(6, request.getParameter("Period"));
			
			st.setString(7, request.getParameter("Room_Charge"));
			
			st.setString(8, request.getParameter("Guest_Name"));

			// Execute the insert command using executeUpdate()
			// to make changes in database
			st.executeUpdate();

			// Close all the connections
			st.close();
			con.close();

			// Get a writer pointer
			// to display the successful result
			

			out.println("<html><body><b>Successfully Inserted" + "</b></body></html>");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
