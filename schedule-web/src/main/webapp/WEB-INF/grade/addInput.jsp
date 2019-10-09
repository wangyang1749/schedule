<%--
  Created by IntelliJ IDEA.
  User: wangyang
  Date: 2019/3/10
  Time: 11:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>添加班级</h1>
    <form action="grade_add" method="POST" target="myFrameName">
        <input type="text" name="grade.gradeName">
        <input type="text" name="grade.gradeNameId">
        <input type="submit" value="添加">
    </form>
<s:debug/>
</body>
</html>
