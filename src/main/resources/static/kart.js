document.addEventListener('DOMContentLoaded', function () {
    console.log('kart.js loaded');

    // Coordinates for Førde, Norway
    var fordeCoordinates = [61.4521, 5.8566];
    var zoomLevel = 12; // Adjust zoom level as necessary

    // Initialize the map centered on Førde
    var map = L.map('map').setView(fordeCoordinates, zoomLevel);

    // Add tile layer from OpenStreetMap
    L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
        attribution: '&copy; OpenStreetMap contributors'
    }).addTo(map);
});
