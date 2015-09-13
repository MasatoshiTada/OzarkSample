<%-- 
    Document   : validResult
    Created on : 2015/04/02, 10:49:35
    Author     : User
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>完了画面</title>
    </head>
    <body>
        検証OKです。<br>
        名前：<c:out value="${name}"/><br>
        年齢：<c:out value="${age}"/><br>
    </body>
</html>
