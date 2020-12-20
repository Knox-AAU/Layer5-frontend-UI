

function convertGrundfosToHtml(input){

    var manuals = JSON.parse(input).result;
    var manualElement = [];

    for(var i = 0; i < manuals.length; i++){
        var pdfpage = manuals[i];
        console.log(pdfpage);

        console.log("this is the converter");
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
        title.innerHTML = pdfpage.title;
        title.classList.add("articletitle");
        wrapper.appendChild(title);
        // Create SubTitle
        var score = document.createElement("h2");
        score.innerHTML = pdfpage.score;
        score.classList.add("score");
        wrapper.appendChild(score);
        // Create Author
        var filepath = document.createElement("p");
        filepath.innerHTML = pdfpage.filepath;
        filepath.classList.add("filepath");
        wrapper.appendChild(filepath);

        manualElement.push(returnElement);

    }
    console.log("manualElement: ");

    console.log(manualElement);
    return manualElement;

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