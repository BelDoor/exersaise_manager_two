<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>HaloColombia</title>
</head>
<body>
    I Say hello COLOMBIA!!!

    ${userName}

    <div>
        <h1>System Users</h1>
    </div>
    <div>
        <table>
            <tr>
                <td>User Id</td>
                <td>User Name</td>
                <td>User Surname</td>
                <td>Birth date</td>
                <td>Gender</td>
                <td>Height</td>
                <td>Role_id</td>
<%--                <td>Delete</td>--%>
            </tr>
            <c:forEach var="users" items="${users}">
                <tr>
                    <td>${users.id}</td>
                    <td>${users.name}</td>
                    <td>${users.surname}</td>
                    <td>${users.dateBirth}</td>
                    <td>${users.sex}</td>
                    <td>${users.height}</td>
                    <td>${users.roleId}</td>
<%--                    <td><button>Delete</button></td>--%>
                </tr>
            </c:forEach>
        </table>
    </div>

</body>
</html>