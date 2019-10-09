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
    <h1>跟新用户</h1>
    <form action="user_update" method="POST" target="myFrameName">
        <input type="hidden" name="user.id" value="<s:property value='user.id'/> " ><br>
        用户名：<input type="text" name="user.username" value="<s:property value='user.username'/> "><br>
        班级名称：<input type="text" name="user.className" value="<s:property value='user.className'/>"><br>
        <input type="submit" value="更新">
    </form>
    <s:debug/>
</body>
</html>
