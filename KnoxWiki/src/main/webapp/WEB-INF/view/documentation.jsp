<%--
  Created by IntelliJ IDEA.
  User: teisv
  Date: 15-10-2020
  Time: 13:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@ include file="common/header.jspf"%>
<body>
<%@ include file="common/nav.jspf"%>
<div class="mainbody">
    <%@ include file="common/sidebar.jspf"%>
    <ul>
        <c:forEach var="listValue" items="${jcsList}">
            <li>Name: ${listValue.name}</li>
            <li>Description: ${listValue.description}</li>
            <li>Parent: ${listValue.parentClass}</li>
            <li>Methods:</li>
            <c:forEach var="iface" items="${listValue.interfaces}">
                <li>Interface: ${iface}</li>

            </c:forEach>
            <c:forEach var="methods" items="${listValue.methodList}">
                <li>Method name: ${methods.name}</li>
                <li>Method description: ${methods.description}</li>
                <li>Method usage: ${methods.example}</li>
            </c:forEach>


            <li>Properties: </li>
            <c:forEach var="properties" items="${listValue.propertyList}">
                <li>Method name: ${properties.name}</li>
                <li>Method description: ${properties.description}</li>
                <li>Method usage: ${properties.example}</li>
            </c:forEach>
            <li> -------------</li>

        </c:forEach>
    </ul>
</div>


</body>
</html>
