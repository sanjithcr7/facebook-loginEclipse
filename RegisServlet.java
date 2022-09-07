package facebooklogin;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import java.sql.*;


/**
 * Servlet implementation class RegisServlet
 */
@WebServlet("/regis")
public class RegisServlet extends GenericServlet {
	private static final long serialVersionUID = 1L;
	Connection con;
    /**
     * Default constructor. 
     */
    public RegisServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","tiger");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see Servlet#service(ServletRequest request, ServletResponse response)
	 */
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String s1=request.getParameter("name");
			String s2=request.getParameter("email");
			String s3=request.getParameter("username");
			String s4=request.getParameter("password");
			PreparedStatement ps=con.prepareStatement("insert into facebook1 values(?,?,?,?)");
			ps.setString(1,s1);
			ps.setString(2,s2);
			ps.setString(3,s3);
			ps.setString(4,s4);
			ps.executeUpdate();
			PrintWriter pw=response.getWriter();
			pw.println("<html><body>");
			pw.println("You have registered Successfully");
			pw.println("<a href=login.html>Login");
			pw.println("</a></body></html>");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
