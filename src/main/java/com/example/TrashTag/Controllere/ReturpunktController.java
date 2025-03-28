package com.example.TrashTag.Controllere;

import com.example.TrashTag.Service.ReturpunktService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ReturpunktController {

    @Autowired
    private ReturpunktService returpunktService;

    @GetMapping("/kart")
    public String kartVisning(@RequestParam(value = "koordinat", required = false) String koordinat, Model model) {
        if(koordinat != null) {
            model.addAttribute("returpunkter", returpunktService.finnNermestePunkt(koordinat));
            model.addAttribute("kategorier", returpunktService.hentAlleTyper());
        }
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
