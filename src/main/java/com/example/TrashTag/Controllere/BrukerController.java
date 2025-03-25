package com.example.TrashTag.Controllere;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BrukerController {

    @GetMapping("/profil")
    public String profilVisning() {
        return "profil";
    }
}
