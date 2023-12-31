package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/database")
public class database extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		String bgroup=request.getParameter("bgroup");
		String phone=request.getParameter("phone");
		String location=request.getParameter("location");
		if(validate(name,phone,location)) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/blood", "root", "Nithese@29");
				PreparedStatement pre=con.prepareStatement("insert into donors(name,bgroup,phone,location) values(?,?,?,?)");
				pre.setString(1,name);
				pre.setString(2,bgroup);
				pre.setString(3,phone);
				pre.setString(4,location);
				int num=pre.executeUpdate();
				if(num>0) {
					request.setAttribute("message", "Thank You For Donating Your Blood");
					request.getRequestDispatcher("done.jsp").forward(request, response);
				}else {
					request.setAttribute("message", "Server Error! try again");
					request.getRequestDispatcher("done.jsp").forward(request, response);
				}
			} catch (ClassNotFoundException | SQLException e) {
				
				e.printStackTrace();
			}
		}
		else {
			request.setAttribute("message", "Enter Valid Details");
			request.getRequestDispatcher("done.jsp").forward(request, response);
		}
		
	}
	public boolean validate(String name,String phone,String location) {
		if(name.matches("[a-zA-Z]+$")) {
			if(phone.matches("[0-9]+$")) {
				if(location.matches("[a-zA-Z]+$")) {
					return true;
				}
			}
		}
		
		return false;
		
	}


}
