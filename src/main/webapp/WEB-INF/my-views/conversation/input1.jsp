<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>入力画面</title>
        <link rel="stylesheet" href="${mvc.contextPath}/css/style.css">
    </head>
    <body>
        <form action="./input2" method="get">
            名前：<input type="text" name="name"><br>
            <input type="submit" value="送信">
        </form>
    </body>
</html>
