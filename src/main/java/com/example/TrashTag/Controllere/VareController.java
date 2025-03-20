package com.example.TrashTag.Controllere;

import com.example.TrashTag.Model.ValiderSok;
import com.example.TrashTag.VareRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class VareController {
    @Autowired
    private VareRepo vareRepo;

    @GetMapping("/vareSok")
    public String vareSok(Model model){
        System.out.println(vareRepo.findAll());
        return "vareSok";
    }

    @PostMapping("/vareInfo")
    public String sokEtterVare(Model model,
                               RedirectAttributes ra,
                               ValiderSok validerSok){

        if (!validerSok.getEAN_Nummmer().equals(vareRepo)){
            ra.addFlashAttribute("feilmeldinger",
                    "Varen finnes ikke i vårt system, prøv igjen");
            return "redirect:vareSok";
        }

        return "redirect:vareSok";
    }
}
