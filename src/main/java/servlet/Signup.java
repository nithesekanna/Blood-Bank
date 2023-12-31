package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Signup")
public class Signup extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String name=request.getParameter("name");
		String pass=request.getParameter("pass");
		String cpass=request.getParameter("cpass");
		String error="";
		String log="";
		if(name.contains(" ")) {
			error="user name can not have any space";
			request.setAttribute("error", error);
			RequestDispatcher dispatcher =request.getRequestDispatcher("sign.jsp");
			dispatcher.forward(request, response);
		}else if(!pass.equals(cpass)) {
			error="password do not match";
			request.setAttribute("error", error);
			RequestDispatcher dispatcher =request.getRequestDispatcher("sign.jsp");
			dispatcher.forward(request, response);
		}else if(existName(name)) {
			error="user name already exist try different name";
			request.setAttribute("error", error);
			RequestDispatcher dispatcher =request.getRequestDispatcher("sign.jsp");
			dispatcher.forward(request, response);
		}else {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/blood","root","Nithese@29");
				Statement pre=con.createStatement();
				String qry="insert into doctor(name,pass) values('"+name+"','"+pass+"')";
				int rs=pre.executeUpdate(qry);
				if(rs>0) {
					log="Sign up Succesfull";
					request.setAttribute("log", log);
					RequestDispatcher dispatcher =request.getRequestDispatcher("success.jsp");
					dispatcher.forward(request, response);
				}else {
					out.println("<font color=red size=20px>sign up failed <br>");
				}
				
			} catch (ClassNotFoundException | SQLException e) {
				
				e.printStackTrace();
			};
			
		}
		
	}
	public boolean existName(String name) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/blood","root","Nithese@29");
			Statement pre=con.createStatement();
			String qry="select * from doctor where name='"+name+"'";
			ResultSet rs=pre.executeQuery(qry);
			if(rs.next()) {
				return true;
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		};
		return false;
	}

}
