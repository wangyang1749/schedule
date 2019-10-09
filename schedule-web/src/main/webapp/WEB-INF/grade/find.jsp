<%--
  Created by IntelliJ IDEA.
  User: wangyang
  Date: 2019/3/10
  Time: 10:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="S" uri="/struts-tags" %>


<html>
<head>
    <title>Title</title>
    <link href="<%=request.getContextPath()%>/css/admin/admin.css" rel="stylesheet" type="text/css">
</head>
<body>
<div>
    <div class="c_nav">
        <dl >
            <dd><a href="grade_addInput" target="myFrameName">添加班级</a></dd>
            <dd><a>班级列表</a></dd>
        </dl>
    </div>
    <table class="tab" border="1">
        <tr><td>班级名称</td><td>班级编号</td><td>操作</td><td>查看课表</td><td>查看文章</td><tr>
        <s:iterator value="#grade.data" var="g" >
        <tr>
        <td><s:property value="#g.gradeName"/></td>
        <td><s:property value="#g.gradeNameId"/></td>
        <td><a href="grade_delete?id=<s:property value='#g.id'/> ">删除</a><a href="grade_updateInput?id=<s:property value='#g.id'/>">更新</a></td>
        <td><a href="schedule_queryAdmin?className=<s:property value="#g.gradeName"/> " target="myFrameName">点击查看课表</a></td>
        <td><a href="article_findByGradeId?gradeId=<s:property value="#g.id"/> " target="myFrameName">点击查看文章</a></td>

        </tr>

        </s:iterator>
    </table>
    <div>
        总页数：<s:property value="#grade.totalPage" />
        总记录数：<s:property value="#grade.totalRecord" />
        一页显示的数据：<s:property value="#grade.pageSize" />
        当前的页数：<s:property value="#grade.pageIndex" />
    </div>
    <div>
        <s:if test=" #grade.totalPage<= #grade.pageSize">
            首页 上一页下一页尾页
        </s:if>
        <s:if test="#grade.totalPage>#grade.pageSize && #grade.pageIndex < #grade.totalPage">
            <a href="grade_find?pageIndex= 1" target="myFrameName" >首页</a>
            <a href="grade_find?pageIndex=<s:property value='#grade.pageIndex-1'/> " target="myFrameName" >上一页</a>
            <a href="grade_find?pageIndex=<s:property value='#grade.pageIndex+1'/> " target="myFrameName" >下一页</a>
            <a href="grade_find?pageIndex=<s:property value='#grade.totalPage'/> " target="myFrameName" >尾页</a>
        </s:if>
        <s:if test="#grade.pageIndex == #grade.totalPage && #grade.totalPage> #grade.pageSize">
            <a href="grade_find?pageIndex= 1" target="myFrameName" >首页</a>
            <a href="grade_find?pageIndex=<s:property value='#grade.pageIndex-1'/> " target="myFrameName" >上一页</a>
            下一页尾页
        </s:if>

    </div>
</div>
</body>
</html>
