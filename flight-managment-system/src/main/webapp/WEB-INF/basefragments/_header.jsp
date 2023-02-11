<%@page import="in.co.airline.ticket.airlineticket.dto.UserDTO"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<nav class="navbar navbar-expand-lg navbar-light bg-light" style="padding: 15px">
	<b>AirLine Ticket Booking System</b>
</nav>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">

	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarNav" aria-controls="navbarNav"
		aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="navbarNav">
		<ul class="navbar-nav">

			<li class="nav-item active"><a class="nav-link"
				href="<c:url value="/welcome"/>">Home <span class="sr-only">(current)</span></a>
			</li>

			<%
				UserDTO userBean = (UserDTO) session.getAttribute("user");
				boolean userLoggedIn = userBean != null;
			%>
			<%
				if (userLoggedIn) {
			%>

			<%
				if (userBean.getRoleId() == 1) {
			%>
			<li class="nav-item "><a class="nav-link"
				href="<c:url value="/ctl/airport"/>">Add Airport</a></li>

			<li class="nav-item "><a class="nav-link"
				href="<c:url value="/ctl/airport/search"/>">Airport List</a></li>

			<li class="nav-item "><a class="nav-link"
				href="<c:url value="/ctl/flight"/>">Add Flight</a></li>

			<li class="nav-item "><a class="nav-link"
				href="<c:url value="/ctl/flight/search"/>">Flight List</a></li>

			<li class="nav-item "><a class="nav-link"
				href="<c:url value="/ctl/manage"/>">Manage Flight</a></li>

			<li class="nav-item "><a class="nav-link"
				href="<c:url value="/ctl/manage/search"/>">Manage Flight List</a></li>
				
					<li class="nav-item "><a class="nav-link"
				href="<c:url value="/ctl/invoice/search"/>">Invoice</a></li>
				
				<li class="nav-item "><a class="nav-link"
				href="<c:url value="/ctl/invoiceDetail/search"/>">Invoice Detail</a></li>
			<%
				} else if (userBean.getRoleId() == 2) {
			%>
			<li class="nav-item "><a class="nav-link"
				href="<c:url value="/home"/>">Search Flight</a></li>
				<li class="nav-item "><a class="nav-link"
				href="<c:url value="/ctl/invoice/search"/>">Invoice</a></li>
				
				<li class="nav-item "><a class="nav-link"
				href="<c:url value="/ctl/invoiceDetail/search"/>">Invoice Detail</a></li>
			<%
				}
			%>
			<li class="nav-item "><a class="nav-link"
				href="<c:url value="/profile"/>">My Profile</a></li>
			<li class="nav-item "><a class="nav-link"
				href="<c:url value="/changepassword"/>">Change Password</a></li>
			<%
				}else {
			%>
			<%} %>
		</ul>


	</div>


	<ul class="nav justify-content-end">


		<%
			if (userLoggedIn) {
		%>
		<li class="nav-item"><a class="nav-link"
			href="<c:url value="/login"/>">Logout</a></li>
		<%
			} else {
		%>
		<li class="nav-item"><a class="nav-link"
			href="<c:url value="/login"/>">Sign In</a></li>
		<li class="nav-item "><a class="nav-link"
			href="<c:url value="/signUp"/>">Sign Up</a></li>	
		<%
			}
		%>

	</ul>

</nav>

