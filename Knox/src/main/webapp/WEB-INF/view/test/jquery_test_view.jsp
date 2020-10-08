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
 <a id="TEST">Press Me</a>

</body>

<script>
    $( "#TEST" ).click(function() {
     console.log("Dude?");
     PostCall("nordjysksearch","Hallo");
    });

</script>


</html>
