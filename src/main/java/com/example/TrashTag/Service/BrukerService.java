package com.example.TrashTag.Service;

import com.example.TrashTag.Model.Bruker;
import com.example.TrashTag.Model.Brukerstatistikk;
import com.example.TrashTag.Repositories.BrukerRepo;
import com.example.TrashTag.Repositories.StatistikkRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BrukerService {
    @Autowired
    private BrukerRepo brukerRepo;

    @Autowired
    private StatistikkRepo statistikkRepo;

    public Bruker lagreBruker(Bruker bruker) {
        Optional<Bruker> sjekkBruker = brukerRepo.findById(bruker.getBrukernavn());
        if(sjekkBruker.isEmpty()) {
            return brukerRepo.save(bruker);
        }
        return null;
    }

    public void registrerResirkulering(Brukerstatistikk stat) {

        statistikkRepo.save(stat);
    }

    public void oppdaterBruker(Bruker bruker) {
        brukerRepo.save(bruker);
    }

    public void slettBruker(Bruker bruker) {
        brukerRepo.delete(bruker);
    }

}
