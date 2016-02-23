<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete Student</title>
    </head>
    <body>
        <form action="<c:url value="/student/del"/>" method="POST">
            <input type="hidden" name="id" value="${student.id}"/>
            Are you shure that you want to delete this student?</br>
            NAME: ${student.name}</br>
            DATE OF BIRTH: ${student.date}</br>
            HEIGHT: ${student.height}
            <input type="submit" value="Delete"/>
        </form>
        <a href="<c:url value="/student/all"/>">Come back</a>
    </body>
</html>
