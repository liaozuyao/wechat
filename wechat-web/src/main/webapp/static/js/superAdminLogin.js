$(document).ready(function () {
    $(".btn").click(function () {
        var username = $("#username").val();
        var password = $("#password").val();
        if(username == "" || password == ""){
            alert("请填写账号密码");
        } else {
            $.post("superAdminLogin",{
                account : username,
                password : password
            }, function (data) {
                if(data.code == 200){
                    window.location.href ="adminMain.html";
                } else {
                    alert(data.msg);
                }
            })
        }
    })
})