<%-- 
    Document   : teacherLogin
    Created on : Jul 13, 2022, 2:54:51 PM
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
        <link href="<c:url value="CSS/schedule.css"/>" rel="stylesheet" type="text/css">
        <!--        <link href="../CSS/bootstrap.css" rel="stylesheet" type="text/css"/>
                <link href="../CSS/bootstrap.min.css" rel="stylesheet" type="text/css"/>-->
        <!-- CSS only -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
    </head>
    <body>
        <c:if test="${sessionScope.teaid eq null}">
            <h1>Login Fail</h1>
        </c:if>
        <c:if test="${sessionScope.teaid ne null}">
            <div class="row justify-content-between">
                <div class="col-5" style="font-size: 70px">
                    🌈FPT大学🏳️‍🌈
                </div>
                <div class="col-3">
                    <div style="text-align: center;"><br/>🎶❤🏫🎶</div>
                    Hello, ${sessionScope.teaname}. 
                    <a href="index.html">Logout?</a>
                </div>
            </div>
            <div id="container">
                <!--js choose year and date here--> 
                <form action="TeacherScheduleController" id="frmSearch" method="POST">
                    <input type="hidden" name="accountID" value="${sessionScope.teaid}"><!-- send accountid to servlet -->
                    <input type="date" name="date" value="${requestScope.date}" onchange="document.getElementById('frmSearch').submit();"><!-- send date that user want to check -->
                </form>
                <!--here end-->
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th scope="col">Slot</th>
                            <th scope="col">Sunday</th>
                            <th scope="col">Monday</th>
                            <th scope="col">Tuesday</th>
                            <th scope="col">Wednesday</th>
                            <th scope="col">Thursday</th>
                            <th scope="col">Friday</th>
                            <th scope="col">Saturday</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items= "${sessionScope.slt}" var="d">
                            <tr>
                                <th scope="row" value="${d.slotid}">${d.slotid}</th>
                                    <c:forEach var="i" begin="1" end="7">
                                    <td><c:forEach items="${requestScope.grd}" var="e">
                                            <c:if test="${e.dayinweek eq i && e.group.slot.slotid eq d.slotid}">
                                                <form action="TeacherMenu" method="POST" id="sForm_${e.studentinclassid}">
                                                    <input name ="sicID" value="${e.studentinclassid}" type="hidden">
                                                    <input name ="courseID" value="${e.group.course.courseid}" type="hidden">
                                                    <input name ="groupID" value="${e.group.groupid}" type="hidden">
                                                    <input name ="Date" value="${e.date}" type="hidden">
                                                    <div onclick="document.getElementById('sForm_${e.studentinclassid}').submit();">
                                                        ${e.group.course.courseid}
                                                    </div>
                                                </form>
                                            </c:if></c:forEach></td>
                                    </c:forEach>
                            </tr>
                        </c:forEach>
                        </tr>
                    </tbody>
                </table>
            </div>
        </c:if>
    </body>
</html>

