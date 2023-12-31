<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Hospital</title>
    <style type="text/css">
        body {
            background-image: url('blood-home.png');
            background-repeat: no-repeat;
            background-attachment: fixed;
            background-size: 100% 110%;
            margin: 0;
            font-family: Arial, sans-serif;
        }

        #header {
            text-align: center;
            padding: 40px;
            background-color: #e74c3c; /* Red background color */
            color: white;
        }

        #login {
            text-align: center;
            margin-top: 20px;
        }

        a {
            text-decoration: none;
            color: #fff; /* White color for links */
            padding: 10px 20px;
            background-color: #c0392b; /* Dark red color for links */
            border: 2px solid #c0392b;
            border-radius: 5px;
            margin: 0 10px;
            transition: background-color 0.3s ease;
        }

        a:hover {
            background-color: #990000; /* Slightly lighter red color on hover */
        }
    </style>
</head>
<body>
    <% 
        String error = (String)request.getAttribute("error");
        if (error == null) {
            error = " ";
        }
    %>
    <div id="header">
        <h1>Welcome To The Blood Bank</h1>
        <div id="login">
            <a href="login.jsp">Login</a>
            <a href="donate.jsp">Donate Blood</a>
            <a href="request.jsp">Request Blood</a>
            <a href="signout.jsp">Sign Out</a>
            <%
                String name = (String)request.getAttribute("value");
                if (name != null) {
                    out.println("<a href='admin'> View all data </a>");
                }
            %>
        </div>
    </div>
</body>
</html>
