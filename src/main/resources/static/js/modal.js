var modalCloseButton;
var wrapper = document.createElement("div");

export default function setModalAsPopup(data){
    wrapper.classList.add("modal-wrapper");
    wrapper.innerHTML = data;
    document.body.appendChild(wrapper);

    modalCloseButton = wrapper.querySelector(".modal-close i");

    closeButtonClickEvent();
    modalWrapperClickEvent();
}

function closeButtonClickEvent(){
    modalCloseButton.onclick = () => {
        removeModal();
    }
}

function modalWrapperClickEvent(){
    window.onclick = (evt) => {
        if(evt.target == wrapper){
            removeModal();
        }
    }
}

function removeModal(){
    document.body.removeChild(wrapper);
}

