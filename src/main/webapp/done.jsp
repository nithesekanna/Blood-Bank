<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Blood Bank Message</title>
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

        #message {
            font-size: 24px;
            color: #e74c3c; /* Blood red color */
            text-align: center;
            margin-bottom: 20px;
        }

        a {
            color: #fff; /* White color for links */
            font-size: 18px;
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
        String message = (String)request.getAttribute("message");
        if (message == null) {
            message = "No message available.";
        }
    %>
    <table>
        <tr>
            <td>
                <p id="message"><%= message %></p>
                <a href="home.jsp">Back To Home Page</a>
            </td>
        </tr>
    </table>
</body>
</html>
