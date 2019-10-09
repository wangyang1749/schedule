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
    <title>Title</title>
    <style>

        /*表格的样式*/
        .table{
            border-collapse: collapse;
            text-align: center;
            width: 100%;
        }
        .table,.table th,.table td{
            border: 1px solid #98bf21;
        }
        .table th{
            background-color: #A7C942;
            font-size: 1.1em;
            color: #fff;
        }
        .table tr:NTH-CHILD(2n+1){
            background-color:#EAF2D3;
        }

    </style>
</head>
<body>
    <h1>query</h1>
    <table class="table" id="tab" >
        <tr><th colspan="8">课表</th></tr>
        <tr><th><div id="btn"></div></th><th>周一</th><th>周二</th><th>周三</th><th>周四</th><th>周五</th><th>周六</th><th>周日</th></tr>
    </table>




    ${schedules}

 <%--<s:iterator value="#schedules" var="schedule">--%>
    <%--<s:property value="#schedule.id"/>----%>
     <%--<s:property value="#schedule.coursename"/> ----%>
     <%--<s:property value="#schedule.teacherName"/>--%>
     <%--<s:property value="#schedule.week"/>--%>
     <%--<s:property value="#schedule.classtime"/><br>--%>
 <%--</s:iterator>--%>
    <c:debug/>
</body>
<script>
    <%--var data = eval( ${schedules} );--%>

</script>
</html>
