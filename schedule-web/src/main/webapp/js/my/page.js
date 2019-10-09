var getData;
function pageList(_obj)
{
    var obj = _obj;
    

    var objList = eval(obj.objList);
    var pageSize=obj.pageRow;
    var tab = document.getElementById(obj.tabId);
    var cells = obj.column;

    console.log(objList.list);

    //创建表格
    createtable();
    function createtable()
    {
        var row,cell;
        //循环遍历创建表格
        for(var i=0;i<pageSize;i++)
        {
            row =tab.insertRow(obj.startRow);
            for(var j=0;j<cells;j++){
                cell = row.insertCell(-1);
                cell.innerHTML="&nbsp;";
            }
    
        }
    }	
    
    initData(objList);
    //初始化数据
    function initData(data){
        var oo=data.data;
        console.log("用户个数"+oo.length);
        for(var i=0;i<oo.length;i++){
            //从第二行开始更新数据
            var row=tab.rows[i+obj.startRow];
            for(var j=0;j<obj.columnName.length;j++){
                var objValue;
                if(obj.columnName[j].indexOf("|") != -1 ){
                    var twoName = obj.columnName[j].split("|");
                    objValue=oo[i][twoName[0]][twoName[1]];
                }else{
                    objValue = oo[i][obj.columnName[j]];
                }
            
            	if(objValue){
            		row.cells[j].innerHTML= objValue;
            	}else{
            		row.cells[j].innerHTML="";
            	}
                
            }
         /*   row.cells[0].innerHTML=oo[i].id;
            row.cells[1].innerHTML=oo[i].name;
            row.cells[2].innerHTML="2";
            row.cells[3].innerHTML="3";
            row.cells[4].innerHTML="4";
            row.cells[5].innerHTML="5";
            row.cells[6].innerHTML="6";
            row.cells[7].innerHTML="7";
            row.cells[8].innerHTML="8";*/
        }
        if(oo.length<pageSize){
            for(var i=oo.length;i<pageSize;i++){
                for(var j=0;j<cells;j++){
                    tab.rows[i+2].cells[j].innerHTML="&nbsp";
                }
            }
        }
        $("#"+obj.infoId).html(data.info);
        $("#"+obj.pageButId).html(data.page);
    }
    //从服务器获取数据
    getData=function(cp)
    {
        $.ajax({
            type:"GET",
            url:obj.url+"&cp="+cp,
            //dataType:"json",
            success:function(data,statu, xhr){
                //userList=data;
                console.log(data);
                initData(data);
                window.history.pushState({},0,obj.url.replace("_","")+"&cp="+cp);
            },

        });
    }
}