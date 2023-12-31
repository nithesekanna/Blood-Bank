<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Success</title>
    <style type="text/css">
        body {
            background-color: #f4f4f4; /* Light gray background */
            margin: 0;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        }

        table {
            width: 100%;
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
        }

        #success {
            font-size: 40px;
            color: #e74c3c; /* Blood red color */
            text-align: center;
            margin-bottom: 20px;
        }

        a {
            color: #fff; /* White color for links */
            font-size: 20px;
            text-decoration: none;
            background-color: #e74c3c; /* Blood red color for links */
            padding: 10px 20px;
            border-radius: 5px;
            transition: background-color 0.3s ease;
        }

        a:hover {
            background-color: #c0392b; /* Slightly darker red on hover */
        }
    </style>
</head>
<body>
    <% 
        String log = (String)request.getAttribute("log");
        if (log == null) {
            log = " ";
        }
    %>
    <table>
        <tr>
            <td>
                <p id="success"><%= log %></p>
                <a href="login.jsp">Back to Login</a>
            </td>
        </tr>
    </table>
</body>
</html>
