function PostCall (functionName, parameters, callBack) {

    var json = JSON.stringify(parameters);


    console.log(json);
    $.ajax({
        type: "POST",
        url: "api/" + functionName,
        contentType: "application/json",
        data: json,
        success: function (returnValue) {
            console.log("success");
            console.log(returnValue);

            callBack(returnValue);
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            console.log (XMLHttpRequest);
            alert("Request: " + XMLHttpRequest.toString() + "\n\nStatus: " + textStatus + "\n\nError: " + errorThrown);
        }
    });
}

function GetRequest(searchQuery,searchOptions, callBack) {
    $.ajax({
        type: "GET",
        url: "127.0.0.1:8081/api/" + "search?input="+searchQuery + "&sources=" + searchOptions,
        success: function (returnValue) {
            console.log("success");
            console.log(returnValue);

            callBack(returnValue);
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            console.log (XMLHttpRequest);
            alert("Request: " + XMLHttpRequest.toString() + "\n\nStatus: " + textStatus + "\n\nError: " + errorThrown);
        }
    });
}

