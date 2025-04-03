package com.example.TrashTag.Controllere;

import com.example.TrashTag.Model.Bruker;
import com.example.TrashTag.Model.BrukerValidering;
import com.example.TrashTag.Service.BrukerService;
import com.example.TrashTag.Service.PassordService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BrukerController {
    @Autowired
    BrukerService brukerService;
    @Autowired
    private PassordService passordService;

    @GetMapping("/profil")
    public String profilVisning() {
        return "profil";
    }

    @GetMapping("/opprettBruker")
    public String opprettBruker() {
        return "opprettBruker";
    }

    @PostMapping("/lagBruker")
    public String lagBruker(@Valid @ModelAttribute("bruker") BrukerValidering brukerVal, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("feilmelding", bindingResult);
            model.addAttribute("bruker", brukerVal);
            return "opprettBruker";
        }

        String salt = passordService.genererTilfeldigSalt();
        String hash = passordService.hashMedSalt(brukerVal.getPassord(), salt);

        Bruker godkjentBruker = new Bruker(brukerVal.getBrukernavn(), brukerVal.getFornavn(), brukerVal.getEtternavn(), brukerService.formaterPostnr(brukerVal.getPostnr()), brukerVal.getGatenavn(), false, brukerVal.getNabolag(), false, hash, salt);
        brukerService.lagreBruker(godkjentBruker);

        return "redirect:profil";
    }


}
