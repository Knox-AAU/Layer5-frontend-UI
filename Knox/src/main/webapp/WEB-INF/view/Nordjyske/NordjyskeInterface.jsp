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
</head>
<body>
    <div id="headlineWrapper">
        <div id="headline">
            <h1>Nordjyske</h1>
        </div>
    </div>

<div id="searchbar">
    <form:form action="/knox/nordjyske" method="get">
        <input type="text" name="searched" placeholder="Search..." >


        <spring:url value="/resources/icons/search-solid.svg" var="search_solid" />
        <input type="image" src="${search_solid}" name="submit" value="submit">

    </form:form>

</div>


<div id="sidebar" class="nordjyske">

    <div class="sortBy">
        <h2 id="sort_by"> Sort by</h2>
        <div class="checkbox">
            <ul class="nobullets">
                <li><label><input type="radio" id="sdfg" name="sorting">SortOption1</label></li>
                <li><label><input type="radio" id="sdf" name="sorting">SortOption2</label></li>
                <li><label><input type="radio" id="sdg" name="sorting">SortOption3</label></li>
                <li><label><input type="radio" id="sfg" name="sorting">SortOption4</label></li>
                <li><label><input type="radio" id="dfrag" name="sorting">SortOption5</label></li>
                <li><label><input type="radio" id="sg" name="sorting">SortOption6</label></li>
            </ul>
        </div>
    </div>

    <div class="sortBy">
        <h2 id="filter_by"> Filter by</h2>
        <div class="checkbox">
        <ul class="nobullets">
            <li><label><input type="checkbox" id="foo">FilterOption1</label></li>
            <li><label><input type="checkbox" id="bar">FilterOption2</label></li>
            <li><label><input type="checkbox" id="baz">FilterOption3</label></li>
            <li><label><input type="checkbox" id="dfvg">FilterOption4</label></li>
            <li><label><input type="checkbox" id="dfg">FilterOption5</label></li>
            <li><label><input type="checkbox" id="cvbcvb">FilterOption6</label></li>
            <li><label><input type="checkbox" id="b">FilterOption7</label></li>
            <li><label><input type="checkbox" id="csdsdb">FilterOption8</label></li>
            <li><label><input type="checkbox" id="casasb">FilterOption9</label></li>
        </ul>
        </div>
    </div>
</div>

<div id="searchWrapper">
    <c:forEach items="${ddHash}" var="dummydata">
        <a href ="/knox/nordjyske/search?article=${dummydata.key}" id="searchResultLinks">
        <div id="searchResult">
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
