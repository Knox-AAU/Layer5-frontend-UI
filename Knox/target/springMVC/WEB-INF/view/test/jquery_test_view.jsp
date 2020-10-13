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
