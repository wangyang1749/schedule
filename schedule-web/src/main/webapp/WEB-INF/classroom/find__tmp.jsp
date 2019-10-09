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

		<!-- <iframe src="http://www.baidu.com">

		</iframe> -->
<div class="c_wapper">
	<div class="c_nav">
		<dl>
			<dd><a onclick="getHtml('classroom_addInput')">添加教室</a></dd>
			<dd><a>教室列表</a></dd>
		</dl>
		
		
	</div>
	<div class="c_body">
		<table class="table" id="tab">
				<!-- <tr>
					<td colspan="9">
						<form action="ybus.admin" method="get">
						<input type="hidden" name="method" value="yulist">
						<input type="search" name="con" value="${con }">
						<input type="submit" value="搜索">
					</form>
					</td>
				</tr>
				<tr><th>课程ID</th> <th>课程名称</th><th>课程性质</th> <th>单双周</th> <th>起始周</th> <th>结束周</th> </tr>
				
				<tr><td colspan="9" id="info">111</td></tr>
				<tr><td colspan="9" id="fpage">5ss5</td></tr> -->
		</table>
	</div>
</div>


</body>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/my/jquery-3.3.1.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/my/page.js"></script>
	<script>
		function updateORadd(_htmlUrl){
		
		}
	</script>

    <script>
		//定义总数据
		var datas = eval(${classroom});
		//定义 数据、当前页、总记录、总页数所使用的字段
		var pageArgs={data:"data",pageIndex:"pageIndex",totalRecord:"totalRecord",totalPage:"totalPage"};
		// _datas.data;
		// 	//当前的页数
		// 	var pageIndex =_datas.pageIndex;
		// 	//总的数目
		// 	var totalRecord = _datas.totalRecord;
		// 	//一共多少页
		// 	var totalPage = _datas.totalPage;

		//一页的数目
		var pageSize=20;
		
		//定义标题数组,为显示的行数
		var jsonColumn=["","教室编号","教室名称","操作"];
		//定义默认表格执行的函数
		var emptyClick=function(e){
			// console.log(e);
		};
		//是否显示左侧标号
		var leftNumber=true;
		//表格的默认值
		var Mvalue =" ";
		
		//定义数据的json字段
		var varValue =["classroomName","classroomNameId"];
		//定义表格
		var tab = document.getElementById("tab");


		//创建表格
		createTabe();
		function createTabe(){
			var row,cell;
			
			//标题的遍历
			var jsonCount=1;

			//循环遍历创建表格
			for(var i=0;i<pageSize+1;i++){
				row =tab.insertRow(-1);
				//循环第一行标题
				if(jsonCount>0){
					for(var j=0;j<jsonColumn.length;j++){
						cell = row.insertCell(-1);
						cell.innerHTML=jsonColumn[j];
					}
					jsonCount--;
				}else{
					for(var j=0;j<jsonColumn.length;j++){
						cell = row.insertCell(-1);
						cell.innerHTML=Mvalue;
						if(emptyClick){
							cell.onclick=function(){
								emptyClick(this);
								// console.log(this);
								// if(this.innerHTML==" "){
								// 	//insert(this.cellIndex+""+this.parentNode.rowIndex-1);
								// 	//alert(this.cellIndex+""+this.parentNode.rowIndex-1);
								// }else{
									
								// }
							}
								
								
						}
						
					}
				}
			}
			
			// cell.rowSpan=2;
			for(var i=0;i<2;i++){
				row =tab.insertRow(-1);
				cell = row.insertCell(-1);
				cell.colSpan=jsonColumn.length;
				cell.innerHTML=1;
			}

			if(leftNumber){
				//左侧第一列
				for(var j=1;j<pageSize+1;j++){
					tab.rows[j].cells[0].innerHTML=j;
				}
			}
			
		}
	
		

		//初始化数据
		initData(datas);
		function initData(_datas){
			datas=_datas;
			//定义json数据
			var jsonData = _datas[pageArgs.data];
			//当前的页数
			var pageIndex =_datas[pageArgs.pageIndex];
			//总的数目
			var totalRecord = _datas[pageArgs.totalRecord];
			//一共多少页
			var totalPage = _datas[pageArgs.totalPage];
			var row,cell;
			
			
	
			for(var i=0;i<jsonData.length;i++){
				//越过第0行，从第一行插入数据
				row = tab.rows[i+1];
				for(var j=0;j<varValue.length;j++){
					var jcolumn=j;
					if(leftNumber){
						jcolumn+=1;
					}

					row.cells[jcolumn].innerHTML=jsonData[i][varValue[j]];
				}
				var operation="<a onclick='deleteF("+jsonData[i].id+")'>删除</a><a onclick=updateF("+jsonData[i].id+")>更新</a>";
				row.cells[jsonColumn.length-1].innerHTML=operation;

			}	
			// for(var i=0;i<jsonData.length;i++){
				
			// 	//越过第0行，从第一行插入数据
			// 	row = tab.rows[i+1];
			// 	row.cells[jsonColumn.length-1].innerHTML=operation;

			// 	// for(var j=0;j<varValue.length;j++){
			// 	// 	var jcolumn=j;
			// 	// 	if(leftNumber){
			// 	// 		jcolumn+=1;
			// 	// 	}

			// 	// 	row.cells[jcolumn].innerHTML=jsonData[i][varValue[j]];
			// 	// }
			// 	// console.log(jsonData[i]['classroomName']);
			// }

			//清空数据
			if(jsonData.length<pageSize){
				for(var i=jsonData.length+1;i<pageSize+1;i++){
					
					row = tab.rows[i];
					var deleteColum;
					if(leftNumber){
						for(var j=1;j<jsonColumn.length;j++){
							row.cells[j].innerHTML="&nbsp;";
						}
					}else{
						for(var j=0;j<jsonColumn.length;j++){
							row.cells[j].innerHTML="&nbsp;";
						}
					}

					
				}
			}


			//初始化分页信息
			var pageInfo="一共有["+totalRecord+"]条记录-一共有["+totalPage+"]页-当前是第["+pageIndex+"]页-一页显示["+pageSize+"]页"; 
			row = tab.rows[pageSize+1].cells[0].innerHTML=pageInfo;
			//初始化分页操作
			row = tab.rows[pageSize+2].cells[0].innerHTML=pageOperation();
			//分页操作
			function pageOperation(){
				var pageOperation;
				if(pageIndex==1){
					pageOperation="<a onclick='jump(1)'>首页</a>"+
									"<a onclick='jump("+(pageIndex+1)+")'>下一页</a> <a onclick='jump("+totalPage+")'>尾页</a>";
				
				}else if(1<pageIndex&&pageIndex< totalPage){

					pageOperation="<a onclick='jump(1)'>首页</a> <a onclick='jump("+(pageIndex-1)+")'>上一页</a> "+
									"<a onclick='jump("+(pageIndex+1)+")'>下一页</a> <a onclick='jump("+totalPage+")'>尾页</a>";
				
				}else{
					pageOperation="<a onclick='jump(1)'>首页</a> <a onclick='jump("+(pageIndex-1)+")'>上一页</a> "+
									" <a onclick='jump("+totalPage+")'>尾页</a>";
				
				}
				
				return pageOperation;
			}

			
		}

		//删除
		function deleteF(_args){
			alert(_args);	
			$.ajax({
				url:"classroom_delete?id="+_args,
				success:function(result){
						jump(datas.pageIndex);
						// datas=eval(result);
						// initData(JSON.parse(result));
						// console.log(JSON.parse(result));
						// alert(jsonData[0].classroomName);
						// $("#div1").html(result);
						// initData(_datas);
					}
				})
		}
		//更新
		function updateF(_args){
			// alert(_args);	
			$.get("classroom_updateInput",function(data){
			// alert(data);
				$(".c_body").html(data);
			})  
			// getHtml("");
			// $.ajax({
			// 	url:"classroom_delete?id="+_args,
			// 	success:function(result){
			// 			jump(datas.pageIndex);
			// 			// datas=eval(result);
			// 			// initData(JSON.parse(result));
			// 			// console.log(JSON.parse(result));
			// 			// alert(jsonData[0].classroomName);
			// 			// $("#div1").html(result);
			// 			// initData(_datas);
			// 		}
			// })
		}
		//ajax获取数据
		function jump(_p){
			$.ajax({
				url:"classroom_findAjax?pageIndex="+_p,
				success:function(result){
					// datas=eval(result);
					initData(JSON.parse(result));
					console.log(JSON.parse(result));
					// alert(jsonData[0].classroomName);
					// $("#div1").html(result);
					// initData(_datas);
				}
			});
			window.history.pushState({},0,"classroom_find?pageIndex="+_p);
		}

        // pageList({
		// 		objList:${ classroom},
		// 		tabId:"tab",//哪一个table
		// 		column:3,//有几列
		// 		pageRow:20,//有几行
		// 		startRow:2,//从哪一行开始
		// 		infoId:"info",
		// 		pageButId:"fpage",
		// 		url:"course.admin?method=_list",
		// 		columnName:["classroomNameId","classroomName","describe"]
		// 	});
    </script>
    


</html>
