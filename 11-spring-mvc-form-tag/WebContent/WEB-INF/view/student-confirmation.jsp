<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

	<head>
		<title>Student Confirmation</title>
	</head>

	<body>
		<p>The student is confirmed: ${student.firstName } ${student.lastName }</p>
		<br>
		<p>Country: ${student.country }
		<br>
		<p>Favorite language: ${student.favoriteLanguage } </p>
		<br>
		 Operating system: 
			<ul>
				<c:forEach var="temp" items="${student.operatingSystems}">
					<li>${temp}</li>
				</c:forEach>
			</ul>
	</body>

</html>