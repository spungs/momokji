$(document).ready(() => {
    let bannerEvent = $(".bannerEvent");

    bannerEvent.mouseover(() => {
        let i = $("#whatImg");
        let c = $("#categoryBtn");

        c.style.top = String(i.getBoundingClientRect().bottom - 18) + "px";
        // c.style.top = String(c.style.top - 18) + "px";
        c.style.left = (i.getBoundingClientRect().left + 1) + "px";

        $("#categoryList").css("display", "block");
    });

    bannerEvent.mouseout(() => {
        $("#categoryList").css("display", "none");
    });

/*
    let bannerEvent2 = $("#bannerEvent2");

    bannerEvent2.mouseover(() => {
        let l = $("#loginBtn");
        let b = $("#loginBanner");

        b.style.top = String(l.getBoundingClientRect().bottom + 18) + "px";
        b.style.left = String(l.getBoundingClientRect().left - 18) + "px";

        $("#loginPlatformList").style("display", "block");
    });

    bannerEvent2.mouseout(() => {
        $("#loginPlatformList").css("display", "none");
    });

    $("#loginBtn").mouseup(() => {

    });
*/

    $("#headerLogoText").on("click", () => {
        location.href = "/";
    });
});

