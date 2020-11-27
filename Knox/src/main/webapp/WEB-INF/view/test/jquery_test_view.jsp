<%--
  Created by IntelliJ IDEA.
  User: bjark
  Date: 07/10/2020
  Time: 11.09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@ include file="../common/html_head.jspf"%>
<body>

<div>

 <h1 id="Title"></h1>
 <h2 id="SubTitle"> </h2>

</div>

<div>
 <p id="Author"></p>

</div>

<div>
 <p id="Date"></p>

</div>

<div>

 <p id="ArticleText"></p>

</div>


<div id="Pictures">

</div>

<button id="btn_dropdown">
 Dropdown
</button>
<div id="dropdown" class="dropdown dropdownclosed">
  <a>Hey</a>
 <a>Hello</a>
 <a>Goodday</a>
 <a>Guttentag</a>
</div>


<div>
 <a id="TEST">Press Me</a>
 </div>
 <div>
 <a id="GrundFosTEST">press for grundfos</a>
 </div>
</body>

<script>
    $( "#TEST" ).click(function() {
     console.log("Dude?");
     PostCall("nordjysksearch","dummydata");
    });

    $( "#GrundFosTEST" ).click(function() {
     console.log("maDude?");
     PostCall("grundfossearch","Hallothere");
    });

    $("#btn_dropdown").click(function () {
     console.log("hello from Mortan");
     DropDown("dropdown") ;})


</script>
<spring:url value="/resources/javascript/convert-to-html-nordjysk.js" var="converter" />
<script src="${converter}"></script>

<spring:url value="/resources/javascript/convert-to-html-grundfos.js" var="converter" />
<script src="${converter}"></script>


</html>
