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
<head>
    <title>Title</title>
</head>
<body>

<div class="articleWrapper">
    <div class="article">
        <h1>${article.title}</h1>
        <h2>${article.subtitle}</h2>
        <p>${article.author}</p>
        <p>${article.date}</p>
        <p>${article.articleText}</p>
    </div>
</div>

<div class="backbtn">

    <form:form action="/nordjyske">
        <input type="image" src="../../../resources/icons/arrow-left-solid.svg" name="submit" value="submit">
    </form:form>

</div>

<div class="NJSidebar">

    <div class="relatedSidebar">
        <h2>Related articles: </h2>

        <c:forEach items="${article.relatedArticles}" var="relatedArtId">
            <a href ="/nordjyske/search?article=${relatedArtId}" class="searchResultLinks">
            <div class="relatedArtItem">
                <h3>${ddHash.get(relatedArtId).title}</h3>
                <p>${ddHash.get(relatedArtId).subtitle}</p>
            </div>

            </a>

        </c:forEach>

    </div>



    <div class="authorSidebar">
        <h2>Author: </h2>
        <p>${article.author}</p>
    </div>
    <div class="keywords">
            <h2>Keyword: </h2>
            <c:forEach items="${article.keywords}" var="keyword">
                <p>${keyword}</p>
            </c:forEach>
        </div>
</div>

</body>
</html>
