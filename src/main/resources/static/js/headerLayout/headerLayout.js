window.onload = () => {}

$(document).ready(() => {
    let bannerEvent = $(".bannerEvent");

    bannerEvent.mouseover(() => {
        let i = document.getElementById("whatImg");
        let c = document.getElementById("categoryBtn");

        c.style.top = String(i.getBoundingClientRect().bottom - 18) + "px";
        c.style.left = (i.getBoundingClientRect().left + 1) + "px";

        $("#categoryList").css("display", "block");
    });

    bannerEvent.mouseout(() => {
        $("#categoryList").css("display", "none");
    });
});