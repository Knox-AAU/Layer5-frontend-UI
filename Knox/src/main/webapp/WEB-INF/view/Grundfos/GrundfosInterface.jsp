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
<div class="maincontent_wrapper">
    <div class="maincontent">
        <div id="headlineWrapper">
            <div id="headline">
                <h1>Grundfos</h1>
            </div>
        </div>
        <div id="searchbar">
                <input id="search_input" class="search_input" type="text" name="searched" placeholder="Search..." >
                <spring:url value="/resources/icons/search-solid.svg" var="search_solid" />
                <a id="search_button" class="search_icon button_link">
                    <img src="${search_solid}">
                </a>
        </div>
        <div id="searchWrapper">
            <!--
            <c:forEach items="${ddHash}" var="dummydata">
                <a href ="/knox/grundfos/search?article=${dummydata.key}" class="button_link searchResult">
                    <div >
                        <h1 id="articletitle">${dummydata.value.title} </h1>
                        <h2 id="articlesub">${dummydata.value.subtitle}</h2>
                        <p  id="author">${dummydata.value.author}</p>
                        <p  id="date">${dummydata.value.date}</p>
                        <p  id="articletext">${dummydata.value.articleText}</p>
                        <p  id="keywods">   </p>
                    </div>
                </a>
            </c:forEach>
            -->
        </div>
    </div>




    <div id="sidebar" class="grundfos">
        <div class="sidebar_wrapper">
            <div class="sidebar_component">
                <h2> Sort by</h2>
                <div class="checkbox">
                    <ul class="nobullets">
                        <li>
                            <label>
                                <p class="sidebar_option_text">Option1</p>
                                <input type="radio" id="sdfg" name="sorting">
                            </label>
                        </li>
                        <li>
                            <label>
                                <p class="sidebar_option_text">Option2</p>
                                <input type="radio" id="sdf" name="sorting">
                            </label>
                        </li>
                        <li>
                            <label>
                                <p class="sidebar_option_text">Option3</p>
                                <input type="radio" id="sdg" name="sorting">
                            </label>
                        </li>
                        <li>
                            <label>
                                <p class="sidebar_option_text">Option4</p>
                                <input type="radio" id="sfg" name="sorting">
                            </label>
                        </li>
                        <li>
                            <label>
                                <p class="sidebar_option_text">Option5</p>
                                <input type="radio" id="dfrag" name="sorting">
                            </label>
                        </li>
                        <li>
                            <label>
                                <p class="sidebar_option_text">Option6</p>
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
                                <p class="sidebar_option_text">Option1</p>
                                <input type="checkbox" id="foo">
                            </label>
                        </li>
                        <li>
                            <label>
                                <p class="sidebar_option_text">Option2</p>
                                <input type="checkbox" id="bar">
                            </label>
                        </li>
                        <li>
                            <label>
                                <p class="sidebar_option_text">Option3</p>
                                <input type="checkbox" id="baz">
                            </label>
                        </li>
                        <li>
                            <label>
                                <p class="sidebar_option_text">Option4</p>
                                <input type="checkbox" id="dfvg">
                            </label>
                        </li>
                        <li>
                            <label>
                                <p class="sidebar_option_text">Option5</p>
                                <input type="checkbox" id="dfg">
                            </label>
                        </li>
                        <li>
                            <label>
                                <p class="sidebar_option_text">Option6</p>
                                <input type="checkbox" id="cvbcvb">
                            </label>
                        </li>
                        <li>
                            <label>
                                <p class="sidebar_option_text">Option7</p>
                                <input type="checkbox" id="b">
                            </label>
                        </li>
                        <li>
                            <label>
                                <p class="sidebar_option_text">Option8</p>
                                <input type="checkbox" id="csdsdb">
                            </label>
                        </li>
                        <li>
                            <label>
                                <p class="sidebar_option_text">Option9</p>
                                <input type="checkbox" id="casasb">
                            </label>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
    var SearchContentWrapper = document.getElementById("searchWrapper")

    $('#search_button').click(function() {
        var search = {search:document.getElementById("search_input").value };
        console.log(search);
        PostCall("grundfossearch",search, SearchCallBack);
        console.log("Searching...");
    });

    function SearchCallBack (result) {
        console.log("CallBack");
        console.log(result);
        var manualElements = convertGrundfosToHtml(result);
        console.log(manualElements);
        // Clear current search result
        SearchContentWrapper.innerHTML = '';
        // Add search result
        for(var i = 0; i < manualElements.length; i++){
            SearchContentWrapper.appendChild(manualElements[i]);
        }


    }
</script>
</body>
</html>
