<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List of Students</title>
    </head>
    <body>
        <table>
            <tr>
                <th>Name</th>
                <th>Date of Birth</th>
                <th>Height</th>
                <th colspan="3">Actions</th>
            </tr>
            <c:forEach var="student" items="${students}">
                <tr>
                    <td>${student.name}</td>
                    <td>${student.date}</td>
                    <td>${student.height}</td>
                    <td><a href="<c:url value="/student/about/${student.id}"/>">About</a></td>
                    <td><a href="<c:url value="/student/up/${student.id}"/>">Update</a></td>
                    <td><a href="<c:url value="/student/del/${student.id}"/>">Delete</a></td>
                </tr>
            </c:forEach>
        </table>
        <td><a href="<c:url value="/student/add"/>">Create new student</a></td>
    </body>
</html>
