<!DOCTYPE html>
<html>

<head>
	<title>Add User</title>

	<link type="text/css" rel="stylesheet" href="css/style.css">
	<link type="text/css" rel="stylesheet" href="css/add-user-style.css">
</head>

<body style="background-image: url('images/Corporate image.jpg'); background-size: cover">
<div id="wrapper">
	<div id="header">
		<h2>RMMS User Management</h2>
	</div>
</div>

<div id="container" >
	<h3>Add User</h3>

	<form action="UserServlet" method="GET">

		<input type="hidden" name="command" value="ADD" />

		<table>
			<tbody>
			<tr>
				<td style="background-color: black; color:white"><label>First name:</label></td>
				<td><input type="text" name="first_name" /></td>
			</tr>

			<tr>
				<td style="background-color: black; color:white"><label>Last name:</label></td>
				<td><input type="text" name="last_name" /></td>
			</tr>

			<tr>
				<td style="background-color: black; color:white"><label style="fle">Username:</label></td>
				<td><input type="text" name="username" /></td>
			</tr>
			<tr>
				<td style="background-color: black; color:white"><label>Password:</label></td>
				<td><input type="text" name="password" /></td>
			</tr>

			<tr>
				<td style="background-color: black; color:white"><label>Email:</label></td>
				<td><input type="text" name="email" /></td>
			</tr>

			<tr>
				<td style="background-color: black; color:white"><label></label></td>
				<td><input type="submit" value="Save" class="save" /></td>
			</tr>
			<tr>
				<td style="background-color: black; color:white"><label></label></td>
				<td><p><a href="login.jsp" style="font-size: large">LOGIN</a> </p></td>
			</tr>
			<tr>
				<td style="background-color: black; color:white"><label></label></td>
				<td><p><a href="UserServlet">Back to List</a></p></td>
			</tr>

			</tbody>





		</table>

	</form>

	<div style="clear: both;"></div>


</div>
</body>

</html>

