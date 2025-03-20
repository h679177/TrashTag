package com.example.TrashTag.Model;

import jakarta.validation.constraints.Pattern;

public class ValiderSok {
    @Pattern(regexp = "^\\d{13}$\n", message = "Strekkoden må ha akkurat 13 siffer")
    String EAN_Nummmer;

    public ValiderSok(String EAN_Nummmer) {
        this.EAN_Nummmer = EAN_Nummmer;
    }

    public String getEAN_Nummmer() {
        return EAN_Nummmer;
    }

    public void setEAN_Nummmer(String EAN_Nummmer) {
        this.EAN_Nummmer = EAN_Nummmer;
    }
}
