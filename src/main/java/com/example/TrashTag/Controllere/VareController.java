package com.example.TrashTag.Controllere;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class VareController {

    @GetMapping("/vareSok")
    public String vareSok(Model model){
        return "vareSok";
    }

    @PostMapping("/vareInfo")
    public String sokEtterVare(Model model,
                               RedirectAttributes ra){



        return "redirect:vareSok";
    }
}
