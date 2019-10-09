<%--
  Created by IntelliJ IDEA.
  User: wangyang
  Date: 2019/3/8
  Time: 23:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
   
    <h1>classroom update</h1>

    <form>
        <input type="text">
        <input type="text">
        <input type="submit">
    </form>
   
<script type="text/javascript" src="<%=request.getContextPath() %>/js/my/jquery-3.3.1.js"></script>
<script>
　  $("form").on("submit",function(event){
        event.preventDefault();
    })
    $("input[type='submit']").click(function(){
        getHtml("classroom_find");
    });

</script>
</body>
</html>
