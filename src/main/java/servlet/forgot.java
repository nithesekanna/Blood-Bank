package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/forgot")
public class forgot extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
	
		String name=request.getParameter("uname");
		String pass=request.getParameter("pass");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/blood","root","Nithese@29");
			Statement pre=con.createStatement();
			String qry="update doctor set pass='"+pass+"' where name='"+name+"'";
			int rs=pre.executeUpdate(qry);
			if(rs>0) {
				request.setAttribute("msg", "update success");
				request.getRequestDispatcher("login.jsp").include(request, response);
			}else {
				request.setAttribute("error", "update failed . Retry");
				request.getRequestDispatcher("forgot.jsp").include(request, response);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		};
	}

}
