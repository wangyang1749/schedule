<%--
  Created by IntelliJ IDEA.
  User: wangyang
  Date: 2019/3/9
  Time: 8:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
            .c_body{
                margin: 20px 0px 0 20;
                border: solid 1px green;
            }
        </style>
</head>
<body>
    <div class="c_nav">
        <dl>
            <dd><a onclick="getHtml('classroom_addInput')">添加教室</a></dd>
            <dd><a>教室列表</a></dd>
        </dl>
    </div>
    <form>
        <input type="text">
        <input type="text">
        <input type="submit">
    </form>
</body>
</html>
