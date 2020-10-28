<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html charset=utf-8"%>
    <html>
        <%@ include file="common/header.jspf"%>
        <body>
            <h2>${message}</h2>

            <form:form action="nordjyske">
                <input type="submit" value = "Nordjyske">
            </form:form>
            <form:form action="grundfos">
                <input type="submit" value = "Grundfos">
            </form:form>

        </body>
    </html>