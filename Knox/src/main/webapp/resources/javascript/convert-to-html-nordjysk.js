function converttohtml(input){

    var article = JSON.parse(input);
    console.log(article);

    console.log("this is the converter");
    console.log(article.articletext)
    document.getElementById("Title").innerHTML = article.title;
    document.getElementById("SubTitle").innerHTML = article.subtitle;
    document.getElementById("Author").innerHTML = article.author;
    document.getElementById("Date").innerHTML = article.date;
    document.getElementById("ArticleText").innerHTML = article.articleText;



    for(var i=0; i<article.images.length; i++){
        var para = document.createElement("img");
        para.src = article.images[i];
        var element = document.getElementById("Pictures");
        element.appendChild(para);
    }



/*
    document.getElementById("Picture0").src= article.images[0];
    document.getElementById("Picture1").src= article.images[1];
    document.getElementById("Picture2").src= article.images[2];
    document.getElementById("Picture3").src= article.images[3];
    document.getElementById("Picture4").src= article.images[4];

*/
}