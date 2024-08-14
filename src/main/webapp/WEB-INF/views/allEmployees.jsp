<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Employee List</title>
</head>
<body>
<h1>Employee List</h1>

    <c:forEach var="employee" items="${employees}">
        <tr>
            <td>${employee.firstName}</td>
            <td>${employee.lastName}</td>
            <td>${employee.position}</td>
            <td>${employee.hireDate}</td>
        </tr>
    </c:forEach>

</body>
</html>
