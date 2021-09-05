<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!Doctype html>
<html>
  <head>
    <title>Request Tickets</title>
   <link type="text/css"
   rel="stylesheet"
   href="${pageContext.request.contextPath}/resources/css/style.css" class="add-button"/>
   <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
            integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
  </head>
  <body>
    <h1>More Requests coming soon...</h1>
    
    <!--  add a search box -->
          <!--  <form:form action="search" method="GET">
                Search Requests: <input type="text" name="theSearch" />
                <input type="submit" value="Search" class="add-button" />
            </form:form>   -->
    
    <div id="container">
    	<div id="content">
    		<!--  add button-->
    		<input class="mb-2 btn btn-outline-success" type="button" value="Add Reimbursement Request" 
    		onclick="window.location.href='showFormForAdd'; return false;">
    		
    		<table>
    			<tr>
    				<th>Id</th>
    				<th>Requestor Id</th>
    				<th>Amount</th>
    				<th>Purpose</th>
    				<th>Status</th>
    				<th>Date</th>
    				<th>Approve</th>
    				<th>Decline</th>
    				<th>Delete</th>
    			</tr>
    			<!-- loop over and print our requests -->
    		 <c:forEach var="theReimRequest" items="${reimrequests}"> 
    		 
    		 <!-- update link with request maker's id -->
    		 <c:url var="approveLink" value="/reimrequest/approve">
						<c:param name="theReimRequestd" value="${theReimRequest.id}" />
					</c:url>
    			|
    			<!-- update link with request maker's id -->
    		 <c:url var="declineLink" value="/reimrequest/decline">	
    			<c:param name="theReimRequestd" value="${theReimRequest.id}" />
    			</c:url>
    			|
    			<!-- update link with request maker's id -->
    		 <c:url var="decleteLink" value="/reimrequest/delete">	
    			<c:param name="theReimRequestd" value="${theReimRequest.id}" />
    			</c:url>
    			
    			<tr>
    				<td> ${theReimRequest.id}</td>
    				<td> ${theReimRequest.requestorId}</td>
    				<td> ${theReimRequest.amount}</td>
    				<td> ${theReimRequest.purpose}</td>
    				<td> ${theReimRequest.status}</td>
    				<td> ${theReimRequest.date}</td>
    				
    				<td><a href="${approveLink}"
    				onclick="if (!(confirm('Are you sure you want to approve this request?'))) return false">Approve</a></td>
    				<td><a href="${declineLink}"
    				onclick="if (!(confirm('Are you sure you want to decline this request?'))) return false">Decline</a></td>
    				<td><a href="${decleteLink}"
    				onclick="if (!(confirm('Are you sure you want to delete this request?'))) return false">Delete</a></td>
    			</tr>
    			
    			</c:forEach>
    	
    		</table>
    	</div>
   </div>
  </body>
</html>