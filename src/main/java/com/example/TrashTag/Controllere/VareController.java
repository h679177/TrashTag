package com.example.TrashTag.Controllere;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VareController {

    @GetMapping("/vareSok")
    public String vareSok(){
        return "vareSok";
    }
}
