$("#reset").click(function () {
    $("#name").val("");
    $("#password").val("");
})
$("#customerLogin").click(function () {
    var username = $("#name").val();
    var password = $("#password").val();
    if(username == "" || password == ""){
        alert("请正确填写账号密码");
        return;
    }
    $.post("accountLogin",{
        'account' : username,
        'password' : password
    }, function (data) {
        if(data.code == 200){
            window.location="customerMain.html";
        } else {
            alert(data.msg);
        }
    })
})