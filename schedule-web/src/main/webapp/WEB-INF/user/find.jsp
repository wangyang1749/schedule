<%--
  Created by IntelliJ IDEA.
  User: wangyang
  Date: 2019/3/10
  Time: 10:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>


<html>
<head>
    <title>Title</title>
    <link href="<%=request.getContextPath()%>/css/admin/admin.css" rel="stylesheet" type="text/css">
    <style>

    </style>
</head>
<body>
<div>
    <div class="c_nav">
        <dl >
            <dd><a href="user_addInput" target="myFrameName">添加用户</a></dd>
            <dd><a>用户列表</a></dd>
        </dl>
    </div>
    <table class="tab" >
        <tr><td>用户ID</td><td>用户名</td><td>班级名称</td><td>操作</td><tr>
        <s:iterator value="#user.data" var="u" >
        <tr>
        <td><s:property value="#u.id"/></td>
        <td><s:property value="#u.username"/></td>
        <td><s:property value="#u.className"/></td>
        <td><a href="user_delete?id=<s:property value='#u.id'/> ">删除</a><a href="user_updateInput?id=<s:property value='#u.id'/>">更新</a></td>
        </tr>

        </s:iterator>
    </table>
    <div>
        总页数：<s:property value="#user.totalPage" />
        总记录数：<s:property value="#user.totalRecord" />
        一页显示的数据：<s:property value="#user.pageSize" />
        当前的页数：<s:property value="#user.pageIndex" />
    </div>
    <div>
        <s:if test=" #user.totalPage<= #user.pageSize">
            首页 上一页下一页尾页
        </s:if>
        <s:if test="#user.totalPage>#user.pageSize && #user.pageIndex < #user.totalPage">
            <a href="user_find?pageIndex= 1" target="myFrameName" >首页</a>
            <a href="user_find?pageIndex=<s:property value='#user.pageIndex-1'/> " target="myFrameName" >上一页</a>
            <a href="user_find?pageIndex=<s:property value='#user.pageIndex+1'/> " target="myFrameName" >下一页</a>
            <a href="user_find?pageIndex=<s:property value='#user.totalPage'/> " target="myFrameName" >尾页</a>
        </s:if>
        <s:if test="#user.pageIndex == #user.totalPage && #user.totalPage> #user.pageSize" >
            <a href="user_find?pageIndex= 1" target="myFrameName" >首页</a>
            <a href="user_find?pageIndex=<s:property value='#user.pageIndex-1'/> " target="myFrameName" >上一页</a>
            下一页尾页
        </s:if>
    </div>
</div>
</body>
</html>
