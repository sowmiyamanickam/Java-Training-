<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://www.springframework.org/tags/form"

 prefix="form"%>

 <%@ taglib uri="http://java.sun.com/jsp/jstl/core"

 prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
</head>
<body>
<c:url var="log" value="/save"></c:url>
<form:form action="${log}" commandName="login">
<table>
<tr>
<td>User ID:</td>
<td><form:input path="id"/></td>
</tr>
<tr>
<td>Username:</td>
<td><form:input path="name"/></td>
</tr>
<tr>
<td>Password:</td>
<td><form:password path="password"/></td>
</tr>
<tr>
<td>email-id:</td>
<td><form:input type="email" path="email"/></td>
</tr>
<tr>
<td>Gender:</td>
<td><form:radiobutton path="gender" value="m"/>Male</td>
<td><form:radiobutton path="gender" value="f"/>Female</td>
<font color="red"/><form:errors path="gender"/>
</tr>
<tr>
<td>Subject:</td>
<td>Maths<form:checkbox path="subject" value="Maths"/></td>
<td>Chemistry<form:checkbox path="subject" value="Chemistry"/></td>
<td>Physics<form:checkbox path="subject" value="Physics"/></td>
<td>English<form:checkbox path="subject" value="English"/></td>
<font color="red"/><form:errors path="subject"/>
</tr>
<tr>
<td><input type="submit" value="save"/></td>
</tr>
</table>
</form:form>
</body>
</html>