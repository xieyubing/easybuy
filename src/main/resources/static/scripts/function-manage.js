// JavaScript Document
function DeleteUser(id)
{
	if(confirm("确定要删除吗？")) {
	   location.href="/user/DeleteUser?id="+id;
	}
}

function DeleteNews(id) {
    if (confirm("确定要删除吗？")){
        location.href="/news/DeleteNews?id="+id;
    }
}

function DeleteComment(id)
{
    if(confirm("确定要删除吗？")) {
        location.href="/user/DeleteComment?id="+id;
    }
}
function DeleteOrder(id) {
    if (confirm("确认要删除吗？")){
        location.href="/order/DeleteOrder?id="+id;
    }
}

function DeleteProduct(id) {
    if (confirm("确认要删除吗？")){
        location.href="/product/DeleteProduct?id="+id;
    }
}

window.onload=time;
function time(){
    var date=new Date();
    if ($("#date")){
        $("#date").innerHTML=date.getFullYear()+"年"+(date.getMonth()+1)+"月"+date.getDate()+"日";
    }
}

function addShopping(id) {
    $.ajax({
        url:"/user/addShopping",
        type:"post",
        data:"id="+id,
        success:function (date) {
           if (date.count>0){
               alert("添加成功")
           }
        },
        error: function(){
            alert("操作失败！");
        }
    });
}

function addProduct(obj) {
    var id = $(obj).attr("name");
    $.ajax({
        url:"/user/addShopping",
        type:"post",
        data:"id="+id,
        success:function (date) {
            $(obj).prev().val(date.count);
        },
        error: function(){
            alert("操作失败！");
        }
    });
}
function delProduct(obj) {
    var id = $(obj).attr("name");
    $.ajax({
        url:"/user/delShopping",
        type:"post",
        data:"id="+id,
        success:function(date){
            $(obj).parents("tr").remove();
        },
        error: function(){
            alert("操作失败！");
        }
    });
}

function reduceProduct(obj) {
    var id = $(obj).attr("name");
    $.ajax({
        url:"/user/reduceShopping",
        type:"post",
        data:"id="+id,
        success:function (date) {
            if (date.count>0){
                $(obj).next().val(date.count);
            }else {
                $(obj).parents("tr").remove();
            }
        },
        error: function(){
            alert("操作失败！");
        }
    });
}

function goBuy() {
    setTimeout("location.href='/order/toShoppingResult'", 1000);
}
