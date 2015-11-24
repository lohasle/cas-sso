<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String contextPath = request.getContextPath();
%>
<html>
<body>
    <h1><%=request.getAttribute("user")%></h1>
    <h1><%=request.getAttribute("user2")%></h1>
    <h1><%=request.getAttribute("attributes")%></h1>
<a href="http://passport.lohas.github:8080/logout?service=http://dev.lohas.github:8081">同步登出</a>
</body>
</html>
