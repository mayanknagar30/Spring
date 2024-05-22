<%@page import="com.rays.dto.UserDTO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		UserDTO dto = (UserDTO) request.getAttribute("dto");
		String msg = (String) request.getAttribute("msg");
	%>
	<%
		if (dto != null) {
	%>
	<h1 align="center">Update User</h1>
	<%
		} else {
	%>
	<h1 align="center">Add User</h1>
	<%
		}
	%>
	<%
		if (msg != null) {
	%>
	<h3 align="center"><%=msg%></h3>
	<%
		}
	%>
	<form action="UserCtl" method="post">
		<table align="center">
			<input type="hidden" name="id"
				value="<%=(dto != null) ? dto.getId() : ""%>">
			<tr>
				<th>Name :</th>
				<td><input type="text" name="name"
					value="<%=(dto != null) ? dto.getName() : ""%>"></td>
			</tr>
			&nbsp;
			<tr>
				<th>LastName :</th>
				<td><input type="text" name="lastname"
					value="<%=(dto != null) ? dto.getLastname() : ""%>"></td>
			</tr>
			
			
			&nbsp;
			
			<tr>
				<th>Date :</th>
				<td><input type="<%=(dto != null) ? "text" : "date"%>"
					name="date"
					value="<%=(dto != null) ? dto.getUserdate() : ""%>"></td>
			</tr>
			&nbsp;
			<tr>
				<th></th>
				<td><input type="submit" name="operation"
					value="<%=(dto != null) ? "Update" : "save"%>"> <!-- <input
					type="reset"></td> -->
			</tr>
		</table>
	</form>
</body>
</html>
