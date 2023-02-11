<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@page isELIgnored="false"%>

<c:url var="addUrl" value="/ctl/success" />

<c:url var="addSearch" value="/ctl/success" />


<h4>Invoice Detail</h4>
<b><%@ include file="businessMessage.jsp"%></b>
<hr>
<sf:form action="${addSearch}" method="post" modelAttribute="form">


	<br>
	
	
	<table 
		class="table table-striped table-bordered table-sm" 
		width="99%">
		<thead>
			<tr>
			<th class="th-sm">Invoice No.</th>
				<th class="th-sm">Flight No</th>
				<th class="th-sm">Flight Name</th>
				<th class="th-sm">Name</th>
				<th class="th-sm">Gender</th>
				<th class="th-sm">Dob</th>
				<th class="th-sm">To</th>
				<th class="th-sm">From</th>
				<th class="th-sm">Date</th>
				<th class="th-sm">Price</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${list}" var="sc" varStatus="fl">
			<tr>
				
				<td><c:out value="${sc.invoiceNo}"/></td>
				<td><c:out value="${sc.flightNo}"/></td>
				<td><c:out value="${sc.flightName}"/></td>
				<td><c:out value="${sc.name}"/></td>
				<td><c:out value="${sc.gender}"/></td>
				<td><c:out value="${sc.dob}"/></td>
				<td><c:out value="${sc.arrivalCity}"/></td>
				<td><c:out value="${sc.departureCity}"/></td>
				<td><c:out value="${sc.date}"/></td>
				<td><c:out value="${sc.price}"/></td>
			</tr>
	</c:forEach>

		</tbody>
	</table>
	
</sf:form>