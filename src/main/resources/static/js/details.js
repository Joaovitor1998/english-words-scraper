import setModalAsPopup from "./modal.js";

var word;

export default function addClickEvent(){
    let words = document.querySelectorAll(".word-container .word");
    for(var i = 0; i < words.length; i++){
        words[i].addEventListener("click", (evt) => {
            word = evt.target.innerText;
            searchWordAJAX(word);
        });
    }
}

function searchWordAJAX(word){
    let request = new XMLHttpRequest();
    
    request.onreadystatechange = function(){

        if(request.readyState === XMLHttpRequest.DONE){
            checkRequestStatus(request);
        }
    }

    request.open("GET", "http://localhost:8080/search/word/" + word, true);
    request.send();
}

function checkRequestStatus(request){
    if(request.status === 200){
        renderResponseSuccess(request);
    }
}

function renderResponseSuccess(request){
    let data = request.responseText;
    setModalAsPopup(data);
}
