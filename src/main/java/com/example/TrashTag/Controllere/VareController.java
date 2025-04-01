package com.example.TrashTag.Controllere;

import com.example.TrashTag.Service.VareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class VareController {

    @Autowired
    private VareService vareService;

    //Skal nok ikkje ligge her, ligger bare her foreløpig for å unngå whitelabeling når vi trykker på hjem knappen
    @GetMapping("/hjem")
    public String hjem(){
        return "hjem";
    }

    @GetMapping("/vareSok")
    public String vareSok(@RequestParam(value = "EAN", required = false) String EAN, Model model) {

        if (EAN != null) {
            VareService.VareResponse response = vareService.Sok(EAN);
            if (response.getErrorMelding() != null) {
                model.addAttribute("feilmelding", response.getErrorMelding());
            } else {
                model.addAttribute("vare", response.getVare());
            }
        }

        return "vareSok";
    }
}