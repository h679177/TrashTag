package com.example.TrashTag.Service;

import com.example.TrashTag.Model.Vare;
import com.example.TrashTag.Repositories.VareRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VareService {

    private final VareRepo vareRepo;

    @Autowired
    public VareService(VareRepo vareRepo) {
        this.vareRepo = vareRepo;
    }

    public VareResponse Sok(String ean) {
        if (ean == null || ean.isEmpty()) {
            return VareResponse.medError("Vennligst oppgi et EAN-nummer");
        }

        Vare vare = vareRepo.findByEanNummer(ean);
        if (vare == null) {
            return VareResponse.medError("Varen finnes ikke i vårt system, prøv igjen");
        }

        return VareResponse.medVare(vare);
    }

    public static class VareResponse {
        private final Vare vare;
        private final String errorMelding;

        public VareResponse(Vare vare, String errorMelding) {
            this.vare = vare;
            this.errorMelding = errorMelding;
        }

        public static VareResponse medVare(Vare vare) {
            return new VareResponse(vare, null);
        }

        public static VareResponse medError(String errorMelding) {
            return new VareResponse(null, errorMelding);
        }

        public Vare getVare() {
            return vare;
        }

        public String getErrorMelding() {
            return errorMelding;
        }
    }
}
