<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
 <nav
		aria-label="breadcrumb" role="navigation"  >
	<ol class="breadcrumb">
		
		<li class="breadcrumb-item active" aria-current="page">AirPort</li>
	</ol>
	</nav>

<div col-md-5 img-thumbnail">
           <div id="feedback"> <div class="container">
<div class="col-md-5">
    <div class="form-area">  
       <sf:form method="post" action="${pageContext.request.contextPath}/ctl/airport"  modelAttribute="form">
        <br style="clear:both">
                    <h3 style="margin-bottom: 15px; text-align: left: ;">Add Airport</h3>
                    <b><%@ include file="businessMessage.jsp"%></b>
                	
                		<sf:hidden  path="id"/>
                	
                	<%-- <div class="form-group">
								<s:bind path="id">
								<label >Id:</label> 
								<sf:input path="${status.expression}" placeholder="Enter Id" class="form-control" />
									
							</s:bind>
							</div> --%>
                	
							<div class="form-group">
								<s:bind path="code">
								<label >Airport Code:</label> 
								<sf:input path="${status.expression}" placeholder="Enter Airport Code" class="form-control" />
									<font color="red" style="font-size: 13px"><sf:errors
											path="${status.expression}" /></font>
							</s:bind>
							</div>
							
							<div class="form-group">
								<s:bind path="name">
								<label >Name:</label> 
								<sf:input path="${status.expression}" placeholder="Enter Name" class="form-control" />
									<font color="red" style="font-size: 13px"><sf:errors
											path="${status.expression}" /></font>
							</s:bind>
							</div>
							
							<div class="form-row">
    							<div class="form-group col-md-4">
								<s:bind path="country">
									<label >Country:</label>
									<sf:input  path="${status.expression}"
									placeholder="Enter Country" class="form-control" />
									<font color="red" style="font-size: 13px"><sf:errors path="${status.expression}"/></font>
								</s:bind>
							</div>
							<div class="form-group col-md-4">
								<s:bind path="state">
									<label >State:</label>
									<sf:input  path="${status.expression}"
									placeholder="Enter State" class="form-control" />
									<font color="red" style="font-size: 13px"><sf:errors path="${status.expression}"/></font>
								</s:bind>
							</div>
							<div class="form-group col-md-4">
								<s:bind path="city">
									<label >City:</label>
									<sf:input  path="${status.expression}"
									placeholder="Enter City" class="form-control" />
									<font color="red" style="font-size: 13px"><sf:errors path="${status.expression}"/></font>
								</s:bind>
							</div>
							</div>
							
							
							<div class="form-group">
								<s:bind path="address">
								<label >Address:</label> 
								<sf:textarea rows="4" cols="4" path="${status.expression}" placeholder="Enter Address" class="form-control" />
									<font color="red" style="font-size: 13px"><sf:errors
											path="${status.expression}" /></font>
							</s:bind>
							</div>
							
							
        					 <input type="submit" name="operation"
								class="btn btn-primary pull-right" value="Save">or<input type="submit" name="operation"
								class="btn btn-primary pull-right" value="Reset">
        </sf:form>
    </div>
</div>
</div> </div> <!--feedback-->
<br>

	