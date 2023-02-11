<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@page isELIgnored="false"%>

<c:url var="addUrl" value="/ctl/manage" />

<c:url var="addSearch" value="/ctl/manage/search" />

<c:url var="editUrl" value="/ctl/manage?id=" />

<nav
		aria-label="breadcrumb" role="navigation"  >
	<ol class="breadcrumb">
		
		<li class="breadcrumb-item active" aria-current="page">Manage Flight List</li>
	</ol>
	</nav>
	
<div class="col-md-5">
    <div class="form-area"> 
<h4>Manage Flight List</h4>
</div>
</div>
<b><%@ include file="businessMessage.jsp"%></b>
<hr>
<sf:form action="${addSearch}" method="post" modelAttribute="form">

	<div class="container">
		<div class="row row-cols-8">
			<div class="col">
				<s:bind path="flightName">
					<div class="input-group">
						<sf:input path="flightName" type="text"
							placeholder="Flight Name " class="form-control" />
					</div>
				</s:bind>
			</div>
		
			
			<div class="col">
				<s:bind path="arrivalCity">
					<div class="input-group">
						<sf:input path="arrivalCity" type="text" placeholder="To"
							class="form-control" />
					</div>
				</s:bind>
			</div>
			
			<div class="col">
				<s:bind path="arrivalCity">
					<div class="input-group">
						<sf:input path="departureCity" type="text" placeholder="From"
							class="form-control" />
					</div>
				</s:bind>
			</div>
			
			<div class="col">
				<div class="input-group">

					<input type="submit" name="operation" class="btn btn-md btn-info"
						value="Search">&nbsp;&nbsp; <input type="submit" name="operation"
						class="btn btn-md btn-info" value="Reset">
				</div>
			</div>
		</div>
	</div>

	<br>
	
			<sf:input type="hidden" path="pageNo" />
					<sf:input type="hidden" path="pageSize" />

					<sf:input type="hidden" path="listsize" />
					<sf:input type="hidden" path="total" />
					<sf:input type="hidden" path="pagenosize" />
	
	<table 
		class="table table-striped table-bordered table-sm" 
		width="99%">
		<thead>
			<tr>
				<th class="th-sm"><input type="checkbox" id="selectall">Select All</th>
				<th class="th-sm">Arrival Airport Name</th>
				<th class="th-sm">Departure Airport Name</th>
				<th class="th-sm">Flight No</th>
				<th class="th-sm">Flight Name</th>
				<th class="th-sm">To</th>
				<th class="th-sm">From</th>
				<th class="th-sm">Arrival Date</th>
				<th class="th-sm">Departure Date</th>
				<th class="th-sm">Arrival Time</th>
				<th class="th-sm">Departure Time</th>
				<th class="th-sm">Ticket Price</th>
				<th class="th-sm">Edit</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${list}" var="mg" varStatus="cn">
			<tr>
				<td><input type="checkbox" class="case"
						name="ids" value="${mg.id}"></td>
				<td><c:out value="${mg.arrivalAirportName}"/></td>
				<td><c:out value="${mg.departureAirportName}"/></td>
				<td><c:out value="${mg.flightNo}"/></td>
				<td><c:out value="${mg.flightName}"/></td>
				<td><c:out value="${mg.arrivalCity}"/></td>
				<td><c:out value="${mg.departureCity}"/></td>
							<td><c:out value="${mg.arrivalDate}"/></td>
				<td><c:out value="${mg.departureDate}"/></td>
				<td><c:out value="${mg.arrivalTime}"/></td>
				<td><c:out value="${mg.departureTime}"/></td>
				<td><c:out value="${mg.price}"/></td>
				<td><a href="${editUrl}${mg.id}" class="btn btn-primary">Edit</a> </td>
			</tr>
	</c:forEach>

		</tbody>
	</table>
	<div style="margin: 10px" class="row row-cols-4">
		<div class="col">
			<div class="input-group">
				<input type="submit" name="operation" <c:if test="${form.pageNo == 1}">disabled="disabled"</c:if>
								class="btn btn-primary" value="Previous"
								>
			</div>
		</div>
		<div class="col">
			<div class="input-group">
        <input type="submit" name="operation" <c:if test="${listsize== 0}">disabled="disabled"</c:if>
								class="btn btn-primary" value="Delete"	>
			</div>
		</div>
		<div class="col">
			<div class="input-group">
			<input type="submit" name="operation"
								class="btn btn-primary" value="New"	>
			</div>
		</div>
		<div class="col">
			<div class="input-group">

				<input type="submit" name="operation" <c:if test="${total == pagenosize  || listsize < pageSize   }">disabled="disabled"</c:if>
								class="btn btn-primary" value="Next">
			</div>
		</div>
	</div>
</sf:form>