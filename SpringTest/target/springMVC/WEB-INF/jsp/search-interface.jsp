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
<head>
    <title>${search.name}</title>
</head>

<form:form action="/" method="get">
    <input type="submit" value = "Home">
</form:form>

<h1>${search.title}</h1>

<!-- Spring har sin egen måde at lave forms på - skal det gøres ensartet? -->
<form>
    <div class="form-SearchInput">
        <input id="searchInput" placeholder="Search.."/>
        <button id="submitSearch">Submit</button>
    </div>
    <p id="userFeedback"></p>
</form>

<form:form action="${search.buttonUrl}">
    <input type="submit" value = "${search.buttonName}">
</form:form>




</body>
</html>
