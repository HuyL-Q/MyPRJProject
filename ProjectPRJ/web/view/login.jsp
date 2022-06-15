<%-- 
    Document   : login
    Created on : Jun 11, 2022, 4:13:07 PM
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
        <c:if test="${requestScope.ac eq null}">
            <h1>Login Fail</h1>
        </c:if>
        <c:if test="${requestScope.ac ne null}">
            <div id="headers">
                <div class="col-md-6 offset-md-9">
                    Hello, ${requestScope.ac.account}
                    <a href="index.html">Logout?</a>
                </div>
            </div>
            <div id="container">
                <!--js choose year and date here--> 
                
                <!--here end-->
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th scope="col">Slot</th>
                            <th scope="col">Monday</th>
                            <th scope="col">Tuesday</th>
                            <th scope="col">Wednesday</th>
                            <th scope="col">Thursday</th>
                            <th scope="col">Friday</th>
                            <th scope="col">Saturday</th>
                            <th scope="col">Sunday</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <th scope="row">1</th>
                            <td>Mark</td>
                            <td>Otto</td>
                            <td>@mdo</td>
                        </tr>
                        <tr>
                            <th scope="row">2</th>
                            <td>Jacob</td>
                            <td>Thornton</td>
                            <td>@fat</td>
                        </tr>
                        <tr>
                            <th scope="row">3</th>
                            <td>Larry</td>
                            <td>the Bird</td>
                            <td>@twitter</td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </c:if>
    </body>
</html>
