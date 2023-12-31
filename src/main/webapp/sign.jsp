<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign Up</title>
<style>
body {
      background-image: url('blood-login.jpg'); /* Replace with your image file */
      background-repeat: no-repeat;
      background-attachment: fixed;
      background-size: 70% 90%;
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
<form action="Signup">
<fieldset>
<legend><b>SIGN UP</b></legend>
<table>
<tr>
<td> &nbsp; </td>
</tr>
<tr>
<td><label for="name" title="user name can not have any space">Set User Name</label></td>
<td><input type="text" id="name" name="name" required><br></td>
</tr>
<tr> 
<td> &nbsp; </td>
</tr>
<tr>
<td><label for="pass">Set Password</label></td>
<td><input type="password" id="pass" name="pass" required><br></td>
</tr>
<tr> 
<td> &nbsp; </td>
</tr>
<tr>
<td><label for="cpass">Confirm Password</label></td>
<td><input type="password" id="cpass" name="cpass" required><br></td>
</tr>
<tr><td  colspan="2"><span style="color:red;"><%= error %></span></td></tr>
<tr> 
<td> &nbsp; </td>
</tr>
</table>
<button type="submit" value="submit">sign up</button><br>
</fieldset>
</form>
</body>
</html>