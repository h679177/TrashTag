package com.example.TrashTag.Controllere;

import com.example.TrashTag.Service.KartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
//Import;

@Controller
public class KartController {

    @Autowired
    private KartService kartService;

    @GetMapping("/kart")
    public String kartVisning() {
        return "kart";
    }

    @GetMapping("/redirectToHome")
    public String redirectToHome() {
        return "redirect:/hjem";
    }



}
