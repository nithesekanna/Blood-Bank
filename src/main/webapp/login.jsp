<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<style>
body {
      background-image: url('blood-login.jpg'); /* Replace with your image file */
      background-repeat: no-repeat;
      background-attachment: fixed;
      background-size: 70% 100%;
      margin: 0;
      font-family: Arial, sans-serif;
}

legend {
    text-align: center;
    color: #e74c3c; /* Blood red color */
}

fieldset {
    width: 25%;
    height: 40%;
    text-align: center;
    border: 3px double #e74c3c; /* Blood red color */
    margin: 150px 0 0 45px;
    background-color: rgba(255, 192, 192, 0.3);
}

label {
    color: #e74c3c; /* Blood red color */
}

td {
    white-space: nowrap;
}

button {
    background-color: #e74c3c; /* Blood red color */
    color: white;
}

button:hover {
    background-color: #c0392b; /* Slightly darker red on hover */
}
</style>

</head>
<body>
<% 
String error=(String)request.getAttribute("error");
if(error==null){
	error=" ";
}
%>
<form action="welcome">
<fieldset>
<legend><b>LOGIN</b></legend>
<table>
<tr>
<td> &nbsp; </td>
</tr>
<tr>
<td  colspan="2"><span style="color:red;"><%= error %></span></td>
</tr>
<tr>
<td><label for="name" class="input">USER NAME</label></td>
<td><input type="text" id="name" name="name" required><br></td>
</tr>
<tr> 
<td> &nbsp; </td>
</tr>
<tr>
<td><label for="pass" class="input">PASSWORD</label></td>
<td><input type="password" id="pass" name="pass" required><br></td>
</tr>
<tr> 
<td> &nbsp; </td>
</tr>
</table>
<button type="submit" value="submit">login</button><br>
<a href="forgot.jsp" title="forgot password" class="sign">forgot password</a><br>
<a href="sign.jsp" title="Sign Up" class="sign">don't have a account</a>
</fieldset>
</form>
</body>
</html>