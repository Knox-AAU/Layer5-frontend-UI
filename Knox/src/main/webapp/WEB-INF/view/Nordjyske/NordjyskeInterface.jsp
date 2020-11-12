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
<%@ include file="../common/html_head.jspf"%>

<body>
<%@ include file="../common/header.jspf"%>

<!-- Main content of the page -->

<div class="maincontent">
    <div id="headlineWrapper">
        <div id="headline">
            <h1>Nordjyske</h1>
        </div>
    </div>

    <div id="searchbar">
        <form:form action="/knox/nordjyske" method="get">
            <input class="search_input" type="text" name="searched" placeholder="Search..." >


            <spring:url value="/resources/icons/search-solid.svg" var="search_solid" />
            <input class="search_icon"   type="image" src="${search_solid}" name="submit" value="submit">

        </form:form>

    </div>

    <div id="searchWrapper">
        <c:forEach items="${ddHash}" var="dummydata">
            <a href ="/knox/nordjyske/search?article=${dummydata.key}" class="button_link searchResult">
                <div>
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
</div>

<!-- Side bar -->

<div id="sidebar" class="nordjyske">

    <div class="sidebar_component">
        <h2 > Sort by</h2>
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

    <div class="sidebar_component">
        <h2 > Filter by</h2>
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



</body>

</html>
