<%@page import="Com.entity.Student"%>
<%@page import="Com.dao.StudentDAO"%>
<%@page import="Com.connection.DBconnect"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>

<%-- <%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%@include file="AllCSS_JS.jsp"%>

</head>
<body class="bg-light">


	<%@include file="navbar.jsp"%>


	<div class="container p-3">

		<div class="card">
			<div class="card-body">


				<p class="text-center  fs-1">
					<u> All Students Details </u>
				</p>


				<c:if test="${not empty succMsg}">
					<p class="text-center text-sucess">${succMsg}</p>
					<c:remove var="succMsg" />

				</c:if>


				<c:if test="${not empty errorMsg }">
					<p class="text-center text-sucess">${errorMsg}</p>
					<c:remove var="errorMsg" />

				</c:if>

				<table class="table">
					<thead>
						<tr>
							<th scope="col">Full Name</th>
							<th scope="col">Date Of Birth</th>
							<th scope="col">Address</th>
							<th scope="col">Email</th>
							<th scope="col">Action</th>
						</tr>
					</thead>
					<tbody>

						<%
						StudentDAO dao = new StudentDAO(DBconnect.getConn());

						List<Student> list = dao.getAllStudent();

						for (Student s : list) {
						%>

						<tr>
							<th scope="row"><%=s.getFullName()%></th>
							<td><%=s.getDob()%></td>
							<td><%=s.getAddress()%></td>
							<td><%=s.getEmail()%></td>
							<td><a href="edit_student.jsp? id = <%=s.getId()%>"
								class="btn  btn-sm btn-primary">Edit</a> 
								
								
								<a href="delete? id =  <%=s.getId()%>"
								 class="btn  btn-sm btn-danger sm-1">Delete</a>

							</td>
						</tr>


						<%
						}
						%>

					</tbody>
				</table>
			</div>

		</div>
	</div>

</body>
</html>