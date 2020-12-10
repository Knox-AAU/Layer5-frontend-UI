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

<div class="maincontent_wrapper">
    <div class="maincontent">
        <div id="headlineWrapper">
            <div id="headline">
                <h1>Nordjyske</h1>
            </div>
        </div>

        <div id="searchbar">
            <form:form action="/knox/nordjyske" method="get">
                <input class="search_input" type="text" name="object" placeholder="Object..." >
                <input class="search_input" type="text" name="subject" placeholder="Subject..." >
                <input class="search_input" type="text" name="predicate" placeholder="Predicate..." >
                <spring:url value="/resources/icons/search-solid.svg" var="search_solid" />
                <button class="nordjyske_search_button" type="submit">
                    <p>
                        Search
                    </p>
                    <img src="${search_solid}">
                </button>

                <!--<input class="search_icon"   type="image" src="${search_solid}" name="submit" value="submit"> -->

            </form:form>

        </div>

        <div id="searchWrapper">
            <c:forEach items="${searchResults}" var="result">
                <a href ="/knox/nordjyske/search?article=${result.sourceDocument}" class="button_link searchResult">
                    <div>
                        <h1 class="articletitle">${result.documentTitle} </h1>
                        <h2 class="articlesub">${result.passage}</h2>
                    </div>
                </a>
            </c:forEach>
        </div>

    </div>

    <!-- Side bar -->

    <div id="sidebar" class="nordjyske">
        <div class="sidebar_wrapper">
            <div class="sidebar_component">
                <h2 > Sort by</h2>
                <div class="checkbox">
                    <ul class="nobullets">
                        <li>
                            <label>
                                <p class="sidebar_option_text">HejHejHesadasdasdasasdsdffsdfsdfdjej</p>
                                <input type="radio" id="sdfg" name="sorting">
                            </label>
                        </li>
                        <li>
                            <label>
                                <p class="sidebar_option_text">HejHejHesadasdasdasasdsdffsdfsdfdjej</p>
                                <input type="radio" id="sdf" name="sorting">
                            </label>
                        </li>
                        <li>
                            <label>
                                <p class="sidebar_option_text">HejHejHesadasdasdasasdsdffsdfsdfdjej</p>
                                <input type="radio" id="sdg" name="sorting">
                            </label>
                        </li>
                        <li>
                            <label>
                                <p class="sidebar_option_text">HejHejHesadasdasdasasdsdffsdfsdfdjej</p>
                                <input type="radio" id="sfg" name="sorting">
                            </label>
                        </li>
                        <li>
                            <label>
                                <p class="sidebar_option_text">HejHejHesadasdasdasasdsdffsdfsdfdjej</p>
                                <input type="radio" id="dfrag" name="sorting">
                            </label>
                        </li>
                        <li>
                            <label>
                                <p class="sidebar_option_text">HejHejHesadasdasdasasdsdffsdfsdfdjej</p>
                                <input type="radio" id="sg" name="sorting">
                            </label>
                        </li>
                    </ul>
                </div>
            </div>

            <div class="sidebar_component">
                <h2 > Filter by</h2>
                <div class="checkbox">
                    <ul class="nobullets">
                        <li>
                            <label>
                                <p class="sidebar_option_text">HejHejHesadasdasdasasdsdffsdfsdfdjej</p>
                                <input type="checkbox" id="foo">
                            </label>
                        </li>
                        <li>
                            <label>
                                <p class="sidebar_option_text">Hej</p>
                                <input type="checkbox" id="bar">
                            </label>
                        </li>
                        <li>
                            <label>
                                <p class="sidebar_option_text">Hej</p>
                                <input type="checkbox" id="baz">
                            </label>
                        </li>
                        <li>
                            <label>
                                <p class="sidebar_option_text">Hej</p>
                                <input type="checkbox" id="dfvg">
                            </label>
                        </li>
                        <li>
                            <label>
                                <p class="sidebar_option_text">Hej</p>
                                <input type="checkbox" id="dfg">
                            </label>
                        </li>
                        <li>
                            <label>
                                <p class="sidebar_option_text">HejHejHejHej</p>
                                <input type="checkbox" id="cvbcvb">
                            </label>
                        </li>
                        <li>
                            <label>
                                <p class="sidebar_option_text">HejHejHejHej</p>
                                <input type="checkbox" id="b">
                            </label>
                        </li>
                        <li>
                            <label>
                                <p class="sidebar_option_text">HejHejHejHej</p>
                                <input type="checkbox" id="csdsdb">
                            </label>
                        </li>
                        <li>
                            <label>
                                <p class="sidebar_option_text">HejHejHejHej</p>
                                <input type="checkbox" id="casasb">
                            </label>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>



</body>

</html>
