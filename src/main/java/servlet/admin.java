package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin")
public class admin extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
          
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/blood", "root", "Nithese@29");
                 PreparedStatement pre = con.prepareStatement("SELECT * FROM donors");
                 ResultSet rs = pre.executeQuery()) {

                out.println("<html>");
                out.println("<head>");
                out.println("<title>Admin Page</title>");
                out.println("<style>");
                out.println("body {");
                out.println("    font-family: Arial, sans-serif;");
                out.println("    display: flex;");
                out.println("    justify-content: center;");
                out.println("    align-items: center;");
                out.println("    height: 100vh;");
                out.println("    margin: 0;");
                out.println("    background-color: #e74c3c;"); 
                out.println("}");
                out.println("table {");
                out.println("    border-collapse: collapse;");
                out.println("    width: 80%;");
                out.println("    margin: 20px;");
                out.println("    background-color: white;"); 
                out.println("}");
                out.println("th, td {");
                out.println("    border: 1px solid #dddddd;");
                out.println("    text-align: left;");
                out.println("    padding: 8px;");
                out.println("}");
                out.println("th {");
                out.println("    background-color: #f2f2f2;");
                out.println("}");
                out.println("</style>");
                out.println("</head>");
                out.println("<body>");

                out.println("<table>");
                out.println("<tr><th>Name</th><th>Blood Group</th><th>Phone Number</th><th>Location</th><th>Last Donated Date</th></tr>");

                while (rs.next()) {
                    String name = rs.getString(1);
                    String bg = rs.getString(2);
                    String phn = rs.getString(3);
                    String loc = rs.getString(4);
                    String date = rs.getString(5);
                    out.println("<tr><td>" + name + "</td><td>" + bg + "</td><td>" + phn + "</td><td>" + loc + "</td><td>" + date + "</td></tr>");
                }

                out.println("</table>");

                out.println("</body>");
                out.println("</html>");

            } catch (SQLException e) {
               
                e.printStackTrace();
 
				request.setAttribute("message", "An error occurred while processing the request.");
				request.getRequestDispatcher("done.jsp").forward(request, response);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            
			request.setAttribute("message", "An error occurred while processing the request.");
			request.getRequestDispatcher("done.jsp").forward(request, response);
        }
    }
}
