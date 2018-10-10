<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	当前用户：${user.userName }<br>
	<a href="${pageContext.request.contextPath }/logout">退出</a>
	<hr/>
	<table border="1">
		<tr>
			<th>用户ID</th><th>用户名</th><th>性别</th><th>操作</th>
		</tr>
		<c:forEach items="${users }" var="user">
		<tr>
			<td>${user.id }</td><td>${user.userName }</td><td>${user.sex }</td>
			<th><a href="${pageContext.request.contextPath }/delete/${user.id}">删除</a></th>
		</tr>
		</c:forEach>
	</table>
</body>
</html>