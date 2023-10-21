<%@page contentType="text/html" pageEncoding="UTF-8" import="Brilliant.Dao.UserDao"%>
<jsp:useBean id="u" class="Brilliant.bean.User"></jsp:useBean>  
<jsp:setProperty property="*" name="u"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JSP Page</title>
</head>
<body>
<% int i =UserDao.update(u);
response.sendRedirect("ViewUsers.jsp");%>
</body>
</html>