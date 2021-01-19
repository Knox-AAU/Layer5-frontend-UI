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
                <input id="object" class="search_input_split" type="text" name="object" placeholder="Object..." >
                <input id="subject" class="search_input_split" type="text" name="subject" placeholder="Subject..." >
                <input id="predicate" class="search_input_split" type="text" name="predicate" placeholder="Predicate..." >
                <spring:url value="/resources/icons/search-solid.svg" var="search_solid" />
                <a id="search_button" class="button nordjyskesearch">
                    <p>
                        Search
                    </p>
                    <img src="${search_solid}">
                </a>

                <!--<input class="search_icon"   type="image" src="${search_solid}" name="submit" value="submit"> -->

        </div>

        <div id="searchWrapper">
            <!--
            <c:forEach items="${searchResults}" var="result">
                <a href ="/knox/nordjyske/search?article=${result.sourceDocument}" class="button_link searchResult">
                    <div>
                        <h1 class="articletitle">${result.documentTitle} </h1>
                        <h2 class="articlesub">${result.passage}</h2>
                    </div>
                </a>
            </c:forEach> -->
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



</body>
<script>
    var SearchContentWrapper = document.getElementById("searchWrapper")

    $('#search_button').click(function() {
        var object = document.getElementById("object").value;
        var subject = document.getElementById("subject").value;
        var predicate = document.getElementById("predicate").value;
        var search = {object:object,subject:subject, predicate:predicate};
        console.log(search);
        PostCall("nordjysksearch",search, SearchCallBack);
        console.log("Searching...");
    });

    function SearchCallBack (result) {
        console.log("CallBack");
        console.log(result);
        var articalElement = convertNordjyskeToHtml(result);
        console.log(articalElement);
        // Clear current search result
        SearchContentWrapper.innerHTML = '';
        // Add search result
        for (var i = 0; i < articalElement.length; i++){
            SearchContentWrapper.appendChild(articalElement[i]);
        }
    }
</script>

</html>
