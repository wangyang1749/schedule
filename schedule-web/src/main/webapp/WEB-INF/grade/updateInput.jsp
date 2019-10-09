<%--
  Created by IntelliJ IDEA.
  User: wangyang
  Date: 2019/3/10
  Time: 19:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>更新班级</h1>
    <form action="grade_update" method="POST" target="myFrameName">
        <input type="hidden" name="grade.id" value="<s:property value='grade.id'/> " ><br>
        班级名称：<input type="text" name="grade.gradeName" value="<s:property value='grade.gradeName'/> "><br>
        班级编号：<input type="text" name="grade.gradeNameId" value="<s:property value='grade.gradeNameId'/>"><br>
        <input type="submit" value="更新">
    </form>
    <s:debug/>
</body>
</html>
