package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/update")
public class update extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name=request.getParameter("name");
		LocalDate cdate=LocalDate.now(); 
		String date=cdate.toString();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/blood", "root", "Nithese@29");
			PreparedStatement pre=con.prepareStatement("update donors set date=? where name=?");
			pre.setString(1, date);
			pre.setString(2, name);
			int num=pre.executeUpdate();
			if(num>0){
				request.setAttribute("message", "Donor Acquried");
				request.getRequestDispatcher("done.jsp").forward(request, response);
			}else {
				request.setAttribute("message", "Server Error! try again");
				request.getRequestDispatcher("done.jsp").forward(request, response);
			}
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
	}

}
