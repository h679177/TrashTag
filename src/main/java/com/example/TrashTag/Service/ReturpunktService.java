package com.example.TrashTag.Service;

import com.example.TrashTag.Model.Avfallstype;
import com.example.TrashTag.Model.Returpunkt;
import com.example.TrashTag.Repositories.ReturpunktRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class ReturpunktService {

    @Autowired
    private ReturpunktRepo returpunktRepo;

    public Set<Returpunkt> finnNermestePunkt(List<Double> koordinat,  List<String> avfallstyper) {
        double lat = koordinat.get(0);
        double lon = koordinat.get(1);
        return returpunktRepo.finnNermestePunkt(lat, lon, avfallstyper);
    }

    public List<Avfallstype> hentAlleTyper() {
        return returpunktRepo.hentAlleTyper();
    }

    public Set<Returpunkt> sokEtterPostNr(int postnr, List<String> avfallstyper){
        return returpunktRepo.sokEtterPostNr(avfallstyper, postnr);
    }

    public Set<Returpunkt> finnReturpunktFraInput(String input, List<String> avfallstyper) {
        List<Double> koordinat = formaterKoordinat(input);
        int postnr = formaterPostNr(input);
        if(koordinat != null) {
           return finnNermestePunkt(koordinat, avfallstyper);
        } else if(postnr != 0){
            return sokEtterPostNr(postnr, avfallstyper);
        }
        return null;
    }

    public List<Double> formaterKoordinat(String input){
        String[] splittet = input.split(", ");
        List<Double> koordinat = new ArrayList<Double>();
        if(splittet.length == 2){
            for(String s : splittet){
                try {
                    koordinat.add(Double.parseDouble(s.trim()));
                } catch (NumberFormatException e) {
                    return null;
                }
            }
            return koordinat;
        }
        return null;
    }

    public int formaterPostNr(String input){

        if(input.length() == 4){
            try{
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                return 0;
            }
        }
        return 0;
    }

}
