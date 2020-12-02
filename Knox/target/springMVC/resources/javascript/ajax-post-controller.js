function PostCall (functionName, parameters) {
    parameters = [name, value];
    search = parameters;
    var json = JSON.stringify({search:search});

    console.log(json);
    $.ajax({
        type: "POST",
        url: "api/" + functionName,
        contentType: "application/json",
        data: json,
        success: function (returnValue) {
            console.log("success");
            console.log(returnValue);

            if(functionName == "nordjyskesearch") {
                convertNordjyskeToHtml(returnValue);
            }
            else if (functionName == "grundfossearch") {
                convertGrundfosToHtml(returnValue);
            }

        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            console.log (XMLHttpRequest);
            alert("Request: " + XMLHttpRequest.toString() + "\n\nStatus: " + textStatus + "\n\nError: " + errorThrown);
        }
    });
}






/* Search skal udskiftes med et parameter der består af elementer; navn og værdi.

*  Vi skal tilføje en eventlistener der kan separere metode kald mellem to filer

*  Eventlistener kan gøres således den tager  3 parametere; navnet på function, en function,  liste af  parametre
  en function might be
*  called  callBack
*
* */


