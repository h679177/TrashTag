package com.example.TrashTag.Service;

import com.example.TrashTag.Model.Avfallstype;
import com.example.TrashTag.Model.Returpunkt;
import com.example.TrashTag.ReturpunktRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReturpunktService {

    @Autowired
    private ReturpunktRepo returpunktRepo;

    public List<Returpunkt> finnNermestePunkt(String koordinat) {
        String[] splittet = koordinat.split(", ");
        double latitude = Double.parseDouble(splittet[0]);
        double longitude = Double.parseDouble(splittet[1]);
        return returpunktRepo.finnNermestePunkt(latitude, longitude);
    }

    public List<Avfallstype> hentAlleTyper() {
        return returpunktRepo.hentAlleTyper();
    }




}
