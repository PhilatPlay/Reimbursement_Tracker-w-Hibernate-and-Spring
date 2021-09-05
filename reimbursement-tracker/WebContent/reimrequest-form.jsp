<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link type="text/css"
   rel="stylesheet"
   href="${pageContext.request.contextPath}/resources/css/style.css" class="add-button"/>
   <link type="text/css"
   rel="stylesheet"
   href="${pageContext.request.contextPath}/resources/css/add-reimrequest-style.css" class="add-button"/>
   <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
   integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
</head>
<body>
<div id="wrapper">
    	<div id="header">
    	<h2>Submit a Reimbursement Request</h2>
    	</div>
    </div>
    
    <div id="container">
		<h3>Submit Reinbursement Request</h3>
	
		<form:form action="saveReimRequest" modelAttribute="reimrequest" method="POST">

			<!-- need to associate this data with customer id -->
		<form:hidden path="id" />	
			<table>
				<tbody>
				<input type="hidden" name= "status" value="Pending" >
					<tr>
						<td><label>Amount:</label></td>
						<td><form:input path="amount" /></td>
					</tr>
					<tr>
						<td><label>Purpose:</label></td>
						<td><form:input path="purpose" /></td>
					</tr>
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>
				</tbody>
			</table>
		</form:form>
	
		<div style="clear; both;"></div>
		
		<p>
			<a href="${pageContext.request.contextPath}/reimrequest/list">Back to List</a>
		</p>
	
	</div>
</body>
</html>