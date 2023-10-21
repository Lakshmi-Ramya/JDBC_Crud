<%@page contentType="text/html" pageEncoding="UTF-8" import="Brilliant.Dao.UserDao,Brilliant.bean.User"%>
<jsp:useBean id="u" class="Brilliant.bean.User"></jsp:useBean>  
<jsp:setProperty property="*" name="u"/>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete User</title>
</head>
<body>
<% UserDao.delete(u);
response.sendRedirect("ViewUsers.jsp");%>
</body>
</html>