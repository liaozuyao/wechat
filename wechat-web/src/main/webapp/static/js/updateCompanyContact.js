$("#reset").click(function () {
    $("#name").val("");
    $("#phone").val("");
    $("#mail").val("");
})
$("#updateInfo").click(function () {
    var name = $("#name").val();
    var phone = $("#phone").val();
    var mail = $("#mail").val();
    $.post("updateCompanyContact", {
        'name' : name,
        'phone' : phone,
        'mail' : mail
    }, function (data) {
        alert(data.msg);
    })
})
$("#back-icon").click(function () {
    window.location = "customerMain.html";
})