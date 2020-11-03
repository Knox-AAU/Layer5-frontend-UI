<%--
  Created by IntelliJ IDEA.
  User: teisv
  Date: 27-10-2020
  Time: 11:54
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@ include file="../common/header.jspf"%>
<head>
    <title>Nordjyske Page!</title>
</head>
<body>

<div class="NJSearchbar">
    <form:form action="/nordjyske">
        <input type="text" name="searched" placeholder="Search..." >
        <input type="image" src="../../../resources/icons/search-solid.svg" name="submit" value="submit">

    </form:form>

</div>


<div class="NJSidebar">

    <div class="NJSortBy">
        <h2 id="sort_by"> Sort by</h2>
        <div class="checkbox">
            <ul class="nobullets">
                <li><label><input type="radio" id="sdfg" name="sorting">HejHejHesadasdasdasasdsdffsdfsdfdjej</label></li>
                <li><label><input type="radio" id="sdf" name="sorting">HejHejHesadasdasdasasdsdffsdfsdfdjej</label></li>
                <li><label><input type="radio" id="sdg" name="sorting">HejHejHesadasdasdasasdsdffsdfsdfdjej</label></li>
                <li><label><input type="radio" id="sfg" name="sorting">HejHejHesadasdasdasasdsdffsdfsdfdjej</label></li>
                <li><label><input type="radio" id="dfrag" name="sorting">HejHejHesadasdasdasasdsdffsdfsdfdjej</label></li>
                <li><label><input type="radio" id="sg" name="sorting">HejHejHesadasdasdasasdsdffsdfsdfdjej</label></li>
            </ul>
        </div>
    </div>

    <div class="NJSortBy">
        <h2 id="filter_by"> Filter by</h2>
        <div class="checkbox">
        <ul class="nobullets">
            <li><label><input type="checkbox" id="foo">HejHejHesadasdasdasasdsdffsdfsdfdjej</label></li>
            <li><label><input type="checkbox" id="bar">Hej</label></li>
            <li><label><input type="checkbox" id="baz">Hej</label></li>
            <li><label><input type="checkbox" id="dfvg">Hej</label></li>
            <li><label><input type="checkbox" id="dfg">Hej</label></li>
            <li><label><input type="checkbox" id="cvbcvb">HejHejHejHej</label></li>
            <li><label><input type="checkbox" id="b">HejHejHejHej</label></li>
            <li><label><input type="checkbox" id="csdsdb">HejHejHejHej</label></li>
            <li><label><input type="checkbox" id="casasb">HejHejHejHej</label></li>
        </ul>
        </div>
    </div>
</div>

<div class="searchWrapper">
    <c:forEach items="${ddHash}" var="dummydata">
        <a href ="/nordjyske/search?article=${dummydata.key}" class="searchResultLinks">
        <div class="searchResult">
            <h1 class="articletitle">${dummydata.value.title} </h1>
            <h2 class="articlesub">${dummydata.value.subtitle}</h2>
            <p class="author">${dummydata.value.author}</p>
            <p class="date">${dummydata.value.date}</p>
            <p class="articletext">${dummydata.value.articleText}</p>
            <p class="keywods">   </p>
        </div>
        </a>
    </c:forEach>


</div>

</body>

</html>
