package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/data")
public class data extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String bgroup;
	private static String location;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String bgroup=request.getParameter("bgroup");
		String location=request.getParameter("location");
		data.bgroup=bgroup;
		data.location=location;
		request.getRequestDispatcher("view").include(request, response);
		
	}
	public static Connection getcon() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/blood", "root", "Nithese@29");
		return con;
		
	}
	public static ArrayList<model> getvalue() {
		ArrayList<model> list=new ArrayList<>();
		try {
			Connection con = getcon();
			PreparedStatement pre=con.prepareStatement("select * from donors where bgroup=? and location=?");
			pre.setString(1,bgroup);
			pre.setString(2,location);
			ResultSet rs=pre.executeQuery();
			while(rs.next()) {
				model m=new model();
				m.setName(rs.getString(1));
				m.setBgroup(rs.getString(2));
				m.setPhone(rs.getString(3));
				m.setLocation(rs.getString(4));
				m.setDate(rs.getString(5));
				list.add(m);
			}
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();

		}
		return list;
		
	}

}
