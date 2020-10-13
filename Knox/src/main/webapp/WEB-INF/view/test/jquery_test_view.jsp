<%--
  Created by IntelliJ IDEA.
  User: bjark
  Date: 07/10/2020
  Time: 11.09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@ include file="../common/header.jspf"%>
<body>

<div>

 <h1 id="Title">
 </h1>

 <h2 id="SubTitle">

 </h2>

</div>



<div>

 <p id="Author">

 </p>

</div>



<div>
 <p id="Date">

 </p>


</div>



<div>
 <p id="ArticleText">

 </p>

</div>

<div id="Pictures">

</div>


<!--
<img id="Picture0" src= "https://img.nordjyske.dk/s3/nj-prod-public-images/DrhdqWEz3eKpmWMTe5QHeGHK2kI.jpg?w=960&h=540&scale=both&mode=crop">

<img id="Picture1" src= "https://img.nordjyske.dk/s3/nj-prod-public-images/DrhdqWEz3eKpmWMTe5QHeGHK2kI.jpg?w=960&h=540&scale=both&mode=crop">

<img id="Picture2" src= "https://img.nordjyske.dk/s3/nj-prod-public-images/DrhdqWEz3eKpmWMTe5QHeGHK2kI.jpg?w=960&h=540&scale=both&mode=crop">

<img id="Picture3" src= "https://img.nordjyske.dk/s3/nj-prod-public-images/DrhdqWEz3eKpmWMTe5QHeGHK2kI.jpg?w=960&h=540&scale=both&mode=crop">

<img id="Picture4" src= "https://img.nordjyske.dk/s3/nj-prod-public-images/DrhdqWEz3eKpmWMTe5QHeGHK2kI.jpg?w=960&h=540&scale=both&mode=crop">

-->





<div>
 <a id="TEST">Press Me</a>
 </div>
 <div>
 <a id="GrundFossTEST">press for grundfoss</a>
 </div>
</body>

<script>
    $( "#TEST" ).click(function() {
     console.log("Dude?");
     PostCall("nordjysksearch","dummydata");
    });

    $( "#GrundFossTEST" ).click(function() {
     console.log("maDude?");
     PostCall("grundfosssearch","Hallothere");
    });
</script>
<spring:url value="/resources/javascript/convert-to-html-nordjysk.js" var="converter" />
<script src="${converter}"></script>



</html>
