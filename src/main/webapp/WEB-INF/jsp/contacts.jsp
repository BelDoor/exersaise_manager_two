<%--
  Created by IntelliJ IDEA.
  User: bulba
  Date: 12.04.2023
  Time: 15:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Contact User</title>
</head>
<body>
I Say hello COLOMBIA!!!

<div>
    <h1>Contact</h1>
</div>
<div>
    <table>
        <tr>
            <td>Id</td>
            <td>User id</td>
            <td>Phone Number</td>
            <td>Email</td>
            <td>City</td>
            <td>Street</td>
            <td>House Number</td>
            <td>Flat</td>
            <td>Created</td>
        </tr>
        <c:forEach var="contact" items="${contact}">
            <tr>
                <td>${contact.id}</td>
                <td>${contact.userId}</td>
                <td>${contact.phoneNumber}</td>
                <td>${contact.email}</td>
                <td>${contact.city}</td>
                <td>${contact.street}</td>
                <td>${contact.houseNumber}</td>
                <td>${contact.flat}</td>
                <td>${contact.created}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
