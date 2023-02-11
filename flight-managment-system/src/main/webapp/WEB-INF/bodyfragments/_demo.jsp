<%@page import="in.co.airline.ticket.airlineticket.util.DataUtility"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>

<nav aria-label="breadcrumb" role="navigation">
	<ol class="breadcrumb">

		<li class="breadcrumb-item active" aria-current="page">Demo</li>
	</ol>
</nav>

<divcol-md-5img-thumbnail">
<div id="feedback">
	<div class="container">
		<div class="col-md-5">
			<div class="form-area">
				<sf:form method="post"
					action="${pageContext.request.contextPath}/ctl/demo"
					modelAttribute="form">
					<br style="clear: both">
					<h3 style="margin-bottom: 15px; text-align: left:;">Demo</h3>
					<b><%@ include file="businessMessage.jsp"%></b>

		
				<% int nop=(int)request.getAttribute("nop");%>
				
				<% for(int i=1;i<=nop; i++){ %>
				<div class="form-row">
    							<div class="form-group col-md-4">
									<label >Name:</label>
									<input  name="name"
									placeholder="Enter Name" class="form-control" />
							</div>
							<div class="form-group col-md-4">
									<label >Gender:</label>
									<input  name="gender"
									placeholder="Enter Gender" class="form-control" />
							</div>
							
							<div class="form-group col-md-4">
									<label >Dob:</label>
									<input  name="dob"
									placeholder="Enter dob" class="form-control" />
							</div>
							
							</div>
				
				<%} %>

					<input type="submit" name="operation"
						class="btn btn-primary pull-right" value="Save">or<input
						type="submit" name="operation" class="btn btn-primary pull-right"
						value="Reset">
				</sf:form>
			</div>
		</div>
	</div>
</div>
<!--feedback--> <br>