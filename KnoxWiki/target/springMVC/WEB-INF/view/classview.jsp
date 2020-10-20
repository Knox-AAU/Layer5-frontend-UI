<%--
  Created by IntelliJ IDEA.
  User: bjark
  Date: 13/10/2020
  Time: 14.52
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c"%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@ include file="common/header.jspf"%>
<body>
<%@ include file="common/nav.jspf"%>
<div class="mainbody">
    <%@ include file="common/sidebar.jspf"%>
    <div class="classwrapper">
        <!-- TODO Should handle package linking -->
        <div class="classPath"></div>

        <!-- General information about the class -->
        <div class="inheritance_wrapper">
            <div class="header_section">
                <h1>${theClass.name}</h1>
            </div>
            <div>
                <p class="text_fragment">Extends </p> <a class="class_link"> ${theClass.parentClass != '' ? theClass.parentClass : "NaN"} </a>
            </div>

            <div>
                <p class="text_fragment">Implements </p>
                <c:forEach items="${theClass.interfaces}" var="ainterface">
                    <a class="class_link">
                        ${ainterface}
                    </a>
                </c:forEach>
                <a class="class_link">
                    ${theClass.interfaces.size() == 0 ? "NaN" : ""}
                </a>
            </div>
        </div>
        <div class="breakline"></div>
        <div class="description_wrapper">
            <h2>Description</h2>
            <p>
                ${theClass.description}
            </p>
        </div>
        <!-- An overview of the class's methods -->
        <div id="methodwrapper"  class="class_section_wrapper">
            <h2>Method Overview</h2>
            <table class="class_table" >
                <tr>
                    <th>Method Call</th>
                    <th>Return Type</th>
                    <th>Description</th>
                </tr>
                <c:forEach items="${theClass.methodList}" var="amethod">
                    <tr>
                        <td>${amethod.name}</td>
                        <td>//TODO</td>
                        <td>${amethod.description}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <!-- An overview of the class's Properties -->
        <div id="propertywrapper"  class="class_section_wrapper">
            <h2>Property Overview</h2>
            <table  class="class_table">
                <tr>
                    <th>Property</th>
                    <th>Type</th>
                    <th>Description</th>
                </tr>
                <c:forEach items="${theClass.propertyList}" var="aproperty">
                    <tr>
                        <td>${aproperty.name}</td>
                        <td>//TODO</td>
                        <td>${aproperty.description}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>

    <div class="classlist">
        <c:forEach items="${jcsList}" var="jcs">

            <a class="class_link" href="/documentation?class=${jcs.key}"> ${jcs.value.name} </a> <br>

        </c:forEach>
    </div>
</div>
</body>
</html>
