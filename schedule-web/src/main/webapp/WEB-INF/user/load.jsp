<%--
  Created by IntelliJ IDEA.
  User: wangyang
  Date: 2019/3/5
  Time: 21:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="/struts-tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
       <c:property value="#user"/>
       ${user.username}
<c:debug/>
</body>
</html>
