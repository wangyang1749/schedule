<%--
  Created by IntelliJ IDEA.
  User: wangyang
  Date: 2019/3/11
  Time: 20:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width">
    <title>Title</title>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/script/flexiable.js"></script>

    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/css_1/iconfont.css">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/css_1/index.css">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/css_1/my.css">
</head>
<body>
<section>
    <div class="my-flex">
        <a href="" class="my-flex-left">我的左</a>
        <div class="my-user"><img src="" class="my-user-img"></div>
        <a href="" class="my-flex-right">我的右</a>
    </div>
    <div class="my-layout-list">
        <a href="" class="my-layout-list-left">下左</a>
        <a href="" class="my-layout-list-right">下右</a>
    </div>
    <div class="divHeight"></div>
    <div class="my-list">
        <div class="my-list-box">标题1</div>
    </div>
    <div class="my-layout-list">
        <a href="classroom_emptyClassroom" class="my-layout-list-item1 my-layout-list-item">
            <div>教室查询</div>
        </a>
        <a href="" class="my-layout-list-item2 my-layout-list-item">
            <div>无课查询</div>
        </a>
        <a href="" class="my-layout-list-item3 my-layout-list-item">
            <div>其它课程</div>
        </a>
    </div>
    <div class="divHeight"></div>
    <div class="my-list">
        <div class="my-list-box">标题2</div>
    </div>
    <div class="my-layout-list4">
        <a href="admin_list" class="mylayout-list4-item mylayout-list4-item1">后台管理</a>
        <a href="schedule_queryTeacherJson" class="mylayout-list4-item mylayout-list4-item1">教师课表</a>
        <a href="schedule_addInput" class="mylayout-list4-item mylayout-list4-item1">课程添加</a>
        <a href="" class="mylayout-list4-item mylayout-list4-item4">004</a>
        <a href="" class="mylayout-list4-item mylayout-list4-item1">001</a>
        <a href="" class="mylayout-list4-item mylayout-list4-item1">002</a>
        <a href="" class="mylayout-list4-item mylayout-list4-item1">003</a>
        <a href="" class="mylayout-list4-item mylayout-list4-item4">004</a>
    </div>
</section>


<!--底部导航-->
<%@include file="../inc/fooder.jsp"%>
</body>
</html>
