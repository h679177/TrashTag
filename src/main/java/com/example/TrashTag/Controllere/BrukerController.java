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
    public String profilVisning() {
        return "profil";
    }

    @GetMapping("/opprettBruker")
    public String opprettBruker() {
        return "opprettBruker";
    }

    @GetMapping("/redigerBruker")
    public String redigerBruker() {
        return "redigerBruker";
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
            return "redirect:profil";
        }

        String salt = passordService.genererTilfeldigSalt();
        String hash = passordService.hashMedSalt(bruker.getPassord(), salt);
        Bruker godkjentBruker = new Bruker(
                bruker.getBrukernavn(),
                bruker.getFornavn(),
                bruker.getEtternavn(),
                bruker.getPostnummer(),
                bruker.getGatenavn(),
                bruker.getNabolag()
        );

        godkjentBruker.setHash(hash);
        godkjentBruker.setSalt(salt);

        brukerService.lagreBruker(godkjentBruker);
        LoginUtil.loggInnBruker(request, bruker);
        return "redirect:profil";
    }

    @GetMapping("/registrerResirkulering")
    public String visResirkRegistrering(Model model) {
        model.addAttribute("kategorier", returpunktService.hentAlleTyper());
        return "registrerResirkulering";
    }

    @PostMapping("/registrerResirkulering")
    public String registrerResirkulering(@RequestParam("avfallstype") String valgtAvfallstype,
                                         @RequestParam("vekt") String vekt,
                                         HttpSession session,
                                         RedirectAttributes ra) {

        LocalDate idag = LocalDate.now();
        double vektNum;
        String brukernavn = session.getAttribute("username").toString();

        try {
            vektNum = Double.parseDouble(vekt);
            Brukerstatistikk oppføring = new Brukerstatistikk(brukernavn, idag, valgtAvfallstype, vektNum);
            brukerService.registrerResirkulering(oppføring);
            ra.addFlashAttribute("melding", valgtAvfallstype + " (" + vekt + " kg) er lagt til i din statistikk.");
        } catch (NumberFormatException e) {
            System.out.println("Ikke et tall.");
        }

        return "redirect:registrerResirkulering";
    }

    @PostMapping("/endreBruker")
    public String endreBruker(@Valid @ModelAttribute("bruker") Bruker bruker,
                              @RequestParam("nyttPassord") String nyttPassord,
                              @RequestParam("repNyttPassord") String repNyttPassord,
                              BindingResult bindingResult,
                              RedirectAttributes ra,
                              Model model,
                              HttpSession session) {

        Bruker innlogget = (Bruker) session.getAttribute("bruker");
        List<String> feilmeldinger = InputValidering.validerRedigerBruker(bruker);

        if (!LoginUtil.erInnlogget(session)) {
            feilmeldinger.add("Du må være innlogget for å redigere profilen din");
            model.addAttribute("feilmeldinger", feilmeldinger);
            return "redirect:loggInn";
        }

        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().forEach(error -> {
                feilmeldinger.add(error.getDefaultMessage());
            });
        }
        if (!feilmeldinger.isEmpty()) {
            ra.addFlashAttribute("feilmeldinger", feilmeldinger);
            return "redirect:redigerBruker";
        }
        innlogget.setBrukernavn(innlogget.getBrukernavn());
        innlogget.setFornavn(bruker.getFornavn());
        innlogget.setEtternavn(bruker.getEtternavn());
        innlogget.setGatenavn(bruker.getGatenavn());
        innlogget.setPostnummer(bruker.getPostnummer());

        if(bruker.getPassord() != null){
            if(passordService.erKorrektPassord(bruker.getPassord(), innlogget.getSalt(), innlogget.getHash())){
                if(passordService.erPassordInputLike(nyttPassord, repNyttPassord)){
                    if(InputValidering.validerPassord(nyttPassord)){
                        innlogget.setPassord(nyttPassord);
                        String salt = passordService.genererTilfeldigSalt();
                        String hash = passordService.hashMedSalt(nyttPassord, salt);
                        innlogget.setHash(hash);
                        innlogget.setSalt(salt);
                    }
                }
            }
        }

        if (feilmeldinger.isEmpty()) {
            brukerService.oppdaterBruker(innlogget);
        } else {
            ra.addFlashAttribute("feilmeldinger", feilmeldinger);
            return "redirect:redigerBruker";
        }

        return "redirect:profil";
    }





    @PostMapping("/slettBruker")
    public String slettBruker(HttpSession session, RedirectAttributes ra) {
        Bruker bruker = (Bruker) session.getAttribute("bruker"); // Retrieve the user from the session
        if (bruker != null) {
            brukerService.slettBruker(bruker);
            LoginUtil.loggUtBruker(session);
            ra.addFlashAttribute("feilmeldinger", "Bruker er slettet");
        } else {
            return "redirect:loggInn";
        }
        return "redirect:loggInn";
    }
}
