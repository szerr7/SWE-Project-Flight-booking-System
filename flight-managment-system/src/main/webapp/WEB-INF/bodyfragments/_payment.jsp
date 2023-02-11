<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<nav aria-label="breadcrumb" role="navigation">
	<ol class="breadcrumb">
		<li class="breadcrumb-item active" aria-current="page">Payment</li>
	</ol>
</nav>

<div col-md-5img-thumbnail">
	<div id="feedback">
		<div class="container">
			<div class="col-md-5">
				<div class="form-area">
					<sf:form method="post"
						action="${pageContext.request.contextPath}/ctl/payment"
						modelAttribute="form">
						<br style="clear: both">
						<h3 style="margin-bottom: 15px; text-align: left:;">Payment</h3>
						<b><%@ include file="businessMessage.jsp"%></b>
						<sf:hidden path="id" />
						<div class="form-group">
							<label>Card No:</label> <input name=""
								placeholder="Enter Card No" class="form-control" />
						</div>
						<div class="form-group">
							<label>Card Holder Name:</label> <input name=""
								placeholder="Enter Card Holder Name" class="form-control" />
						</div>

						<div class="form-row">
							<div class="form-group col-md-6">
								<label>Month:</label> <input name="name"
									placeholder="Enter Month" class="form-control" />
							</div>
							<div class="form-group col-md-6">
								<label>Year:</label> <input name="gender"
									placeholder="Enter Year" class="form-control" />
							</div>
						</div>
						<div class="form-group">
							<label>CVV:</label> <input name=""
								placeholder="Enter CVV." class="form-control" />
						</div>


						<input type="submit" name="operation"
							class="btn btn-primary pull-right" value="Confirm Payment">or<input
							type="submit" name="operation" class="btn btn-primary pull-right"
							value="Reset">
					</sf:form>
				</div>
			</div>
		</div>
	</div>
	<!--feedback-->
	<br>