<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Page</title>
</head>
<body>
	<h1>Hello From Registration Page</h1>
	<form:form>
		<table>
			<tr>
				<td>
					Name:
				</td>
				<td>
					<form:input path="name" />
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="Add Registration">
				</td>
			</tr>
		</table>
	</form:form>
</body>
</html>