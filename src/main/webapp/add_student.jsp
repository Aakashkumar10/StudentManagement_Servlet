<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%@include file="AllCSS_JS.jsp"%>

</head>
<body class="bg-light">

	<%@include file="navbar.jsp"%>

	<div class="container p-4">
		<div class="row">
			<div class="col-md-6 offset-md-3">
				<div class="card">
					<div class="card-body p-4">

						<p class="fs-3  text-center">Add Student</p>

						<c:if test="${not empty succMsg}">
							<p class="text-center text-sucess">${succMsg}</p>
							<c:remove var="succMsg" />

						</c:if>


						<c:if test="${not empty errorMsg }">
							<p class="text-center text-sucess">${errorMsg}</p>
							<c:remove var="errorMsg" />

						</c:if>


						<form action="register" method="post">


							<div class="mb-3">
								<label class="form-label">Full Name</label> <input type="text"
									name="name" class="form-control">
							</div>

							<div class="mb-3">
								<label class="form-label">Date Of Birth</label> <input
									type="date" name="dob" class="form-control">
							</div>

							<div class="mb-3">
								<label class="form-label">Address</label> <input type="text"
									name="address" class="form-control">
							</div>

							<div class="mb-3">
								<label class="form-label">Email address</label> <input
									name="email" type="email" class="form-control">
							</div>





							<button type="submit" class="btn btn-primary col-md-12">Submit</button>
						</form>

					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>