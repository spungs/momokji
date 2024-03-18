$(document).ready(() => {
    /********** 뭐하지 아이콘 mouseOver EventHandler **********/
    let bannerEvent = $(".bannerEvent");

    bannerEvent.mouseover(() => {
        let i = document.getElementById("whatImg");
        let c = document.getElementById("categoryBtn");

        c.style.top = String(i.getBoundingClientRect().bottom - 18 + window.scrollY) + "px";
        // c.style.top = String(c.style.top - 18) + "px";
        c.style.left = (i.getBoundingClientRect().left + 1 + window.scrollX) + "px";

        $("#categoryList").css("display", "block");
    });

    bannerEvent.mouseout(() => {
        $("#categoryList").css("display", "none");
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

        loginBanner.style.display = "inline-block";
    });

    bannerEvent2.mouseout(() => {
        document.getElementById("loginBanner").style.display = "none";
    });
});

