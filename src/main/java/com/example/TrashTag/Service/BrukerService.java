package com.example.TrashTag.Service;

import com.example.TrashTag.Model.Bruker;
import com.example.TrashTag.Repositories.BrukerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BrukerService {
    @Autowired
    private BrukerRepo brukerRepo;

    public void lagreBruker(Bruker bruker) {
        brukerRepo.save(bruker);
    }

    public int formaterPostnr(String postnr) {
        int postnrInt = Integer.parseInt(postnr);
        return postnrInt;
    }
}
