/**
 * Created by asus on 2017/6/22.
 */


function FocusItem(obj) {
    $(obj).siblings('span').css({display:"none"});
    $(obj).siblings('span').html("");
}

function CheckItem(obj) {
    if ($(obj).val()==""){
        $(obj).siblings('span').css({display:"inline"});
        $(obj).siblings('span').html($(obj).val()+"不能为空哦");
    }
}

function veryCodeImg() {
    $("#veryCode").attr("src","/user/getKaptchaImage");
}

function checkForm() {
    if ($('#passWord').val() != $('#rePassWord').val()){
            return false;
    }
    return true;
}
