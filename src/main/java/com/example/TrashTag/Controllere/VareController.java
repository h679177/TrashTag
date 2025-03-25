package com.example.TrashTag.Controllere;

import com.example.TrashTag.Model.Vare;
import com.example.TrashTag.VareRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class VareController {

    @Autowired
    private VareRepo vareRepo;

    @GetMapping("/hjem")
    public String hjem(){
        return "hjem";
    }

    @GetMapping("/vareSok")
    public String vareSok(@RequestParam(value = "EAN", required = false) String EAN, Model model) {
        if (EAN != null) {
            if (EAN.isEmpty()) {
                model.addAttribute("feilmelding", "Vennligst oppgi et EAN-nummer");
            } else {
                Vare vare = vareRepo.findByEanNummer(EAN);
                if (vare == null) {
                    model.addAttribute("feilmelding", "Varen finnes ikke i vårt system, prøv igjen");
                } else {
                    model.addAttribute("vare", vare);
                }
            }
        }
        return "vareSok";
    }
}