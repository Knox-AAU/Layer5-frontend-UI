function converttohtml(input){

    var article = JSON.parse(input);
    console.log(article);

    console.log("this is the converter");
    console.log(article.articletext)
    document.getElementById("p1").innerHTML = article.title;
    document.getElementById("p2").innerHTML = article.subtitle;
    document.getElementById("p3").innerHTML = article.author;
    document.getElementById("p4").innerHTML = article.date;
    document.getElementById("p5").innerHTML = article.articletext;

}