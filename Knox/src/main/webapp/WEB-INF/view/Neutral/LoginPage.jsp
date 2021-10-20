<%--
  Created by IntelliJ IDEA.
  User: Marti
  Date: 12/2/2020
  Time: 1:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<%@ include file="../common/html_head.jspf" %>
<body>

<%@ include file="../common/header.jspf" %>

<div class="maincontent_wrapper">
    <div class="maincontent">
        <h1 class="Login_Welcome" style="text-align: center">Welcome!</h1>
        <div class="Credentials-table">
            <h3>Please enter credentials</h3>
            <h2 class="userFeedback-Field" id="Feedback">${UserFeedback}</h2>
            <form id="LoginForm" method="post">
                <div class="LoginForm_Input_Wrapper">
                    <p>Username</p>
                    <input type="text" class="Credentials-Fields" id="username" name="username">
                </div>

                <div class="LoginForm_Input_Wrapper">
                    <p>Password</p>
                    <input type="text" class="Credentials-Fields" id="password" name="password">
                </div>

                <input type="submit" class="button loginbutton" value="Login"/>
            </form>
        </div>
    </div>
</div>
</body>
</html>