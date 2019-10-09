<%--
  Created by IntelliJ IDEA.
  User: wangyang
  Date: 2019/3/11
  Time: 23:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Title</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width">
    <title>Title</title>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/script/flexiable.js"></script>

    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/css_1/iconfont.css">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/css_1/index.css">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/css_1/my.css">
    <style>
        ul{
            list-style: none;
        }
       .top-layout-list li{
            float: left;
            font-size: 14px;
            background: #fff;
            height: 33px;
            line-height: 33px;
            padding: 0 2px;
       }
    </style>
     
</head>

<body>
    <ul class="top-layout-list">
    <s:iterator value="#course" var="c">
            <li><s:property value="#c.courseName"/></li>
    </s:iterator>
    </ul>

<!--底部导航-->
<%@include file="../inc/fooder.jsp"%>
</body>
</html>
