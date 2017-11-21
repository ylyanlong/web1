<%--
  Created by IntelliJ IDEA.
  User: leon.yan
  Date: 2017/11/21
  Time: 15:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>session</title>
</head>
<body>
    <% com.yl.web.user.entity.AccountBean accountBean = (com.yl.web.user.entity.AccountBean)session.getAttribute("account"); %>
    username: <%=accountBean.getUserName() %>
    <br>
    password: <%=accountBean.getPassword()%>
</body>
</html>
