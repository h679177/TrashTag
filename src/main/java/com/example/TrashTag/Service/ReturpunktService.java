package com.example.TrashTag.Service;

import com.example.TrashTag.Model.Returpunkt;
import com.example.TrashTag.ReturpunktRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReturpunktService {

    @Autowired
    private ReturpunktRepo returpunktRepo;

    public List<Returpunkt> finnNermestePunkt(double latitude, double longitude) {
        return returpunktRepo.finnNermestePunkt(latitude, longitude);
    }


}
