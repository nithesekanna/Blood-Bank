package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/welcome")
public class welcome extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession hts = request.getSession();
		response.setContentType("text/html");
		String error=" ";
		String name=request.getParameter("name");
		String pass=request.getParameter("pass");
		if(name.equals("Nithese")&&pass.equals("1234")) {
			hts.setAttribute("name", name);
			request.setAttribute("value", name);
			request.getRequestDispatcher("home.jsp").include(request, response);
		}else {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/blood", "root", "Nithese@29");
			PreparedStatement pre=con.prepareStatement("select * from doctor where name=? and pass=?");
			pre.setString(1,name);
			pre.setString(2,pass);
			ResultSet rs=pre.executeQuery();
			if(rs.next()) {
				hts.setAttribute("name", name);
				response.sendRedirect("home.jsp");
			}else {
				error="username or password is incorrect";
				request.setAttribute("error", error);
				RequestDispatcher dispatch=request.getRequestDispatcher("login.jsp");
				dispatch.include(request, response);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		}
	}

}
