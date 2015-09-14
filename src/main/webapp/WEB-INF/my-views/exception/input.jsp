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
        <p>入力が0文字だとException、1文字だとMyExceptionが発生します</p>
        <form action="./result" method="get">
            名前：<input type="text" name="name"><br>
            <input type="submit" value="送信">
        </form>
    </body>
</html>
