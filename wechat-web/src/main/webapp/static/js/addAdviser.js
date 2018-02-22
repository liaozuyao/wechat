$("#reset").click(function () {
    $("#name").val("");
    $("#phone").val("");
    $("#email").val("");
    $("#type").val("");
})
$("#back-icon").click(function () {
    window.location.href ="adminMain.html";
});
$("#commitAdvDev").click(function () {
    var name = $("#name").val();
    var phone = $("#phone").val();
    var email = $("#email").val();
    var type = $("#type").val();
    if(type == 9){
        alert("请选择开发/实施");
        return;
    }
    $.post("insertAdviser", {
        'name' : name,
        'phone' : phone,
        'email' : email,
        'type' : type
    }, function (data) {
        if(data.code == 200){
            alert(data.msg);
            location.reload();
        } else {
            alert(data.msg);
        }
    })
})