package org.o7planning.tutorial.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.xdevapi.Statement;

@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServletOutputStream out = response.getOutputStream();

		out.println("<html>");
		out.println("<head><title>Edit Servlet</title></head>");

		out.println("<body>");
		out.println("This is my Edit Servlet");
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

	        out.print(request.getParameter("BuildingE"));

			int id = Integer.valueOf(request.getParameter("room_idE"));
			
			String ids = request.getParameter("room_idE");
			
			String building = request.getParameter("BuildingE");
			
			String floor = request.getParameter("FloorE");
			
			String date = request.getParameter("DateE");
			
			String period = request.getParameter("PeriodE");
			
			String room_charge = request.getParameter("Room_ChargeE");
			
			String guest_name = request.getParameter("Guest_NameE");
			
			PreparedStatement st = con.prepareStatement("Update Reservation set Building = ?,  Floor = ?, Date = ?, Time = ?, Period = ?, Room_Charge = ?, Guest_Name = ?  Where room_id = ?");
			
			st.setString(1, request.getParameter("BuildingE"));
			st.setInt(8, Integer.valueOf(request.getParameter("room_idE")));

			st.setString(2, request.getParameter("FloorE"));

			st.setString(3, request.getParameter("DateE"));

			st.setString(4, request.getParameter("TimeE"));
			
			st.setString(5, request.getParameter("PeriodE"));
			
			st.setString(6, request.getParameter("Room_ChargeE"));
			
			st.setString(7, request.getParameter("Guest_NameE"));

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
