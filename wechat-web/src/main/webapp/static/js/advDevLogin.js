$("#reset").click(function () {
    $("#name").val("");
    $("#password").val("");
})
$("#addAdvOrDev").click(function () {
    var name = $("#name").val();
    var password = $("#password").val();
    $.post("adviserOrDevlpLogin", {
        'phone': name,
        'password': password
    }, function (data) {
        if (data.code == 200) {
            window.location="adviserAndDevlpMain.html";
        } else {
            alert(data.msg);
        }
    })
})