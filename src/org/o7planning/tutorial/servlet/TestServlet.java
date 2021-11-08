package org.o7planning.tutorial.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
    	ServletOutputStream out = response.getOutputStream();
        
        out.println("<html>");
        out.println("<head><title>Hello Servlet</title></head>");
        
        out.println("<body>");
        out.println("<h3>Hello World</h3>");
        out.println("This is my first Servlet");
        out.println("</body>");
        out.println("<html>");
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	   protected void doPost(HttpServletRequest request, 
			   HttpServletResponse response)
			           throws ServletException, IOException
			       {
			           try {
			        	   
		   Connection con = DatabaseConnection.initializeDatabase();
		   Statement stmt = con.createStatement();
    	   
	     
	       PreparedStatement st = con
	              .prepareStatement("INSERT INTO room VALUES (?, ?, ?, ?, ?)");

	     
	       st.setInt(1, Integer.valueOf(request.getParameter("room_id")));

	       // Same for second parameter
	       st.setString(2, request.getParameter("address"));
	       
	       st.setString(3, request.getParameter("description"));
	       
	       st.setInt(4, Integer.valueOf(request.getParameter("owner_id")));
	       
	       st.setInt(5, Integer.valueOf(request.getParameter("capcity")));
	       
	       

	       // Execute the insert command using executeUpdate()
	       // to make changes in database
	       st.executeUpdate();

	       // Close all the connections
	       st.close();
	       con.close();
	       
	       // Get a writer pointer 
	       // to display the successful result
	       PrintWriter out = response.getWriter();
	       
	       out.println("<html><body><b>Successfully Inserted"
	                   + "</b></body></html>");
	   }
	   catch (Exception e) {
	       e.printStackTrace();
	   }

}
}
