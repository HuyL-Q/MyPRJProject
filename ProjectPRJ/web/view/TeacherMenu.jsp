<%-- 
    Document   : TeacherMenu
    Created on : Jul 15, 2022, 3:37:26 PM
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
        Course: ${sessionScope.courseID}<br/>
        Teacher name: ${sessionScope.teaname}<br/>
        GroupID: ${sessionScope.groupID}<br/>
        <form action="AttendanceChecking" method="POST">  
            <button type="submit">Attendance</button>
        </form><br/>
        <form action="StudentGrade" method="POST">
            <button type="submit">Student grade</button>
        </form>
    </body>
</html>
