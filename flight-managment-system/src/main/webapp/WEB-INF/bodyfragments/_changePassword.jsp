<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<br>
 <nav
		aria-label="breadcrumb" role="navigation">
	<ol class="breadcrumb">
		
		<li class="breadcrumb-item active" aria-current="page">Change Password</li>
	</ol>
	</nav>

<div col-md-5 img-thumbnail">
           <div id="feedback"> <div class="container">
<div class="col-md-5">
    <div class="form-area">  
       <sf:form method="post" action="${pageContext.request.contextPath}/changepassword"  modelAttribute="form">
		   
        <br style="clear:both">
                    <h3 style="margin-bottom: 15px; text-align: left: ;">Change Password</h3>
                		  <b><%@ include file="businessMessage.jsp"%></b>
							<div class="form-group">
								<s:bind path="oldPassword">
									<label for="pwd">Old Password:</label>
									<sf:input type="password" path="${status.expression}"
									placeholder="Enter Old Password" class="form-control" />
									<font color="red" style="font-size: 13px"><sf:errors path="${status.expression}"/></font>
								</s:bind>
							</div>
							<div class="form-row">
    							<div class="form-group col-md-6">
								<s:bind path="newPassword">
									<label for="pwd">Password:</label>
									<sf:input type="password" path="${status.expression}"
									placeholder="Enter New Password" class="form-control" />
									<font color="red" style="font-size: 13px"><sf:errors path="${status.expression}"/></font>
								</s:bind>
							</div>
							
							<div class="form-group col-md-6">
								<s:bind path="confirmPassword">
									<label for="pwd">Confirm Password:</label>
									<sf:input type="password" path="${status.expression}"
									placeholder="Enter Confirm Password" class="form-control" />
									<font color="red" style="font-size: 13px"><sf:errors path="${status.expression}"/></font>
								</s:bind>
							</div>
							</div>
							

            
        					<input type="submit" name="operation"
								class="btn btn-primary pull-right" value="Save">
								
        </sf:form>
    </div>
</div>
</div> </div> <!--feedback-->
<br>
		