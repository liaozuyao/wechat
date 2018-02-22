$.ajax({
    url : "getAllField",
    type : "GET",
    success : function (result) {
        var dom = document.getElementById("tbody");
        var info = "";
        for(var i = 0; i<result.data.length; i++){
            info += "<tr id=" + result.data[i].id + "><td>" + result.data[i].name + "</td><td>" +
                "<a class='update' id=" + result.data[i].id + " style='margin-left:-25px; color:blue' href='#'>修改</a>&nbsp;&nbsp;" +
                "<a class='delete' id=" + result.data[i].id + " style='margin-left: 20px; color:red' href='#'>删除</a></td></tr>";
        }
        dom.innerHTML = null;
        dom.innerHTML = info;
    }
})