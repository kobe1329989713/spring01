<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML >
<html>
  <head>
    <title>My JSP 'user.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

  </head>
  
  <body>



  
  	<c:forEach var="user" items="${users}">
  		<h1>${user.id}====${user.username}===${user.email}</h1>
  	</c:forEach>
  	
  	
  	<form action="user/save.html" method="post" >
  		<p>用户名: <input type="text" name="username"></p>
  		<p>密码: <input type="text" name="password"></p>
  		<p>年龄: <input type="text" name="age"></p>
  		<p>邮箱: <input type="text" name="email"></p>
  		<p>地址: <input type="text" name="address"></p>
  		<input type="submit" value="注册"/>
  	</form>


  </body>
</html>