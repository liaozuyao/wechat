$("#reset").click(function(){
    $("#password").val("");
    $("#confirmpassword").val("");
})
$("#back-icon").click(function () {
    window.history.go(-1);
})
$("#updatepasswd").click(function(){
    var password = $("#password").val();
    var confirmpassword = $("#confirmpassword").val();
    $.get('updateAdviserPassword',{
        'password':password,
        'confirmpassword':confirmpassword
    },function(data){
        if(data.code == 205){
            alert(data.msg);
            window.location = "adviserOrDevlpLogin.html";
        } else if(data.code == 200){
            alert(data.msg);
            window.location = "adviserAndDevlpMain.html";
        } else {
            alert(data.msg);
        }
    })
})