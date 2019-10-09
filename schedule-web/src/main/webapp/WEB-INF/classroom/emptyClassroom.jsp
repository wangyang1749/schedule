<%--
  Created by IntelliJ IDEA.
  User: wangyang
  Date: 2019/3/7
  Time: 15:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="/struts-tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="../inc/top.jsp"%>
<form action="classroom_emptyClassroom">
    <input type="text" name="week">
    <input type="text" name="classtime">
    <input type="submit" value="查询">
</form>
        <h1>空教室查询</h1>
        ${emptyClassroom}

</body>
</html>
