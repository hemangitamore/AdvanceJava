package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;



/**
 * Servlet implementation class loginServlet
 */
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter printWriter = response.getWriter();
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
		    Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/logininfo", "root", "root");
			java.sql.Statement stm=conn.createStatement();
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String email=request.getParameter("email");
		String qry="select * from information where name='"+username+"' and password='"+password+"' and email='"+email+"'";
		ResultSet rs=stm.executeQuery(qry);
		if(rs.next()) {
		  // printWriter.println("<h4>Welcome "+username+"</h4>");
			HttpSession session=request.getSession();
			session.setAttribute("usernameSession", username);
			response.sendRedirect("profileServlet");
		}else {
			
			printWriter.println("<script>alert('Invalid user')</script>");
			printWriter.println("<script>location.href='index.html'</script>");
			
		}
		conn.close();
		
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(e);
			
		}
			
		}
		
	}


