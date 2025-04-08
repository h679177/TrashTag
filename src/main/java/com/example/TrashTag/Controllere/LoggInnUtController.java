package com.example.TrashTag.Controllere;

import com.example.TrashTag.Model.Bruker;
import com.example.TrashTag.Repositories.BrukerRepo;
import com.example.TrashTag.Service.PassordService;
import com.example.TrashTag.Util.LoginUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoggInnUtController {

    @Autowired
    PassordService passordService;

    @Autowired
    BrukerRepo brukerRepo;

    @GetMapping("/loggInn")
    public String innlogging(Model model, HttpSession session) {
        if (model.containsAttribute("feilmeldinger")) {
            model.addAttribute("feilmeldinger", model.getAttribute("feilmeldinger"));
        }
        return "loggInn";
    }

    @PostMapping("/login")
    public String provAaLoggeInn(@RequestParam String brukernavn,
                                 @RequestParam String passord,
                                 HttpServletRequest request,
                                 RedirectAttributes ra,
                                 Model model) {

        Bruker bruker = brukerRepo.findById(brukernavn).orElse(null);
        if (bruker == null) {
            ra.addFlashAttribute("feilmeldinger", "Brukernavn/Passord er feil");
            return "redirect:/loggInn";
        }

        boolean isPasswordCorrect = passordService.erKorrektPassord(passord, bruker.getSalt(), bruker.getHash());
        if (!isPasswordCorrect) {
            ra.addFlashAttribute("feilmeldinger", "Brukernavn/Passord er feil");
            return "redirect:/loggInn";
        }
        LoginUtil.loggInnBruker(request, bruker);

        return "redirect:/profil";
    }

    @PostMapping("/loggUt")
    public String loggUt(HttpSession session, RedirectAttributes ra) {

        LoginUtil.loggUtBruker(session);

        ra.addFlashAttribute("feilmeldinger", "Du er nå logget ut");
        return "redirect:/loggInn";
    }

}
