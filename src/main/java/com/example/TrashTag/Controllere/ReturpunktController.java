package com.example.TrashTag.Controllere;

import com.example.TrashTag.Service.ReturpunktService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReturpunktController {

    @Autowired
    private ReturpunktService returpunktService;

    @GetMapping("/kart")
    public String kartVisning() {
        return "kart";
    }

    @GetMapping("/redirectToHome")
    public String redirectToHome() {
        return "redirect:/hjem";
    }



}
