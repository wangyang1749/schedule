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
    <form action="article_add" method="POST" target="myFrameName">
        课程id<input type="text" name="courseId"><br>
        用户id<input type="text" name="userId"><br>
        班级id<input type="text" name="gradeId"><br>
        文章名称：<input type="text" name="title"><br>
        文章内容：<input type="text" name="content"><br>
        <input type="submit" value="添加"><br>
    </form>
<s:debug/>
</body>
</html>
