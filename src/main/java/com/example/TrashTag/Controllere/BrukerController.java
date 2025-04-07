package com.example.TrashTag.Controllere;

import com.example.TrashTag.Model.Bruker;
import com.example.TrashTag.Model.Brukerstatistikk;
import com.example.TrashTag.Service.BrukerService;
import com.example.TrashTag.Service.PassordService;
import com.example.TrashTag.Service.ReturpunktService;
import com.example.TrashTag.Util.InputValidering;
import com.example.TrashTag.Util.LoginUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public String lagBruker(
            @Valid @ModelAttribute("bruker") Bruker bruker,
            BindingResult bindingResult,
            HttpServletRequest request,
            RedirectAttributes ra,
            Model model) {

        List<String> feilmeldinger = InputValidering.validerBruker(bruker);

        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().forEach(error -> {
                feilmeldinger.add(error.getDefaultMessage());
            });
        }

        if (!feilmeldinger.isEmpty()) {
            ra.addFlashAttribute("feilmeldinger", feilmeldinger);
            ra.addFlashAttribute("bruker", bruker);
            return "redirect:opprettBruker";
        }

        String salt = passordService.genererTilfeldigSalt();
        String hash = passordService.hashMedSalt(bruker.getPassord(), salt);
        Bruker godkjentBruker = new Bruker(
                bruker.getBrukernavn(),
                bruker.getFornavn(),
                bruker.getEtternavn(),
                bruker.getPostnummer(),
                bruker.getGatenavn(),
                false,
                bruker.getNabolag(),
                false,
                hash,
                salt
        );

        brukerService.lagreBruker(godkjentBruker);
        LoginUtil.loggInnBruker(request, bruker);
        return "redirect:profil";
    }

    @PostMapping("/registrerResirkulering")
    public String registrerResirkulering(@RequestParam("avfallstype") String valgtAvfallstype,
                                         @RequestParam("vekt") double vekt,
                                         HttpSession session) {

        LocalDate idag = LocalDate.now();
        String brukernavn = session.getAttribute("username").toString();
        Brukerstatistikk oppføring = new Brukerstatistikk(brukernavn, idag, valgtAvfallstype, vekt);
        brukerService.registrerResirkulering(oppføring);

        return "profil";
    }

    @PostMapping("/oppdaterBruker")
    public String oppdaterBruker()  {
        return "profil";
    }

    @PostMapping("/slettBruker")
    public String slettBruker(HttpSession session) {
        Bruker bruker = (Bruker) session.getAttribute("bruker"); // Retrieve the user from the session
        if (bruker != null) {
            // Log the ID or username for debugging
            System.out.println("Deleting user: " + bruker.getBrukernavn());

            // Delete the user
            brukerService.slettBruker(bruker);

            // Log out the user after deletion
            LoginUtil.loggUtBruker(session);
        } else {
            System.out.println("No user found in session to delete.");
        }

        // Redirect to the login page
        return "redirect:loggInn";
    }
}
