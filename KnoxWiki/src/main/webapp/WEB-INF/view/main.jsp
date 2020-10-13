<%@ page contentType="text/html charset=utf-8"%>
<html>
<%@ include file="common/header.jspf"%>
<body>
<%@ include file="common/nav.jspf"%>
<div class="mainbody">
    <%@ include file="common/sidebar.jspf"%>
    <div class="contained">


        <p>Test 2</p>
        <h2>${message}</h2>

        <form action="/newclass" method="get">
            <button type="submit" class="btn btn_accept" value="">Create new Class</button>
        </form>

    </div>
</div>
</body>
</html>