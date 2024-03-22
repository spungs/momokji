var ISTOGGLED_CATEGORY = false;
var ISTOGGLED_LOGIN = false;

$(document).ready(() => {
    /********** 뭐하지 아이콘 mouseOver EventHandler **********/
    let bannerEvent = $(".bannerEvent");

    bannerEvent.mouseover(() => {
        let i = document.getElementById("whatImg");
        let c = document.getElementById("categoryBtn");

        c.style.top = String(i.getBoundingClientRect().bottom - 18 + window.scrollY) + "px";
        c.style.left = (i.getBoundingClientRect().left + 1 + window.scrollX) + "px";

        if (!ISTOGGLED_CATEGORY) {
            $("#categoryBtn").slideToggle();

            ISTOGGLED_CATEGORY = true;
        }
    });

    bannerEvent.mouseout(() => {
        if (ISTOGGLED_CATEGORY) {
            $("#categoryBtn").slideToggle();

            ISTOGGLED_CATEGORY = false;
        }
    });

    /********** Main Logo Click EventHandler **********/
    $("#headerLogoText").on("click", () => {
        location.href = "/";
    });

    /********** login Button mouseOver EventHandler **********/
    let bannerEvent2 = $(".bannerEvent2");

    bannerEvent2.mouseover(() => {
        let loginBanner = document.getElementById("loginBanner");
        let loginBtn = document.getElementById("loginBtn");

        loginBanner.style.top = String(loginBtn.getBoundingClientRect().bottom + window.scrollX) + "px";
        loginBanner.style.left = String(loginBtn.getBoundingClientRect().left + window.scrollY - 6) + "px";

        // loginBanner.style.display = "inline-block";
        $("#loginBanner").slideToggle();
    });

    bannerEvent2.mouseout(() => {
        // document.getElementById("loginBanner").style.display = "none";
        $("#loginBanner").slideToggle();
    });
});