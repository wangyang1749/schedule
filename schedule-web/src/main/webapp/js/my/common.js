function createTable(_obj){
    var myRow=_obj.totalRow;
    var json=_obj.title;
    var tab = document.getElementById("tab");
    //初始化表格
    createtable();
	function createtable(){
        var row,cell;
        var jsonColumn=json;
        var jsonCount=1;
        //获取时间个数，也就是表格的行数
        // var ctime = data[0];
        //循环遍历创建表格
        for(var i=0;i<myRow;i++){
            row =tab.insertRow(-1);
            //循环第一行标题
            if(jsonCount>0){
                for(var j=0;j<json.length;j++){
                    cell = row.insertCell(-1);
                    cell.innerHTML=json[j];
                    jsonCount--;
                }
            }else{
                for(var j=0;j<json.length;j++){
                    cell = row.insertCell(-1);
                    cell.innerHTML="";
                    cell.onclick=function(){
                        if(this.innerHTML==" "){
                            //insert(this.cellIndex+""+this.parentNode.rowIndex-1);
                            //alert(this.cellIndex+""+this.parentNode.rowIndex-1);
                        }else{
                            //alert(this.innerHTML);
                        }
                    }
                }
            }
        }
        //左侧第一列
        for(var j=1;j<myRow;j++){
            tab.rows[j].cells[0].innerHTML=j;
        }
    }
}