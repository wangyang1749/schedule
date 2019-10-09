<%--
  Created by IntelliJ IDEA.
  User: wangyang
  Date: 2019/3/11
  Time: 9:13
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
<div class="c_nav">
    <dl >
        <dd><a href="article_addInput" target="myFrameName">添加文章</a></dd>
        <dd><a>文章列表</a></dd>
    </dl>
</div>
    <table class="tab" border="1">
        <tr><td>文章标题</td><td>发布人</td><td>发布位置</td><td>课程名称</td><td>操作</td><tr>
        <s:iterator value="#article.data" var="a" >
        <tr>
        <td><a href="article_load?id=<s:property value='#a.id'/>"><s:property value="#a.title"/></a></td>
            <td><s:property value="#a.user.username"/></td>
            <td><s:property value="#a.grade.gradeName"/></td>
            <td><s:property value="#a.course.courseName"/></td>
            <td><a href="article_delete?id=<s:property value='#a.id'/> ">删除</a><a href="article_updateInput?id=<s:property value='#a.id'/>">更新</a></td>

        </tr>

        </s:iterator>
    </table>
<div>
    总页数：<s:property value="#article.totalPage" />
    总记录数：<s:property value="#article.totalRecord" />
    一页显示的数据：<s:property value="#article.pageSize" />
    当前的页数：<s:property value="#article.pageIndex" />
</div>
<div>
    <s:if test=" #article.totalPage<= #article.pageSize">
        首页 上一页下一页尾页
    </s:if>
    <s:if test="#article.totalPage>#article.pageSize && #article.pageIndex < #article.totalPage">
        <a href="article_find?pageIndex= 1" target="myFrameName" >首页</a>
        <a href="article_find?pageIndex=<s:property value='#article.pageIndex-1'/> " target="myFrameName" >上一页</a>
        <a href="article_find?pageIndex=<s:property value='#article.pageIndex+1'/> " target="myFrameName" >下一页</a>
        <a href="article_find?pageIndex=<s:property value='#article.totalPage'/> " target="myFrameName" >尾页</a>
    </s:if>
    <s:if test="#article.pageIndex == #article.totalPage && #article.totalPage> #article.pageSize">
        <a href="article_find?pageIndex= 1" target="myFrameName" >首页</a>
        <a href="article_find?pageIndex=<s:property value='#article.pageIndex-1'/> " target="myFrameName" >上一页</a>
        下一页尾页
    </s:if>

</div>
</body>
</html>
