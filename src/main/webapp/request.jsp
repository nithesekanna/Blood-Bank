<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="ISO-8859-1">
  <title>Request Blood</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      margin: 0;
      padding: 0;
      display: flex;
      justify-content: center;
      align-items: center;
      height: 100vh;
      background: url('blood-bank-donate.jpg') center/cover no-repeat; /* Replace 'blood_bank_background.jpg' with your actual image file */
    }

    form {
      background-color: rgba(255, 255, 255, 0.8);
      padding: 20px;
      border-radius: 8px;
      box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
      width: 300px;
      text-align: center;
    }

    label {
      display: block;
      margin-bottom: 8px;
    }

    input,
    select {
      width: 100%;
      padding: 8px;
      margin-bottom: 12px;
      box-sizing: border-box;
    }

    input[type="submit"] {
      background-color: #e74c3c;
      color: white;
      cursor: pointer;
    }

    input[type="submit"]:hover {
      background-color: #c0392b;
    }
  </style>
</head>
<body>
<% 
String name = (String) session.getAttribute("name");
if (name == null) {
  request.setAttribute("error", "Login first");
  request.getRequestDispatcher("login.jsp").forward(request, response);
}
%>

<form action="data">
  <label for="bgroup">Enter your blood group:</label>
  <select name="bgroup">
    <option disabled selected value="">Select an option</option>
    <option value="O+">O+</option>
    <option value="O-">O-</option>
    <option value="B+">B+</option>
    <option value="B-">B-</option>
    <option value="AB-">AB-</option>
    <option value="AB+">AB+</option>
  </select><br>&nbsp;<br>

  <label for="location">Enter location:</label>
  <input type="text" name="location"><br>&nbsp;<br>

  <input type="submit" value="Submit">
</form>
</body>
</html>
