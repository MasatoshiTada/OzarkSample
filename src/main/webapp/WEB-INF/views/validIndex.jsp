<%-- 
    Document   : validIndex
    Created on : 2015/04/02, 10:43:18
    Author     : User
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>入力画面</title>
    </head>
    <body>
        <c:if test="${not empty message}">
            <c:out value="${message}"/>
        </c:if>
        <c:if test="${not empty errors}">
            <c:forEach items="${errors}" var="error">
                <c:out value="${error.message}"/>
            </c:forEach>
        </c:if>
        <form action="./result" method="post">
            名前：<input type="text" name="name"><br>
            年齢：<input type="text" name="age"><br>
            <input type="submit" value="送信">
        </form>
    </body>
</html>
