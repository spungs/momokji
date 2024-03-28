/* right clicked */
let rc = false;

/* kakao map ref */

$(document).ready(() => {
    $(document).on("click", () => {
        if (rc) {
            document.getElementById("rightClickWrapper").style.display = "none";

            rc = !rc;
        }
    });

    $("#map").on('mousedown', function() {
        if ((event.button === 2)||(event.which === 3)) {
            let w = document.getElementById("rightClickWrapper");

            w.style.left = String(event.clientX) + "px";
            w.style.top = String(event.clientY + 10) + "px";
            w.style.display = rc ? "none" : "block";

            rc = !rc;
        }
    });

    $("#rightClickWrapper").on("click", () => {
        setCurPosition();
    });
});

function setCurPosition() {
    kakao.maps.event.addListener(map, 'click', function(mouseEvent) {
        let latlng = mouseEvent.latLng;
        let lat = latlng.getLat();
        let lng = latlng.getLng();

        var marker = new kakao.maps.Marker({
            map: map,
            position: new kakao.maps.LatLng(lat, lng)
        });
    });
}