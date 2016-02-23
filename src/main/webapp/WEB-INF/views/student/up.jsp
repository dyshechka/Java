<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Student</title>
    </head>
    <body>
        <form action="<c:url value="/student/up"/>" method="POST">
            <input type="hidden" name="id" value="${student.id}"/>
            <table>
                <tr>
                    <td><label for="name">Name</label></td>
                    <td><input id="name" name="name" type="text" value="${student.name}"/></td>
                </tr>
                <tr>
                    <td><label for="date">Date Of Birth</label></td>
                    <td><input id="date" name="date" type="text" value="${student.date}"/></td>
                </tr>
                <tr>
                    <td><label for="height">Height</label></td>
                    <td><input id="height" name="height" type="text" value="${student.height}"/></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" value="Update"/></td>
                </tr>
            </table>
        </form>
        <a href="<c:url value="/student/all"/>">Come back</a>
    </body>
</html>
