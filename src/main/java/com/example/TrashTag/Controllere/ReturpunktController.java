package com.example.TrashTag.Controllere;

import com.example.TrashTag.Service.ReturpunktService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ReturpunktController {

    @Autowired
    private ReturpunktService returpunktService;

    @GetMapping("/kart")
    public String kartVisning(Model model) {
        model.addAttribute("returpunkter", returpunktService.finnNermestePunkt(61.454624, 5.865735));
        model.addAttribute("kategorier", returpunktService.hentAlleTyper());
        return "kart";
    }

    @GetMapping("/redirectToHome")
    public String redirectToHome() {
        return "redirect:/hjem";
    }

    @PostMapping("/avfallstypeValg")
    public String avfallstypeValg(Model model) {
        return "kart";
    }
}
