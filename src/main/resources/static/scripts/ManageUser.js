/**
 * Created by asus on 2017/6/23.
 */

   $(document).ready(function(){
       var select = $("#sel1");
       var thisYear = new Date().getFullYear();
       for(var i=thisYear;i>=1940;i--){
           var sed = thisYear==i?"selected":"";
           var dayStr = "<option value=\"" + i + "\" "+sed+">" + i + "</option>";
           select.append(dayStr);
       }
       domoth();
       select.change(
           function () {
               $("#sel2").empty();
               $("#sel3").empty();
               domoth();
           }
       );
   });
function domoth(){
    var thisYear = new Date().getMonth()+1;
    var select = $("#sel2");
    for(var i=1;i<=12;i++){
        if ($("#sel1").val() == new Date().getFullYear()){
            var sed = thisYear==i?"selected":"";
        }
        var dayStr = "<option value=\"" + i + "\" "+sed+">" + i + "</option>";
        select.append(dayStr);
    }
    doday();
    select.change(
        function () {
            $("#sel3").empty();
            doday();
        }
    );
}

function doday(){
    var select =  $("#sel3");
    var year = $("#sel1").val();
    var month = $("#sel2").val();
    var thisYear = new Date().getDate();
    var dayCount = thisYear;
    if (month == 4 || month == 6 || month == 9 || month == 11){
        dayCount = 30;
    }else if(month == 2){
        if ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0)) {
            dayCount = 29;
        }else {
            dayCount = 28;
        }
    }else {
        dayCount = 31;
    }

    for (var i = 1; i <= dayCount; i++) {
        if ($("#sel1").val() == new Date().getFullYear()){
            var sed = thisYear==i?"selected":"";
        }
        var dayStr = "<option value=\"" + i + "\" "+sed+">" + i + "</option>";
            select.append(dayStr);
    }
}


