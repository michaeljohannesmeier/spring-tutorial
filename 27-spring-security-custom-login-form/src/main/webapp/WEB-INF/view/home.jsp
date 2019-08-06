<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>luv2code Company Home Page</title>
</head>
<body>

	<h2>luv2code Company Home Page</h2>
	<hr>
	
	<p>Welcome to the luv2code company home page</p>
	
	
	
	<security:authorize access="hasRole('MANAGER')">
		<hr>
		<p>
			<a href="${pageContext.request.contextPath}/leaders">Leadership Meeting (Manager only)</a>
		</p>
	</security:authorize>
	
	<security:authorize access="hasRole('ADMIN')">
		<hr>
		<p>
			<a href="${pageContext.request.contextPath}/systems">System Meeting (Admin only)</a>
		</p>
	</security:authorize>
	
	<hr>
	
	<p>
	User: <security:authentication property="principal.username" />
	<br><br>
	Role(s): <security:authentication property="principal.authorities" />
	</p>
	
	<hr>
	
	<form:form action="${pageContext.request.contextPath}/logout"
		method="POST">
		
		<input type="submit" value="Logout" />
	
	</form:form>

</body>
</html>