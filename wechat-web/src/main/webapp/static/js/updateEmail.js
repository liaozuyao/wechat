$(document).ready(function(){
    $.ajax({
        url:'getAdviserInfo',
        type:'GET',
        success:function (result) {
            $("#email").val(result.data.mail);
        }
    })
})
$("#reset").click(function(){
    $("#email").val("");
})
$("#back-icon").click(function () {
    window.history.go(-1);
})
$("#updateEmail").click(function(){
    var email = $("#email").val();
    $.get("updateAdvOrDevMail",{
        'mail' : email
    },function (data) {
        if(data.code == 200){
            alert(data.msg);
            window.location="adviserAndDevlpMain.html";
        } else {
            alert(data.msg);
        }
    })
})