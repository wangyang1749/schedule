<%--
  Created by IntelliJ IDEA.
  User: wangyang
  Date: 2019/3/6
  Time: 17:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width">
    <title>Title</title>
    <script>
        (function(){
            var html = document.documentElement;
            var hWidth = html.getBoundingClientRect().width;
            html.style.fontSize = hWidth/16 + "px";
        })()
    </script>


    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/style/main.css">

    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/css_1/iconfont.css">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/css_1/index.css">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/css_1/my.css">

    <script type="text/javascript" src="<%=request.getContextPath()%>/js/script/zepto.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/script/flexiable.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/script/timetable.js"  charset="utf-8" ></script>
</head>
<body>
<div class="c_nav">
    <dl >
        <dd><a href="schedule_addInput?className=<s:property value="className"/> " target="myFrameName">添加课程</a></dd>
        <dd><a>班级列表</a></dd>
    </dl>
</div>
<div class="container">
    <div id="table1"></div>
</div>

<c:debug/>
<!--底部导航-->

</body>
<script>


    var data = eval( ${ schedules  } );
    console.log(data);


    /*
     week代表星期几上课，
     classTime代表第几节，
     durable表示上课长度，如2代表连上2节，
     courseName代表具体内容。
   */
    // var datas= [
    //     { "week": 1, "classTime": 1, "durable": 2, "courseName": "高等数学@1教-502" ,"aaa":123163},
    //     { "week": 1, "classTime": 5, "durable": 3, "courseName": "高等数学@1教-502" },
    //     { "week": 2, "classTime": 1, "durable": 2, "courseName": "高等数学@1教-502"},
    //     { "week": 2, "classTime": 8, "durable": 2, "courseName": "高等数学@1教-502" },
    //     { "week": 3, "classTime": 4, "durable": 1, "courseName": "高等数学@1教-502" },
    //     { "week": 3, "classTime": 8, "durable": 1, "courseName": "高等数学@1教-502" },
    //     { "week": 3, "classTime": 5, "durable": 2, "courseName": "高等数学@1教-502" },
    //     { "week": 4, "classTime": 2, "durable": 3, "courseName": "高等数学@1教-502" },
    //     { "week": 4, "classTime": 8, "durable": 2, "courseName": "高等数学@1教-502" },
    //     { "week": 5, "classTime": 1, "durable": 2, "courseName": "高等数学@1教-502" },
    //     { "week": 6, "classTime": 3, "durable": 2, "courseName": "高等数学@1教-502" },
    //     { "week": 7, "classTime": 5, "durable": 3, "courseName": "高等数学@1教-502" }
    // ];
    var datas=data;

    $("#table1").timeTable({
        classNum:"12",
        wlist:datas,
        title:'<tr><th></th><th>周一</th><th>周二</th><th>周三</th><th>周四</th><th>周五</th><th>周六</th><th>周日</th></tr>'
    });


</script>
</html>
