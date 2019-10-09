 $.fn.timeTable = function(arguments) {
   var _self = this,
     colorArrays = ["#FF8B8B", "#61BFAD", "#E54B4B", "#32B67A", "#F0CF61", "#384D9D", "#0BBCD6", "#E29AAD"];

   _self.config = arguments || {};

   if (!_self.config.classNum) _self.config.classNum = "12";
   if (!_self.config.itemWidth) _self.config.itemWidth = "1.333"; /*rem*/
   if (!_self.config.itemHeight) _self.config.itemHeight = "1.36";


   drawTable();

   if (!_self.config.wlist) {
     return;
   }

   createClass(_self.config.wlist);

   function drawTable() {
     var timetable = document.createElement("table"),
       thead = document.createElement("thead"),
       tbody = document.createElement("tbody");

     thead.innerHTML = _self.config.title;
     var str = '';
     for (let i = 1; i <= _self.config.classNum; i++) {
       str += '<tr><td>' + i + '</td>';
       for (let j = 0; j < 7; j++) {
         str += '<td></td>';
       }
       str += '</tr>';
     }
     tbody.innerHTML = str;
     timetable.append(thead);
     timetable.append(tbody);
     _self[0].append(timetable);
     _self[0].className += "tabletime";
   }

   function createClass(list) {
     for (let i = 0; i < list.length; i++) {
       addClass(list[i]);
     }
   }

   function addClass(obj) {
     var w = _self.config.itemWidth,
       h = _self.config.itemHeight,
       cheight = (obj.durable * h).toFixed(3),
       topstart = (0.667 + (obj.classTime - 1) * h).toFixed(3),
       leftstart = (0.668 + (obj.week - 1) * w).toFixed(3);

     var iclass = document.createElement("div"),
       color = setColor();

     iclass.className += "classitem";
     iclass.innerHTML = obj.courseName || "";
     iclass.setAttribute("style", "height:" + cheight + "rem;top:" + topstart + "rem;left:" + leftstart + "rem;background-color:" + color);

     _self[0].append(iclass);
   }

   function setColor() {
     var num = randomNum(0, colorArrays.length);
     var color = colorArrays[num] || colorArrays[0];
     return color;
   }

   function randomNum(minNum, maxNum) {
     switch (arguments.length) {
       case 1:
         return parseInt(Math.random() * minNum + 1, 10);
         break;
       case 2:
         return parseInt(Math.random() * (maxNum - minNum + 1) + minNum, 10);
         break;
       default:
         return 0;
         break;
     }
   }
 };