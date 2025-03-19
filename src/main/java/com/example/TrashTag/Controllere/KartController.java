package com.example.TrashTag.Controllere;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class KartController {

    @GetMapping("/kart")
    public String kartVisning() {
        return "kart";
    }
}
