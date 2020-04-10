<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- JSTL includes -->
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<c:forEach var="user" items="${users}">
		<p>My user name is: <c:out value="${user.user_name}"></c:out>
		<p>My name is : <c:out value="${user.first_name} ${user.last_name}"></c:out></p>
		<p>The id is: <c:out value="${user.id }"></c:out></p>
		<p>I'm using the account: <c:out value="${user.account_type}"></c:out></p>
		<hr/>
	</c:forEach>

</body>
</html>