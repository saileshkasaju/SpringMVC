<%-- 
    Document   : index
    Created on : Apr 1, 2017, 12:17:33 PM
    Author     : Edge
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World From ${name} Framework!</h1>
        
        <h2>Courses</h2>
        <ul>            
            <c:forEach var="c" items="${courses}">
                <li>${c.name} (${c.code})</li>
            </c:forEach>
        </ul>
    </body>
</html>
