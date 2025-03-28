document.addEventListener('DOMContentLoaded', function () {


    var fordeCoordinates = [61.4521, 5.8566];
    var zoomLevel = 12; // Adjust zoom level as necessary


    var map = L.map('map').setView(fordeCoordinates, zoomLevel);


    L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
        attribution: '&copy; OpenStreetMap contributors'
    }).addTo(map);

    var markerCoordinates = [61.458024, 5.897591];
    var marker = L.marker(markerCoordinates).addTo(map);
    marker.bindPopup("<b>Returpunkt Tervatunet </b><br>Dette er en returpunkt.").openPopup();

    var markerCoordinates = [61.459275, 5.888901];
    var marker = L.marker(markerCoordinates).addTo(map);
    marker.bindPopup("<b>Returpunkt HVL </b><br>Dette er en returpunkt.").openPopup();
    ;})






