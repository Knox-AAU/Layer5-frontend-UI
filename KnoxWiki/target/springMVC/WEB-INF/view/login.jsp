<%--
  Created by IntelliJ IDEA.
  User: bjark
  Date: 29/09/2020
  Time: 13.42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@ include file="common/header.jspf"%>
<body>
<%@ include file="common/nav.jspf"%>
<div id="container">
    <form id="login_form" method="post">
        <h1>
            Login
        </h1>
        <p>Username</p>
        <input type="text" id="username" name="username">
        <p>Password</p>
        <input type="password" id="password" name="password">
        <button class="btn btn_accept" type="submit" value="">Log in</button>
    </form>
</div>
</body>
</html>
