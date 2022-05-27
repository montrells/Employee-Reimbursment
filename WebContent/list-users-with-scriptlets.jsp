<%@ page import="java.util.*, com.montrell.*" %>
<!DOCTYPE html>
<html>

<head>
    <title>RMMS User Management</title>

    <link type="text/css" rel="stylesheet" href="css/style.css">
</head>

<%
    // get the users from the request object (sent by servlet)
    List<User> theUsers = (List<User>) request.getAttribute("USER_LIST");
%>

<body>

<div id="wrapper">
    <div id="header">
        <h2>RMMS User Management</h2>
    </div>
</div>

<div id="container">

    <div id="content">

        <table>

            <tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Username</th>
                <th>Password</th>
                <th>Email</th>
            </tr>

            <% for (User tempUser : theUsers) { %>

            <tr>
                <td> <%= tempUser.getFirst_name() %> </td>
                <td> <%= tempUser.getLast_name() %> </td>
                <td> <%= tempUser.getUsername() %> </td>
                <td> <%= tempUser.getPassword() %> </td>
                <td> <%= tempUser.getEmail() %> </td>
            </tr>

            <% } %>

        </table>

    </div>

</div>
</body>


</html>


