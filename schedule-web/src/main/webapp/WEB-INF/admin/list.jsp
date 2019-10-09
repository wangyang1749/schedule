<%--
  Created by IntelliJ IDEA.
  User: wangyang
  Date: 2019/3/7
  Time: 19:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/table.css" />
	<style>
		*{
			margin: 0;
			padding: 0;
			cursor:hand;
		}
		a{
			color: #fff;
			text-decoration: none;
		}
		img{
			width: 100%;
		}
		ul{
			list-style: none;
			/* padding-left: 5px; */
			/* padding: 0; */
			text-align: center;
		}
		/*大的包裹器*/
		#wapper{

			width: 1000px;
			margin: 0 auto;
		}
		/*顶部样式*/
		.nav{
			height: 80px;
			width: 100%;
			background: #0098dc;
			
		}
		.nav_left{
			float: left;
			color: #fff;
		}
		.nav_right li{
			float: right;
			color: #fff;
			width: 200px;
		}
		/*下面主体*/
		.body{
			overflow: hidden;
		}
		/*左侧样式*/
		.left{
			float: left;
			background: #016fd0;
			width: 148px;
			border-right: solid 2px #2b2b2b;
		}
		
		.right{
			float: right;
			/* background: blue; */
			width: 850px;
		}
		.tab{
			width: 100%;
		}
	</style>
</head>
<body>
<div id="wapper">	

	<div class="nav">
		<div class="nav_left"><a href="schedule_queryJson">返回首页</a></div>
		<div class="nav_right">
			<ul>
				<li>个人信息</li>
				<li>欢迎管理员[${user.username}]登录系统</li>
				
			</ul>
			
		</div>
	</div>
	<div class="_body">
		<div class="left">
			<ul>
					<!-- <li><a onclick="getHtml('schedule_queryJson')">学生课表查询</a></li>
					<li><a onclick="getHtml('schedule_queryTeacherJson')">教师课表查询</a></li>
					<li><a onclick="getHtml('classroom_emptyClassroom')">空教室查询</a></li>
					<li><a onclick="getHtml('classroom_find')">教室列表</a></li> -->
					<ul>
						<!-- <li><a href="schedule_queryJson" target="myFrameName">学生课表查询</a></li> -->
						<li><a href="user_find" target="myFrameName">用户管理</a></li>
						<li><a href="grade_find" target="myFrameName">班级查询</a></li>
						<li><a href="article_find" target="myFrameName">文章管理</a></li>
						<li><a href="classroom_find" target="myFrameName">教室管理</a></li>
					</ul>
	
			</ul>
		</div>


		<div class="right">
				<!-- scrolling="no" -->
			<iframe width="850px"  height="550px" id="myFrameId" name="myFrameName"  frameborder="0"></iframe> 
		</div>
	</div>
</div>
</body>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/my/jquery-3.3.1.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/my/page.js"></script>
<!-- <script>
	// getHtml("classroom_find");
	function getHtml(_htmlUrl){
		$.get(_htmlUrl,function(data){
			// alert(data);
			$(".right").html(data);
		})  
	}
// 	$(document).ready(function(){ 
// 		$.get("http://localhost:8080/schedule_queryJson",function(data){
// 			alert(data);
// 			$("#test").html(data);
// 		})  

// 　　}); 
</script> -->




</html>
