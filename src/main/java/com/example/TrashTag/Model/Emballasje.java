package com.example.TrashTag.Model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name ="emballasje", schema = "vareinformasjon")
public class Emballasje {

    @Id
    @Column(name = "ean_nummer")
    private String eanNummer;

    @Id
    @Column(name = "avfallstype")
    String avfallstype;

    @Column(name = "kommentar")
    String kommentar;

    public Emballasje() {}

    public Emballasje(String eanNummer, String avfallstype, String kommentar) {
        this.eanNummer = eanNummer;
        this.avfallstype = avfallstype;
        this.kommentar = kommentar;
    }

    public String getEanNummer() {
        return eanNummer;
    }

    public void setEAN_Nummer(String eanNummer) {
        this.eanNummer = eanNummer;
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
