<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

<head>
	<title>RMMS User Mangement</title>

	<link type="text/css" rel="stylesheet" href="css/style.css">
</head>

<body style="background-image: url('images/Corporate image.jpg'); background-size: cover">

<div id="wrapper">
	<div id="header">
		<h2>RMMS User Managment</h2>
	</div>
</div>

<div id="container">

	<div id="content">

		<!-- put new button: Add User -->

		<input type="button" value="Add User"
			   onclick="window.location.href='add-user-form.jsp'; return false;"
			   class="add-user-button"
		/>

		<table>

			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Username</th>
				<th>Password</th>
				<th>Email</th>
				<th>Action</th>
			</tr>

			<c:forEach var="tempUser" items="${USER_LIST}">

				<!-- set up a link for each user -->
				<c:url var="tempLink" value="/UserServlet">
					<c:param name="command" value="LOAD" />
					<c:param name="userId" value="${tempUser.id}" />
				</c:url>
				<!-- set up a link to delete each user -->
				<c:url var="deleteLink" value="/UserServlet">
					<c:param name="command" value="DELETE" />
					<c:param name="userId" value="${tempUser.id}" />
				</c:url>
				<tr>
					<td> ${tempUser.first_name} </td>
					<td> ${tempUser.last_name} </td>
					<td> ${tempUser.username} </td>
					<td> ${tempUser.password} </td>
					<td> ${tempUser.email} </td>
					<td>
						<a href="${tempLink}">Update</a>
						 |
						<a href="${deleteLink}" onclick="if (!(confirm('YOU WANT TO DELETE USER?'))) return false ">Delete</a>
					</td>
				</tr>

			</c:forEach>
			<p><a href="login.jsp" style="color:white;">Take me to LOGIN</a> </p>
		</table>

	</div>

</div>
</body>


</html>

