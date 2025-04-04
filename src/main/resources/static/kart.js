document.addEventListener('DOMContentLoaded', function () {
    var map = L.map('map').setView([61.4521, 5.8566], 12); // Set the center of the map to Førde

    // Add a tile layer
    L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
        attribution: '© OpenStreetMap contributors'
    }).addTo(map);

    // Create markers for return points
    var markers = [
        {
            name: 'Returpunkt Tervatunet',
            coords: [61.458024, 5.897591],
            description: 'Dette er en returpunkt.'
        },
        {
            name: 'Returpunkt HVL',
            coords: [61.459275, 5.888901],
            description: 'Dette er en returpunkt.'
        },
        {
            name: 'Festplassen',
            coords: [61.4516, 5.863186],
            description: 'Dette er en returpunkt.'
        },
        {
            name: 'Bruland',
            coords: [61.437621,5.897901],
            description: 'Dette er en returpunkt.'
        },
        {
            name: 'Einestølen',
            coords: [61.512794,5.79725],
            description: 'Dette er en returpunkt.'
        },
        {
            name: 'Sande',
            coords: [61.321599,5.783471],
            description: 'Dette er en returpunkt.'
        },
        {
            name: 'Bygstad',
            coords: [61.373853,5.640177],
            description: 'Dette er en returpunkt.'
        },
        {
            name: 'Naustdal',
            coords: [61.509968,5.717017],
            description: 'Dette er en returpunkt.'
        },
        {
            name: 'Jølster',
            coords: [61.487593,6.084643],
            description: 'Dette er en returpunkt.'
        },
        {
            name: 'Viksdalen',
            coords: [61.345937,6.114051],
            description: 'Dette er en returpunkt.'
        },

    ];

    // Add markers to the map
    var leafletMarkers = markers.map(function(marker) {
        var leafletMarker = L.marker(marker.coords).addTo(map)
            .bindPopup("<b>" + marker.name + "</b><br>" + marker.description);
        leafletMarker.name = marker.name; // Save the name on the marker for searching
        return leafletMarker;
    });

    // Function to search markers by name
    function searchMarkers(query) {
        var foundMarker = leafletMarkers.find(function(marker) {
            return marker.name.toLowerCase().includes(query.toLowerCase());
        });

        if (foundMarker) {
            map.setView(foundMarker.getLatLng(), 14); // Zoom into the found marker
            foundMarker.openPopup(); // Optionally open the popup
        }
    }

    // Add custom searchbox control
    L.Control.Searchbox = L.Control.extend({
        onAdd: function(map) {
            var container = L.DomUtil.create('div', 'leaflet-searchbox-wrapper');
            this.searchbox = L.DomUtil.create('input', 'leaflet-searchbox', container);
            this.searchbox.type = 'text';
            this.searchbox.placeholder = 'Search for recycling points...';
            this.searchbox.addEventListener('input', function() {
                searchMarkers(this.value); // Trigger search when user types
            });

            L.DomEvent.disableClickPropagation(container);
            return container;
        },

        onRemove: function(map) {
            // Cleanup code if necessary
        }
    });

    // Create and add the custom search box control to the map
    new L.Control.Searchbox({ position: 'topleft' }).addTo(map);
});
