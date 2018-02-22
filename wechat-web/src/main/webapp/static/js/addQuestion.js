$.ajax({
    url : 'getAllField',
    type : 'GET',
    success : function (result) {
        var dom = document.getElementById("field");
        var info = "<option value='0'>"+"--请选择(必填)--"+"</option>";
        for(var i = 0;i<result.data.length;i++){
            info += "<option value="+ result.data[i].id +">"+result.data[i].name+"</option>";
        }
        dom.innerHTML = null;
        dom.innerHTML = info;
    }
})

$.ajax({
    url : 'getAllUrgent',
    type : 'POST',
    success : function (result) {
        var dom = document.getElementById("urgent");
        var info = "<option value='0'>"+"--请选择(必填)--"+"</option>";
        for(var i = 0;i<result.data.length;i++){
            info += "<option value="+ result.data[i].id +">"+result.data[i].name+"</option>";
        }
        dom.innerHTML = null;
        dom.innerHTML = info;
    }
})

$.ajax({
    url : 'getAllByType',
    type : 'POST',
    data : {type: 7},
    success : function (result) {
        var dom = document.getElementById("adviser");
        var info = "<option value='0'>"+"--请选择(必填)--"+"</option>";
        for(var i = 0;i<result.data.length;i++){
            info += "<option value="+ result.data[i].id +">"+result.data[i].name+"</option>";
        }
        dom.innerHTML = null;
        dom.innerHTML = info;
    }
})