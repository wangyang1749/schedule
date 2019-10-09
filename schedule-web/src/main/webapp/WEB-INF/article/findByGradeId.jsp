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
    <style>
        *{
            margin: 0;
            padding: 0;
        }
        .c_wapper{

        }
        .c_nav{
            height: 30px;
            background: blue;
        }
        .c_nav dd{
            float: right;
            line-height: 30px;
            width: 80px;
        }
        .tab{
            overflow: hidden;
        }
    </style>
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
总页数：<s:property value="#article.totalPage" />
总记录数：<s:property value="#article.totalRecord" />
一页显示的数据：<s:property value="#article.pageSize" />
当前的页数：<s:property value="#article.pageIndex" />
<a href="article_find?pageIndex=<s:property value='#article.pageIndex+1'/> " target="myFrameName" >下一页</a>

</body>
</html>
