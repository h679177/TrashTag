document.addEventListener("DOMContentLoaded", function() {
    document.getElementById("camera-button").addEventListener("click", function() {
        let scannerContainer = document.getElementById("scanner-container");
        let videoElement = document.getElementById("scanner");

        scannerContainer.style.display = "block"; // Viser kameravinduet

        // Starter kameraet
        navigator.mediaDevices.getUserMedia({ video: { facingMode: "environment" } })
            .then(function(stream) {
                videoElement.srcObject = stream;
            })
            .catch(function(err) {
                console.error("Kamera-feil:", err);
            });

        // Initialiserer QuaggaJS for strekkodeskanning
        Quagga.init({
            inputStream: {
                type: "LiveStream",
                constraints: {
                    width: 400,
                    height: 300,
                    facingMode: "environment"
                },
                target: videoElement
            },
            decoder: {
                readers: ["ean_reader"] // Støtter EAN-strekkoder
            }
        }, function(err) {
            if (err) {
                console.error(err);
                return;
            }
            Quagga.start();
        });

        // Når en strekkode blir skannet
        Quagga.onDetected(function(result) {
            let code = result.codeResult.code;
            document.getElementById("eanInput").value = code; // Fyller inn søkefeltet

            // 🚀 Automatisk innsending av skjema
            document.querySelector("form").submit();

            // Stopper kameraet
            Quagga.stop();
            videoElement.srcObject.getTracks().forEach(track => track.stop());
            scannerContainer.style.display = "none";
        });
    });
});
