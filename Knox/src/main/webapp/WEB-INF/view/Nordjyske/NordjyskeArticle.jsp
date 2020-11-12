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
<%@ include file="../common/html_head.jspf"%>
<body>
<%@ include file="../common/header.jspf"%>

<div id="articleWrapper">
    <div id="article">
        <h1>${article.title}</h1>
        <h2>${article.subtitle}</h2>
        <p>${article.author}</p>
        <p>${article.date}</p>
        <p>${article.articleText}</p>
    </div>
</div>

<div id="sidebar" class="nordjyske">

    <div id="relatedSidebar"  class="sidebar_component">
        <h2>Related articles: </h2>

        <c:forEach items="${article.relatedArticles}" var="relatedArtId">
            <a href ="/knox/nordjyske/search?article=${relatedArtId}" class="button_link relatedArtItem">
            <div>
                <h3>${ddHash.get(relatedArtId).title}</h3>
                <p>${ddHash.get(relatedArtId).subtitle}</p>
            </div>

            </a>

        </c:forEach>

    </div>



    <div id="authorSidebar"  class="sidebar_component">
        <h2>Author: </h2>
        <p>${article.author}</p>
    </div>
    <div class="keywords sidebar_component">
            <h2>Keyword: </h2>
            <c:forEach items="${article.keywords}" var="keyword">
                <p>${keyword}</p>
            </c:forEach>
        </div>
</div>

</body>
</html>
