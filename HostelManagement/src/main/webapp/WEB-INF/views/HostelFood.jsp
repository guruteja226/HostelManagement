<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hostel Food</title>
<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
	</style>
</head>
<body>
<h2>Hostel Food Service</h2>

<c:url var="addFood" value="/food/add"></c:url>

<form:form action="${addFood}" commandName="food">
<table>
<c:if test="${!empty food.name}">
	<tr>
	
		<td>
			<form:label path="fId">
			<spring:message text="FoodId"></spring:message>
			</form:label>
		</td>
		
		<td>
		<form:input path="fid" readonly="true" size="8" disabled='true'/>
		<form:hidden path="fid"/>
		</td>
		</tr>
</c:if>	
	<tr>				
		<td>
			<form:label path="fName">
			<spring:message text="Food Name"></spring:message>
			</form:label>
		</td>
		<td>
			<form:input path="fName"/>
		</td>
	</tr>
	
	<tr>
		<td>
		<form:label path="fSession"></form:label>
		<spring:message text="Food Session"></spring:message>
		<select>
			<option name="morning">Morning</option>
			<option name="afternoon">Afternoon</option>
			<option name="evening">Evening</option>
			<option name="night">Night</option>
		</select>
		</td>
		<td>
		<form:input path="fSession"/>
		</td>
	</tr>
	
	<tr>
		<td colspan="2">
		<c:if test="${!empty food.name}">
		<input type="submit" value="<spring:message text="Edit Food"/>"/>
		</c:if>
		
		<c:if test="${empty food.name}">
		<input type="submit" value="<spring:message text="Add Food"/>"/>
		</c:if>
		</td>
	</tr>
</table>
</form:form>
<br>
<h3>Food List</h3>

<c:if test="${!empty foodList}">
	<table class="tg">
	<tr>
		<th width="80">FoodId</th>
		<th width="80">FoodName</th>
		<th width="80">FoodSession</th>
	</tr>
	
	<c:forEach items="${foodList}" var="food">
	<tr>
		<td>${foodId}</td>
		<td>${foodName}</td>
		<td>${foodSession}</td>
		<td><a href="<c:url value='edit/${food.fId}'/>">Edit</a></td>
		<td><a href="<c:url value='remove/${food.fId}'/>">delete</a></td>
	</tr>
	</c:forEach>
	</table>
</c:if>

</body>
</html>