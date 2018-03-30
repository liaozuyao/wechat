$("#updatepasswd").click(function () {
    var password = $("#password").val();
    var confirmpasswd = $("#confirmpassword").val();
    $.post("updateContactPassword",{
        'password' : password,
        'confirmPassword' : confirmpasswd
    }, function (data) {
        if(data.code == 200){
            alert(data.msg);
            window.location.href = "customerLogin.html";
        }
        alert(data.msg);
    })
})
$("#back-icon").click(function () {
    window.history.go(-1);
})
$("#reset").click(function () {
    $("#password").val("");
    $("#confirmpassword").val("");
})