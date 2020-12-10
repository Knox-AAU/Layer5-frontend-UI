<%--
  Created by IntelliJ IDEA.
  User: bjark
  Date: 03/12/2020
  Time: 10.17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<%@ include file="common/html_head.jspf"%>
<body>
<%@ include file="common/header.jspf"%>
<div class="hubcontent_wrapper">
    <div class="hubcontent">
        <!-- Generate the Database Icons -->
        <c:forEach items="${HubIcons}" var="hubicon">
            <a class="button_link hubicon" href="${hubicon.link}">
                <spring:url value="${hubicon.imagePath}" var="imagePath" />
                <img src="${imagePath}">
                <div>
                    <p>${hubicon.title} </p>
                </div>
            </a>
        </c:forEach>
    </div>
</div>
</body>
</html>
