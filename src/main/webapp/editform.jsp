<%@page contentType="text/html" pageEncoding="UTF-8" import="Brilliant.Dao.UserDao,Brilliant.bean.User"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Form</title>
</head>
<body>
<%
String id=request.getParameter("id");
User u=UserDao.getRecordById(Integer.parseInt(id));
%>
<h1>Edit Form</h1>
<form action="edituser.jsp" method="post">
<input type="text" name="id" value="<%=u.getId() %>">
<table>
<tr>
<td>Name:</td>
<td><input type="text" name="name" value="<%= u.getName()%>"/></td></tr> 
<tr>
<td>Password:</td>
<td><input type="password" name="password" value="<%= u.getPassword()%>"/></td></tr>
<tr>
<td>Email:</td>
<td><input type="email" name="email" value="<%= u.getEmail()%>"/></td></tr>
<tr><td>Gender:</td><td>  
<input type="radio" name="gender" value="male"/>Male   
<input type="radio" name="gender" value="female"/>Female </td></tr>  
<tr>
<td>Country:</td>
<td>
<select name="country">
<option>India</option>
<option>USA</option>
<option>UK</option>
<option>Australia</option>
</select>
</td>
</tr>
<tr>
<td colspan="2">
<input type="submit" value="Edit user">
</td>
</tr>
</table>
</form>
</body>
</html>