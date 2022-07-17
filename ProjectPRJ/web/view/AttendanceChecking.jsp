<%-- 
    Document   : AttendanceChecking
    Created on : Jul 15, 2022, 5:21:27 PM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="SaveData" method="POST">
            <table>
                <tr>
                    <th>StudentID</th>
                    <th>Student Name</th>
                    <th>Attend</th>
                </tr>
                <c:forEach items="${sessionScope.gr.studentar}" var="e">
                <tr>
                    <td>${e.student.studentid}</td>
                    <td>${e.student.studentname}</td>
                    <td>
                        <input type="hidden" value="${e.studentinclassid}" name="SICID">
                        <input type="radio" value="Attend" name="${e.studentinclassid}status">Attend
                        <input type="radio" value="Absent" name="${e.studentinclassid}status">Absent 
                        <input type="text" name="${e.studentinclassid}Note"> Note
                    </td>
                </tr>
                </c:forEach>
            </table>
            <button type="submit">Save</button>
        </form>
    </body>
</html>
