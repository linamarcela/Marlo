<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script> 
   <script type="text/JavaScript">
   $(document ).ready(function() {
	    //$("#id").prop( "disabled", true);	    
	});
   
   function requieredLocation(){
	   var elem = $("#elem").val();
	   var loca = $("#loca").val();
	   
	   if(loca == ''){
		   alert("Selected Location");
		   event.preventDefault();
	   }else if(elem == ''){
		   alert("Selected Element");
		   event.preventDefault();
	   }
   }
   
   function setIdLoca(idLoca){	   
	   $("#idLoca").val(idLoca);
   }
</script>
<title>Update Institution</title>
</head>
<body>
<h1>Update Institution</h1>
	<table>
		<tr>
			<td><a href="institutions?action=mostrarInstitution"  class="btn btn-primary">Return</a> </td>
		</tr>
	</table>
	<form action="institutions?action=edit" method="post" >
		<label><b>General Information</b></label>		
		<table>
			<tr>
				<td><label>Id</label></td>
				<td><input type="text" name="id" id="id" value="<c:out value="${institution.id}"></c:out>" ></td>
			</tr>
			<tr>
				<td><label>Acronym</label></td>
				<td><input type="text" name="acronym" id="acronym" required value='<c:out value="${institution.acronym}"></c:out>' ></td>
			</tr>			
			<tr>
				<td><label>Name</label></td>
				<td><input type="text" name="nam" id="nam" required value='<c:out value="${institution.nam}"></c:out>' ></td>
			</tr>
			<tr>
				<td><label>Web</label></td>
				<td><input type="text" name="web" id="web" required value='<c:out value="${institution.web}"></c:out>' ></td>
			</tr>
			<tr>
				<td><label>Institution</label></td>
				<td>
					<select name="insti">
						<c:forEach var="listInstitutionType" items="${listInts}">
							<option value="${listInstitutionType.id}" >${listInstitutionType.name}</option>		
						</c:forEach>      					
    				</select>					
				</td>
			</tr>			
		</table>
	
		<input type="submit" name="update" value="Save"> 
		<br>
		<div align="center" ><label><b>Locations</b></label></div>
		<table border="1" width="40%" align="center"  class="table-striped">
			<thead>
				<tr>
				 <td scope="col"> Id</td>	
				 <td scope="col"> Location</td>
				 <td scope="col"> Element</td>				 	 
				 <td scope="col"> Delete</td>
				</tr>
			</thead>
			<c:forEach var="location" items="${list}">
			<tbody>
				<tr>
					<td scope="row"><c:out value="${location.id}"/></td>
					<td scope="row"><c:out value="${location.city}"/></td>
					<td scope="row"><c:out value="${location.name}"/></td>
					<td>
						<input type="submit" name="adicionar" value="Delete" onclick="setIdLoca(${location.id})">						
					</td>																		
				</tr>
			</tbody>
			</c:forEach>
				<input type="text" name="idLoca" id="idLoca" style="display:none">			
		</table>
		
		<table>			
			<tr>
				<td><label>Location</label></td>
				<td>
					<select name="loca" id="loca">
						<option value="" >Select</option>
						<c:forEach var="listLocationSel" items="${listSel}">
							<option value="${listLocationSel.city}" >${listLocationSel.city}</option>		
						</c:forEach>      					
    				</select>					
				</td>
			</tr>
			<tr>
				<td><label>Element</label></td>
				<td>
					<select name="elem" id="elem">
						<option value="" >Selec</option>
						<c:forEach var="listElements" items="${listEle}">
							<option value="${listElements.id}" >${listElements.name}</option>		
						</c:forEach>      					
    				</select>					
				</td>
			</tr>		
		</table>
		<input type="submit" name="adicionar" value="Add" onclick="requieredLocation()">
	</form>

</body>
</html>