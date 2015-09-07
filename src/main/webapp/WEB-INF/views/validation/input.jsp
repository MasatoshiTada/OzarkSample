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
        <div class="error">
            <c:if test="${not empty bindingResult}">
                <h1>検証エラーですよ！</h1>
                <c:forEach items="${bindingResult.allMessages}" var="message">
                    <c:out value="${message}"/><br>
                </c:forEach>
            </c:if>
        </div>
        <form action="./result" method="post">
            名前：<input type="text" name="name"><br>
            年齢：<input type="text" name="age"><br>
            <input type="submit" value="送信">
        </form>
    </body>
</html>
