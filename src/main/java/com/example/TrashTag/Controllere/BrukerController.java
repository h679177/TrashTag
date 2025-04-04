package com.example.TrashTag.Controllere;

import com.example.TrashTag.Model.Bruker;
import com.example.TrashTag.Util.BrukerValidering;
import com.example.TrashTag.Model.Brukerstatistikk;
import com.example.TrashTag.Util.BrukerValidering;
import com.example.TrashTag.Service.BrukerService;
import com.example.TrashTag.Service.PassordService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.TrashTag.Service.ReturpunktService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Controller
public class BrukerController {
    @Autowired
    BrukerService brukerService;
    @Autowired
    private PassordService passordService;
    @Autowired
    private ReturpunktService returpunktService;

    @GetMapping("/profil")
    public String profilVisning(Model model) {
        model.addAttribute("kategorier", returpunktService.hentAlleTyper());
        return "profil";
    }

    @GetMapping("/opprettBruker")
    public String opprettBruker() {
        return "opprettBruker";
    }

    @PostMapping("/lagBruker")
    public String lagBruker(@Valid @ModelAttribute("bruker") BrukerValidering brukerVal, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("bruker", brukerVal);
            model.addAttribute("bindingResult", bindingResult);
            return "opprettBruker";
        }

        // Validate passwords
        if (!passordService.erPassordInputLike(brukerVal.getPassord(), brukerVal.getRepPassord())) {
            bindingResult.rejectValue("repPassord", "error.repPassord", "Passordene er ikke like!");
        }

        if (bindingResult.hasErrors()) {
            model.addAttribute("bruker", brukerVal);
            model.addAttribute("bindingResult", bindingResult);
            return "opprettBruker";
        }

        String salt = passordService.genererTilfeldigSalt();
        String hash = passordService.hashMedSalt(brukerVal.getPassord(), salt);

        Bruker godkjentBruker = new Bruker(brukerVal.getBrukernavn(), brukerVal.getFornavn(), brukerVal.getEtternavn(),
                brukerService.formaterPostnr(brukerVal.getPostnr()), brukerVal.getGatenavn(), false, brukerVal.getNabolag(),
                false, hash, salt);
        brukerService.lagreBruker(godkjentBruker);

        return "redirect:/profil";
    }

    @PostMapping("/registrerResirkulering")
    public String registrerResirkulering(@RequestParam("avfallstype") String valgtAvfallstype,
                                         @RequestParam("vekt") double vekt,
                                         Model model) {

        LocalDate idag = LocalDate.now();
        String brukernavn = "princecharming";
        Brukerstatistikk oppføring = new Brukerstatistikk(brukernavn, idag, valgtAvfallstype, vekt);
        brukerService.registrerResirkulering(oppføring);

        return "profil";
    }
}
