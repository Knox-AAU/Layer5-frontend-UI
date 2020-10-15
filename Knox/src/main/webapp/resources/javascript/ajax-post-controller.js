function PostCall (functionName, search) {
    var json = JSON.stringify({search:search});
    console.log(json);
    $.ajax({
        type: "POST",
        url: "/knox/api/" + functionName,
        contentType: "application/json",
        data: json,
        success: function (returnValue) {
            console.log("success");
            console.log(returnValue);
            if(functionName == "nordjysksearch") {
                converttohtml(returnValue);
            }
            else{
                converttoHtml(returnValue);
            }
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            console.log (XMLHttpRequest);
            alert("Request: " + XMLHttpRequest.toString() + "\n\nStatus: " + textStatus + "\n\nError: " + errorThrown);
        }
    });
}