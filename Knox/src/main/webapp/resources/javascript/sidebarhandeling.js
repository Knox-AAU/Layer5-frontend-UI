var sidebar_wrapper = document.querySelector(".sidebar_wrapper");
var CheckingSidebarScroll = false;
$(document).ready(function () {
    sidebar_wrapper = document.querySelector(".sidebar_wrapper");
});

$(window).scroll(function() {
    if (sidebar_wrapper && !CheckingSidebarScroll) {
        CheckingSidebarScroll = true;
        CheckSidebarScroll ();
    }

});
function CheckSidebarScroll (){
    var body = document.querySelector("body")
    var scrollTop = body.scrollTop;
    var clientHeight = body.clientHeight;
    var scroll = scrollTop + clientHeight - 60;
    var sidebarheight = sidebar_wrapper.offsetHeight;
    if (scroll > sidebarheight && clientHeight < sidebarheight){
        if (sidebar_wrapper.style.position !== "fixed"){
            sidebar_wrapper.style.position = "fixed";
            sidebar_wrapper.style.bottom = "0";
        }

    } else {
        sidebar_wrapper.style.position = "";
    }
    setTimeout(function () {CheckingSidebarScroll = false;}, 50);
}