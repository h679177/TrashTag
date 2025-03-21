package com.example.TrashTag.Controllere;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
//Import;

@Controller
public class KartController {

    @GetMapping("/kart")
    public String kartVisning() {
        return "kart";
    }

    @GetMapping("/redirectToHome")
    public String redirectToHome() {
        return "redirect:/hjem";
    }

}
