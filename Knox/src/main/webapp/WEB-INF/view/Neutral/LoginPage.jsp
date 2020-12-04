<%--
  Created by IntelliJ IDEA.
  User: Marti
  Date: 12/2/2020
  Time: 1:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<%@ include file="../common/html_head.jspf"%>
<head>
    <title>LoginPage</title>
    <h1 style="text-align: center">Welcome!</h1>
</head>
<body>
    <div class="Credentials-table">
        <h3>Please enter credentials</h3>
        <h2 class="userFeedback-Field" id="Feedback" >${UserFeedback}</h2>
        <form id="LoginForm" method="post">
            <table>
                <tr class="">
                    <td>Username</td>
                    <td> <input type="text" class="Credentials-Fields" id="username" name="username"> </td>
                </tr>
                <tr class="Credentials-Cell">
                    <td>Password</td>
                    <td> <input type="text" class="Credentials-Fields" id="password" name="password"> </td>
                </tr>
                <tr>
                    <td><input type="submit" class="Submit_btn" value="Submit"/></td>
                </tr>
            </table>
        </form>
    </div>
</body>
</html>