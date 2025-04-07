package com.example.TrashTag.Service;

import com.example.TrashTag.Model.Bruker;
import com.example.TrashTag.Model.Brukerstatistikk;
import com.example.TrashTag.Repositories.BrukerRepo;
import com.example.TrashTag.Repositories.StatistikkRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BrukerService {
    @Autowired
    private BrukerRepo brukerRepo;

    @Autowired
    private StatistikkRepo statistikkRepo;

    public void lagreBruker(Bruker bruker) {
        brukerRepo.save(bruker);
    }

    public void registrerResirkulering(Brukerstatistikk stat) {

        statistikkRepo.save(stat);
    }

    public void oppdaterBruker(Bruker bruker) {
        return;
    }

    public void slettBruker(Bruker bruker) {
        brukerRepo.delete(bruker);
    }

}
