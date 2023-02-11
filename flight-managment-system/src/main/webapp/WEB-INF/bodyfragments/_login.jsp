<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<br>
 <nav
		aria-label="breadcrumb" role="navigation">
	<ol class="breadcrumb">
		
		<li class="breadcrumb-item active" aria-current="page">Login</li>
	</ol>
	</nav>
	
<div col-md-5img-thumbnail">
		<div id="feedback">
			<div class="container">
				<div class="col-md-5">
					<div class="form-area">
						<sf:form method="post"
							action="${pageContext.request.contextPath}/login" modelAttribute="form"
							>
							<h3 style="margin-bottom: 15px; text-align: left: ;">Login</h3>
								<b><%@ include file="businessMessage.jsp"%></b>
							<div class="form-group">
								<s:bind path="login">
									<label>Login Id:</label>
									<sf:input path="${status.expression}" placeholder="Enter Login"
										class="form-control" />
									<font color="red" style="font-size: 13px"><sf:errors
											path="${status.expression}" /></font>
								</s:bind>
							</div>
							<div class="form-group">
								<s:bind path="password">
									<label for="pwd">Password:</label>
									<sf:input type="password" path="${status.expression}"
									placeholder="Enter Password" class="form-control" />
									<font color="red" style="font-size: 13px"><sf:errors path="${status.expression}"/></font>
								</s:bind>
							</div>
							<input type="submit" name="operation" class="btn btn-primary pull-right"
								value="SignIn"> or
								<input type="submit" name="operation" class="btn btn-primary pull-right"
								value="SignUp"> 
							<a href="${pageContext.request.contextPath}/forgetPassword">Forget Password ?</a>
						</sf:form>
					</div>
				</div>
			</div>
		</div>
		<!--feedback-->
		<br>
		