

function convertGrundfosToHtml(input){

    var pdfpage = JSON.parse(input);
    console.log(pdfpage);

    console.log("this is the converter");

    /*document.getElementById("Title").innerHTML = article.title;
    document.getElementById("SubTitle").innerHTML = article.subtitle;
    document.getElementById("Author").innerHTML = article.author;
    document.getElementById("Date").innerHTML = article.date;
    document.getElementById("ArticleText").innerHTML = article.articleText;
*/

    var j = 0;
    var para;
    var node;
    var element;

    para = document.createElement("div");
    para.setAttribute("id", "div"+j)
    document.body.appendChild(para);


    para = document.createElement("h1");
    node = document.createTextNode(pdfpage.section);
    para.appendChild(node);
    element = document.getElementById("div"+j);
    element.appendChild(para);


    for(var i=0; i<pdfpage.subsections.length; i++){
        para = document.createElement("h2");
        node = document.createTextNode(pdfpage.subsections[i]);
        para.appendChild(node);
        element = document.getElementById("div"+j);
        element.appendChild(para);

        para = document.createElement("p");
        node = document.createTextNode(pdfpage.subsectioncontent[i]);
        para.appendChild(node);
        element = document.getElementById("div"+j);
        element.appendChild(para);
    }

    for(i=0; i<pdfpage.images.length; i++){
        para = document.createElement("img");
        para.src = pdfpage.images[i];
        element = document.getElementById("div"+j);
        element.appendChild(para);
    }
    j++;


    /* for(var i=0; i<article.images.length; i++){
        var para = document.createElement("img");
        para.src = article.images[i];
        var element = document.getElementById("Pictures");
        element.appendChild(para);
    }*/

}