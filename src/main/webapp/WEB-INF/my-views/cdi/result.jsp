<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>完了画面</title>
    </head>
    <body>
        名前：${conversationScopeDto.name}<br>
        住所：${conversationScopeDto.address}<br>
    </body>
</html>