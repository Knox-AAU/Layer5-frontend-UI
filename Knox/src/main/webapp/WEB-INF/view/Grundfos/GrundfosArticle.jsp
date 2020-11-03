<%--
  Created by IntelliJ IDEA.
  User: teisv
  Date: 29-10-2020
  Time: 10:36
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@ include file="../common/header.jspf"%>
<link rel="stylesheet" href="../../resources/style/grundfos.css">

<head>
    <spring:url value="/resources/style/grundfos.css" var="style" />
</head>
<body>

<div id="articleWrapper">
    <div id="article">
        <h1>${article.title}</h1>
        <h2>${article.subtitle}</h2>
        <p>${article.author}</p>
        <p>${article.date}</p>
        <p>${article.articleText}</p>
    </div>
</div>

<div id="backbtn">

    <form:form action="/grundfos">
        <input type="image" src="../../../resources/icons/arrow-left-solid.svg" name="submit" value="submit">
    </form:form>

</div>

<div id="sidebar" class="grundfos">

    <div id="relatedSidebar">
        <h2>Related articles: </h2>

        <c:forEach items="${article.relatedArticles}" var="relatedArtId">
            <a href ="/grundfos/search?article=${relatedArtId}" id="searchResultLinks">
            <div id="relatedArtItem">
                <h3>${ddHash.get(relatedArtId).title}</h3>
                <p>${ddHash.get(relatedArtId).subtitle}</p>
            </div>

            </a>

        </c:forEach>

    </div>


    <!--AUTHOR SKAL MÅSKE SLETTES?-->
    <div id="authorSidebar">
        <h2>Author: </h2>
        <p>${article.author}</p>
    </div>

    <div id="authorSidebar">
        <h2>Model: </h2>
        <p>${"234DFGDFG"}</p>
    </div>

    <div id="keywords">
            <h2>Keyword: </h2>
            <c:forEach items="${article.keywords}" var="keyword">
                <p>${keyword}</p>
            </c:forEach>
        </div>
</div>

</body>
</html>
