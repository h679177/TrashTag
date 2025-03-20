package com.example.TrashTag.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(schema = "emballasje")
public class Emballasje {

    @Id
    String EAN_Nummer;

    @Id
    String avfallstype;

    String kommentar;

    public Emballasje() {}

    public Emballasje(String EAN_Nummer, String avfallstype, String kommentar) {
        this.EAN_Nummer = EAN_Nummer;
        this.avfallstype = avfallstype;
        this.kommentar = kommentar;
    }

    public String getEAN_Nummer() {
        return EAN_Nummer;
    }

    public void setEAN_Nummer(String EAN_Nummer) {
        this.EAN_Nummer = EAN_Nummer;
    }

    public String getAvfallstype() {
        return avfallstype;
    }

    public void setAvfallstype(String avfallstype) {
        this.avfallstype = avfallstype;
    }

    public String getKommentar() {
        return kommentar;
    }

    public void setKommentar(String kommentar) {
        this.kommentar = kommentar;
    }


}
