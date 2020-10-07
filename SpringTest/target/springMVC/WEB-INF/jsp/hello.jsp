<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html charset=utf-8"%>
<link rel="stylesheet" href="../../resources/css/style.css">
<html>
    <head>

    </head>
    <body>
        <h2>${message}</h2>

        <form:form action="/nordjyske">
            <input type="submit" value = "Nordjyske">
        </form:form>

        <form:form action="/grundfoss">
            <input type="submit" value = "Grundfoss">
        </form:form>

    </body>
</html>