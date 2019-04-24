<!DOCTYPE html>
<html>
<head lang="en"></head>
<body>

<%
    response.setHeader("Cache-Control","no-cache");
    response.setHeader("Cache-Control","no-store");
    response.setDateHeader("Expires", 0);
    response.setHeader("Pragma","no-cache");

    String userSession = (String)session.getAttribute("user_session");
    if(userSession == null) response.sendRedirect("login");

%>

<jsp:include page="dashboard.html"/>


</body>
</html>