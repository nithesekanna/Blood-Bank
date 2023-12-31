package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/view")
public class view extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        ArrayList<model> list = data.getvalue();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Donors List</title>");
        out.println("<style>");
        out.println("body { font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif; background-color: #f4f4f4; margin: 0;}");
        out.println("table { border-collapse: collapse; width: 80%; margin: 20px; }");
        out.println("th, td { border: 1px solid #dddddd; text-align: left; padding: 10px; }");
        out.println("th { background-color: #e74c3c; color: #fff; }"); // Blood red header
        out.println("td a { color: #fff; text-decoration: none; padding: 5px 10px; background-color: #e74c3c; border-radius: 3px; }");
        out.println("td a:hover { background-color: #c0392b; }"); // Darker red on hover
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");

        out.println("<table>");
        out.println("<tr><th>Name</th><th>Blood Group</th><th>Phone Number</th><th>Location</th><th>Last Donated Date</th><th>Request</th></tr>");
        for (model m : list) {
            String name = m.getName();
            String bg = m.getBgroup();
            String phn = m.getPhone();
            String loc = m.getLocation();
            String date = m.getDate();
            LocalDate today = LocalDate.now().minusMonths(6);
            LocalDate d = LocalDate.now();

            if (date != null) {
                d = LocalDate.parse(date);
            }

            if (d.isBefore(today) || date == null) {
                out.println("<tr><td>" + name + "</td><td>" + bg + "</td><td>" + phn + "</td><td>" + loc + "</td><td>" + date
                        + "</td><td><a href='update?name=" + name + "'>Request</a></td></tr>");
            }
        }
        out.println("</table>");

        out.println("</body>");
        out.println("</html>");
    }
}
