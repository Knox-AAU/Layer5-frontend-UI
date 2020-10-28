<%--
  Created by IntelliJ IDEA.
  User: Marti
  Date: 10/6/2020
  Time: 1:24 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>

<%@ include file="common/header.jspf"%>

<form:form action="/knox" method="get">
    <input type="submit" value = "Home">
</form:form>

<h1>${search.pageTitle}</h1>

<!-- Spring har sin egen måde at lave forms på - skal det gøres ensartet? -->
<form:form>
    <div class="form-SearchInput">
        <input id="searchInput" class="SearchBar" placeholder="Search.."/>
        <button id="submitSearch" type="button">Submit</button>
    </div>
    <p id="userFeedback"></p>
</form:form>

<form:form action="${search.buttonUrl}">
    <input type="submit" value = "${search.buttonName}">
</form:form>




</body>
<spring:url value="/resources/javascript/convert-to-html-nordjysk.js" var="converter" />
<script src="${converter}"></script>
</html>
