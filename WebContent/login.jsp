<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>RMMS Login</title>
   <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
    rel="stylesheet">
    <!--link rel="stylesheet" href="css/add-user-style.css"-->
</head>
<body style="background-image: url('images/Corporate image.jpg'); background-size: cover">
<div align="center">
    <h1>User Login</h1>
    <form action="<%=request.getContextPath()%>/login" method="post" >
        <table style="with: 100%; background-color: black; color: white" >
            <tr>
                <td>UserName</td>
                <td><input type="text" name="username" /></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><input type="password" name="password" /></td>
            </tr>

        </table>
        <input type="submit" value="Submit" />
        <p><a href="add-user-form.jsp">I am not Registered</a></p>
    </form>
</div>
</body>
</html>