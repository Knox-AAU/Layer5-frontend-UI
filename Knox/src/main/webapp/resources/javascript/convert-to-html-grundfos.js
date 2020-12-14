

function convertGrundfosToHtml(input){

    var pdfpage = JSON.parse(input);
    console.log(pdfpage);

    console.log("this is the converter");
    // Create Link
    var returnElement = document.createElement("a");
    returnElement.classList.add("button_link");
    returnElement.classList.add("searchResult");
    returnElement.href = "/knox/grundfos/search?article=" + pdfpage.uniqueId;
    // Create Wrapper
    var wrapper = document.createElement("div");
    returnElement.appendChild(wrapper);
    // Create Title
    var title = document.createElement("h1");
    title.innerHTML = pdfpage.title;
    title.classList.add("articletitle");
    wrapper.appendChild(title);
    // Create SubTitle
    var subTitle = document.createElement("h2");
    subTitle.innerHTML = pdfpage.subtitle;
    subTitle.classList.add("articlesub");
    wrapper.appendChild(subTitle);
    // Create Author
    var author = document.createElement("p");
    author.innerHTML = pdfpage.author;
    author.classList.add("author");
    wrapper.appendChild(author);
    // Create Date
    var date = document.createElement("p");
    date.innerHTML = pdfpage.date;
    date.classList.add("date");
    wrapper.appendChild(date);
    // Create Article Text
    var articleText = document.createElement("p");
    articleText.innerHTML = pdfpage.articleText;
    articleText.classList.add("articletext");
    wrapper.appendChild(articleText);

    return returnElement;

    /*
                <a href ="/knox/grundfos/search?article=${dummydata.key}" class="button_link searchResult">
                    <div >
                        <h1 id="articletitle">${dummydata.value.title} </h1>
                        <h2 id="articlesub">${dummydata.value.subtitle}</h2>
                        <p  id="author">${dummydata.value.author}</p>
                        <p  id="date">${dummydata.value.date}</p>
                        <p  id="articletext">${dummydata.value.articleText}</p>
                        <p  id="keywods">   </p>
                    </div>
                </a>

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