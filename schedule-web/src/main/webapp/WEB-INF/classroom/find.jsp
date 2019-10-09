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
</head>
<body>
<div>
    <div class="c_nav">
        <dl >
            <dd><a href="classroom_addInput" target="myFrameName">添加教室</a></dd>
            <dd><a>班级列表</a></dd>
        </dl>
    </div>
    <table class="tab" border="1">
        <tr><td>用户ID</td><td>用户名</td><td>班级名称</td><td>操作</td><tr>
        <s:iterator value="#classroom.data" var="c" >
        <tr>
        <td><s:property value="#c.id"/></td>
        <td><s:property value="#c.classroomName"/></td>
        <td><s:property value="#c.classroomNameId"/></td>
        <td><a href="classroom_delete?id=<s:property value='#c.id'/> ">删除</a><a href="classroom_updateInput?id=<s:property value='#c.id'/>">更新</a></td>
        </tr>

        </s:iterator>
    </table>
    <div>
        总页数：<s:property value="#classroom.totalPage" />
        总记录数：<s:property value="#classroom.totalRecord" />
        一页显示的数据：<s:property value="#classroom.pageSize" />
        当前的页数：<s:property value="#classroom.pageIndex" />
    </div>
    <div>
        <s:if test=" #classroom.totalPage<= #classroom.pageSize">
            首页 上一页下一页尾页
        </s:if>
        <s:if test="#classroom.totalPage>#classroom.pageSize && #classroom.pageIndex < #classroom.totalPage">
            <a href="classroom_find?pageIndex= 1" target="myFrameName" >首页</a>
            <a href="classroom_find?pageIndex=<s:property value='#classroom.pageIndex-1'/> " target="myFrameName" >上一页</a>
            <a href="classroom_find?pageIndex=<s:property value='#classroom.pageIndex+1'/> " target="myFrameName" >下一页</a>
            <a href="classroom_find?pageIndex=<s:property value='#classroom.totalPage'/> " target="myFrameName" >尾页</a>
        </s:if>
        <s:if test="#classroom.pageIndex == #classroom.totalPage && #classroom.totalPage> #classroom.pageSize">
            <a href="classroom_find?pageIndex= 1" target="myFrameName" >首页</a>
            <a href="classroom_find?pageIndex=<s:property value='#classroom.pageIndex-1'/> " target="myFrameName" >上一页</a>
            下一页尾页
        </s:if>

    </div>
</body>
</html>
