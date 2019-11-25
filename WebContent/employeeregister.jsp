<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="ISO-8859-1">
        <title>Employee Register Form</title>
    </head>

    <body>
        <h1>Employee Register Form</h1>
       <p> ${message}</p>
        <form action="employeeServlet" method="post"> <!-- "employeedetail.jsp" -->
            <table style="with: 50%">
                <tr>
                    <td>First Name</td>
                    <td><input type="text" name="firstName" value="${param.firstName}"/></td>
                </tr>
                <tr>
                    <td>Last Name</td>
                    <td><input type="text" name="lastName" value="${param.lastName}"/></td>
                </tr>
                <tr>
                    <td>UserName</td>
                    <td><input type="text" name="username" value="${param.username}"/></td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td><input type="password" name="password" /></td>
                </tr>
                <tr>
                    <td>Address</td>
                    <td><input type="text" name="address" value="${param.address}"/></td>
                </tr>
                <tr>
                    <td>Contact No</td>
                    <td><input type="text" name="contact" value="${param.contact}"/></td>
                </tr>
            </table>
            <input type="submit" value="Submit" /></form>
    </body>

    </html>