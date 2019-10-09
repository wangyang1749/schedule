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
        .table tr:nth-child(1){
            color: red;
        }

    </style>
</head>
<body>
<%@include file="../inc/top.jsp"%>
    <h1>query</h1>
    <table class="table" id="tab" >
        <!-- <tr><th colspan="8">课表</th></tr>
        <tr><th><div id="btn"></div></th><th>周一</th><th>周二</th><th>周三</th><th>周四</th><th>周五</th><th>周六</th><th>周日</th></tr> -->
    </table>




    ${schedules}


    <c:debug/>
</body>
<script src="/js/my/common.js"></script>
<script>
     createTable(
        {
            title:["","周一","周二","周三","周四","周五","周六","周日"],
            totalRow:9
        }
    );
</script>
<script>
   
    var data = eval( ${ schedules  } );
    console.log(data);
    //全局变量
   

    var tab = document.getElementById("tab");
   
    //初始化数据
    initData();
    function initData(){
        //第几节课
        for(var i=0;i<data.length;i++){
            var week=data[i].week;
            var classTime=data[i].classTime;
            //选择课程在表格的位置
            var stab = tab.rows[classTime].cells[week];

            stab.addEventListener("click",function(){
                //
            });
            stab.innerHTML="<a onclick='change("+i+")'>"+data[i].courseName+"-@-"+data[i].classroomName+"</a>";
           
        }
        // console.log(data);
    }	
</script>
</html>
