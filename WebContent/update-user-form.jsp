<!DOCTYPE html>
<html>

<head>
	<title>Update User</title>

	<link type="text/css" rel="stylesheet" href="css/style.css">
	<link type="text/css" rel="stylesheet" href="css/add-user-style.css">
</head>

<body style="background-image: url('images/Corporate image.jpg'); background-size: cover">
	<div id="wrapper">
		<div id="header">
			<h2>RMMS Update User</h2>
		</div>
	</div>
	
	<div id="container">
		<h3 style="color:white;">Update User</h3>
		
		<form action="UserServlet" method="GET">
		
			<input type="hidden" name="command" value="UPDATE" />

			<input type="hidden" name="userId" value="${THE_USER.id}" />
			
			<table>
				<tbody>
					<tr>
						<td style="background-color: black; color:white"><label>First name:</label></td>
						<td><input type="text" name="first_name"
								   value="${THE_USER.first_name}" /></td>
					</tr>

					<tr>
						<td style="background-color: black; color:white"><label>Last name:</label></td>
						<td><input type="text" name="last_name"
								   value="${THE_USER.last_name}" /></td>
					</tr>
					<tr>
						<td style="background-color: black; color:white"><label>Username:</label></td>
						<td><input type="text" name="username"
								   value="${THE_USER.username}" /></td>
					</tr>
					<tr>
						<td style="background-color: black; color:white"><label>Password:</label></td>
						<td><input type="text" name="password"
								   value="${THE_USER.password}" /></td>
					</tr>

					<tr>
						<td style="background-color: black; color:white"><label>Email:</label></td>
						<td><input type="email" name="email"
								   value="${THE_USER.email}" /></td>
					</tr>
					
					<tr >
						<td style="background-color: black; color:white"><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>
					
				</tbody>
			</table>
		</form>
		
		<div style="clear: both;"></div>
		
		<p>
			<a href="UserServlet">Back to List</a>
		</p>
	</div>
</body>

</html>











