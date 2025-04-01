package com.example.TrashTag.Controllere;

import com.example.TrashTag.Model.Returpunkt;
import com.example.TrashTag.Service.ReturpunktService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Set;

@Controller
public class ReturpunktController {

    @Autowired
    private ReturpunktService returpunktService;

    @GetMapping("/kart")
    public String kartVisning(@RequestParam(value = "koordinat", required = false) String koordinat, Model model) {

        model.addAttribute("kategorier", returpunktService.hentAlleTyper());
        return "kart";
    }

    @GetMapping("/redirectToHome")
    public String redirectToHome() {
        return "redirect:/hjem";
    }

    @PostMapping("/avfallstypeValg")
    public String avfallstypeValg(@RequestParam(value = "kategori", required = false) List<String> valgtAvfallstype, @RequestParam(value = "koordinat", required = false) String koordinat,  Model model) {
        if(koordinat != null) {
            Set<Returpunkt> returpunkter = returpunktService.finnReturpunktFraInput(koordinat, valgtAvfallstype);
            model.addAttribute("returpunkter", returpunkter);

        }

        return "kart";
    }
}
