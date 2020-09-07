<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Institutions</title>
</head>
<body>
	<h1>Institutions</h1>
	<table>
		<tr>
			<td><a href="institutions?action=index"  class="btn btn-primary">Return</a> </td>
		</tr>
	</table>
	
	<table border="1" width="70%" align="center"  class="table-striped">
		<thead>
			<tr>
			 <td scope="col"> Id</td>
			 <td scope="col"> Acronym</td>
			 <td scope="col"> Name</td>
			 <td scope="col"> Web</td>
			 <td scope="col"> Type</td>		 
			 <td scope="col"> Edit</td>
			</tr>
		</thead>
		<c:forEach var="institution" items="${list}">
		<tbody>
			<tr>
				<td scope="row"><c:out value="${institution.id}"/></td>
				<td><c:out value="${institution.acronym}"/></td>
				<td><c:out value="${institution.nam}"/></td>
				<td><c:out value="${institution.web}"/></td>
				<td><c:out value="${institution.insti}"/></td>							
				<td class="btn btn-outline-success"><a href="institutions?action=showedit&id=<c:out value="${institution.id}" />">Edit</a></td>								
			</tr>
		</tbody>
		</c:forEach>
	</table>
	
</body>
</html>