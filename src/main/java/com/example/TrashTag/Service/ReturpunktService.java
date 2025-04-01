package com.example.TrashTag.Service;

import com.example.TrashTag.Model.Avfallstype;
import com.example.TrashTag.Model.Returpunkt;
import com.example.TrashTag.ReturpunktRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class ReturpunktService {

    @Autowired
    private ReturpunktRepo returpunktRepo;

    public Set<Returpunkt> finnNermestePunkt(String koordinat,  List<String> avfallstyper) {
        String[] splittet = koordinat.split(", ");
        double latitude = Double.parseDouble(splittet[0]);
        double longitude = Double.parseDouble(splittet[1]);
        return returpunktRepo.finnNermestePunkt(latitude, longitude, avfallstyper);
    }

    public List<Avfallstype> hentAlleTyper() {
        return returpunktRepo.hentAlleTyper();
    }

    public Set<Returpunkt> finnReturpunktEtterAvfallstype(List<String> avfallstyper) {
        return returpunktRepo.sokEtterAvfallstype(avfallstyper);
    }


}
