<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@page isELIgnored="false"%>


<c:url var="addSearch" value="/ctl/invoiceDetail/search" />


<nav
		aria-label="breadcrumb" role="navigation"  >
	<ol class="breadcrumb">
		
		<li class="breadcrumb-item active" aria-current="page">Invoice Detail List</li>
	</ol>
	</nav>
	
<div class="col-md-5">
    <div class="form-area"> 
<h4>Invoice Detail List</h4>
</div>
</div>
<b><%@ include file="businessMessage.jsp"%></b>
<hr>
<sf:form action="${addSearch}" method="post" modelAttribute="form">

	<div class="container">
		<div class="row row-cols-4">
		
		<div class="col">
				<s:bind path="invoiceNo">
					<div class="input-group">
						<sf:input path="invoiceNo" type="text"
							placeholder="Invoice No" class="form-control" />
					</div>
				</s:bind>
			</div>
		
			<div class="col">
				<s:bind path="flightNo">
					<div class="input-group">
						<sf:input path="flightNo" type="text"
							placeholder="Flight No" class="form-control" />
					</div>
				</s:bind>
			</div>
			<div class="col">
			<s:bind path="userName">
					<div class="input-group">
						<sf:input path="userName" type="text"
							placeholder="User Name" class="form-control" />
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

				<input type="submit" name="operation" <c:if test="${total == pagenosize  || listsize < pageSize   }">disabled="disabled"</c:if>
								class="btn btn-primary" value="Next">
			</div>
		</div>
	</div>
</sf:form>