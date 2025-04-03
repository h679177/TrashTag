package com.example.TrashTag.Controllere;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BrukerController {

    @GetMapping("/profil")
    public String profilVisning() {
        return "profil";
    }

    @GetMapping("/opprettBruker")
    public String opprettBruker() {
        return "opprettBruker";
    }

    @PostMapping("/lagBruker")
    public String lagBruker() {
        return "redirect:profil";
    }
}
