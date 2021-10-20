function convertNordjyskeToHtml(input) {

    var articles = JSON.parse(input);
    var articleElement = [];
    console.log(articles);

    console.log("this is the converter");

    /*document.getElementById("Title").innerHTML = article.title;
    document.getElementById("SubTitle").innerHTML = article.subtitle;
    document.getElementById("Author").innerHTML = article.author;
    document.getElementById("Date").innerHTML = article.date;
    document.getElementById("ArticleText").innerHTML = article.articleText;
*/
    for (var i = 0; i < articles.length; i++) {
        var article = articles[i];
        // Create Link
        var returnElement = document.createElement("a");
        returnElement.classList.add("button_link");
        returnElement.classList.add("searchResult");
        returnElement.href = "/knox/grundfos/search?article=";
        // Create Wrapper
        var wrapper = document.createElement("div");
        returnElement.appendChild(wrapper);
        // Create Title
        var title = document.createElement("h1");
        title.innerHTML = article.documentTitle;
        title.classList.add("articletitle");
        wrapper.appendChild(title);
        // Create Passage
        var passage = document.createElement("h2");
        passage.innerHTML = article.passage;
        passage.classList.add("articlepassage");
        wrapper.appendChild(passage);
        // Create Document
        var documentname = document.createElement("p");
        documentname.innerHTML = article.sourceDocument;
        documentname.classList.add("articledocument");
        wrapper.appendChild(documentname);
        // Create Score
        var score = document.createElement("p");
        score.innerHTML = article.score;
        score.classList.add("articlescore");
        wrapper.appendChild(score);

        articleElement.push(returnElement)

    }
    return articleElement;


    /*
    var j = 0;
    var para;
    var node;
    var element;

    para = document.createElement("div");
    para.setAttribute("id", "div"+j)
    document.body.appendChild(para);


    para = document.createElement("h1");
    node = document.createTextNode(article.title);
    para.appendChild(node);
    element = document.getElementById("div"+j);
    element.appendChild(para);


    para = document.createElement("h2");
    node = document.createTextNode(article.subtitle);
    para.appendChild(node);
    element = document.getElementById("div"+j);
    element.appendChild(para);


    para = document.createElement("p");
    node = document.createTextNode(article.author);
    para.appendChild(node);
    element = document.getElementById("div"+j);
    element.appendChild(para);


    para = document.createElement("p");
    node = document.createTextNode(article.date);
    para.appendChild(node);
    element = document.getElementById("div"+j);
    element.appendChild(para);


    para = document.createElement("p");
    node = document.createTextNode(article.articleText);
    para.appendChild(node);
    element = document.getElementById("div"+j);
    element.appendChild(para);


    for(var i=0; i<article.images.length; i++){
        para = document.createElement("img");
        para.src = article.images[i];
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