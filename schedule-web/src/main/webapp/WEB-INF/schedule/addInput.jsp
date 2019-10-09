<%--
  Created by IntelliJ IDEA.
  User: wangyang
  Date: 2019/3/10
  Time: 9:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


    <form  action="schedule_add" method="POST" target="myFrameName" >
        课程名称：<input type="text" name="courseName"><br>
        教室名称：<input type="text" name="classroomName"><br>
        教师姓名：<input type="text" name="teacherName"><br>
        班级名称：<input type="text" name="className" value="${className}"><br>
        星期：<input type="text" name="week"><br>
        节数：<input type="text" name="classTime"><br>
        持续时间：<input type="text" name="durable"><br>
        规则：<input type="text" name="classRule"><br>
        人数：<input type="text" name="totalPeople"><br>
     
        <input type="submit" value="提交">
    </form>

</body>
</html>
