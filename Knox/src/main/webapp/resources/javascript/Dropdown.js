console.log("hello from morten");

var DropDownElements = [];

var STATUS = {
    HIDDEN: 0,
    SHOWN: 1,
}

function DropDown(id) {
    var dropdown = GetDropDownElementByID(id);

    if (dropdown.Status === STATUS.HIDDEN) {
        DropDown_Open(dropdown);
    } else {
        DropDown_Close(dropdown);
    }
}

function DropDown_Open (dropdownelement) {
    if (dropdownelement.onOpen) {
        dropdownelement.onOpen();
    }
    dropdownelement.Status = STATUS.SHOWN;
    dropdownelement.HTMLElement.style.maxHeight = dropdownelement.Height;
}
function DropDown_Close (dropdownelement) {
    if (dropdownelement.onClose) {
        dropdownelement.onClose();
    }
    dropdownelement.Status = STATUS.HIDDEN;
    dropdownelement.HTMLElement.style.maxHeight = "0";
}


function InitiateDropDown (id, wrapper_id) {
    console.log("ID:" + id);
    var HtmlElement = document.getElementById(id);
    var WrapperHtmlElement = document.getElementById(wrapper_id);
    console.log(HtmlElement);
    var height = HtmlElement.offsetHeight;
    var DropDownElement = {
        HTMLElement: HtmlElement,
        Height: height,
        Status: STATUS.HIDDEN,
        Wrapper: WrapperHtmlElement,
        onOpen: null,
        onClose: null
    }
    console.log(DropDownElement);
    DropDownElements.push(DropDownElement);
    DropDownElement.HTMLElement.style.overflow = "hidden";
    DropDownElement.HTMLElement.style.maxHeight = "0";
    DropDownElement.HTMLElement.style.transition = "max-height 0.2s";
    return DropDownElement;
}

function GetDropDownElementByID (id) {
    for (var i = 0; i < DropDownElements.length; i ++){
        var Element = DropDownElements[i];
        if (id === Element.HTMLElement.id){
            return Element;
        }
    }
}
$(document).click(function(event) {
    var pressedElement = event.target;
    for (var i = 0; i < DropDownElements.length; i ++){
        var DropDownElement = DropDownElements[i];
        if (DropDownElement.Status === STATUS.SHOWN){
            if (!DropDownElement.Wrapper.contains(pressedElement)){
                DropDown_Close(DropDownElement);
            }
        }
    }

    console.log(event.target);
});