console.log("hello from morten");

function DropDown(id) {
    var dropdown = document.getElementById(id);
    if (dropdown.classList.contains("dropdownopen")){
        dropdown.classList.remove("dropdownopen");
        dropdown.classList.add("dropdownclosed");
    } else {
        dropdown.classList.add("dropdownopen");
        dropdown.classList.remove("dropdownclosed");}}
