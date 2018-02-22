$("#commitInfo").click(function () {
    var name = $("#name").val();
    var code = $("#code").val();
    var contactPhone = $("#contactphone").val();
    var contactMail = $("#contactmail").val();
    $.post("updateComanyInfo", {
        'name': name,
        'code': code,
        'contactPhone': contactPhone,
        'contactMail': contactMail
    }, function (data) {
        if (data.code == 200) {
            alert(data.msg);
            window.location.reload();
        } else {
            alert(data.msg);
        }
    })
})
$("#back-icon").click(function () {
    window.location.href = "customerMain.html";
})
$("#reset").click(function () {
    $("#name").val("");
    $("#code").val("");
    $("#contactphone").val("");
    $("#contactmail").val("");
})