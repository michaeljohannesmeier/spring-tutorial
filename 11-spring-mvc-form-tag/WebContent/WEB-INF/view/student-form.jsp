<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>




<!DOCTYPE html>
<html>

	<body>
		<form:form action="processForm" modelAttribute="student">
		
			First name: <form:input path="firstName" />
			
			<br><br>
			
			Last name: <form:input path="lastName" />
			
			<br><br>
			
			Country: 
			
			<form:select path="country">
			
				<form:options items="${student.countryOptions }" />
			
			</form:select>
			
			<br><br>
			
			Favorite Programming Language:
			
			Java<form:radiobutton path="favoriteLanguage" value="Java" />
			Python<form:radiobutton path="favoriteLanguage" value="Python" />
			R<form:radiobutton path="favoriteLanguage" value="R" />
			C#<form:radiobutton path="favoriteLanguage" value="C#" />
			
			<br><br>
			
			Operating Systems:
			Linux <form:checkbox path="operatingSystems" value="Linux" />
			Mac <form:checkbox path="operatingSystems" value="Mac" />
			Windows <form:checkbox path="operatingSystems" value="Windows" />
			
			<input type="submit" value="Submit" />
		
		
		</form:form>
	</body>

</html>
