package com.example.TrashTag.Model;


import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name ="emballasje", schema = "vareinformasjon")
public class Emballasje {

    @Embeddable
    public static  class EmballasjePK implements Serializable {
        @Column(name = "ean_nummer")
        private String eanNummer;

        @Column(name = "avfallstype")
        private String avfallstype;

        public EmballasjePK() {}

        public EmballasjePK(String eanNummer, String avfallstype) {
            this.eanNummer = eanNummer;
            this.avfallstype = avfallstype;
        }

        public String getEanNummer() {
            return eanNummer;
        }

        public void setEanNummer(String eanNummer) {
            this.eanNummer = eanNummer;
        }

        public String getAvfallstype() {
            return avfallstype;
        }

        public void setAvfallstype(String avfallstype) {
            this.avfallstype = avfallstype;
        }
    }

    @EmbeddedId
    private  EmballasjePK id;

    @Column(name = "kommentar")
    private String kommentar;

    @MapsId("eanNummer")
    @ManyToOne
    @JoinColumn(name="ean_nummer")
    private Vare vare;

    public Emballasje() {
        this.id = new EmballasjePK();
    }

    public Emballasje(String eanNummer, String avfallstype, String kommentar) {
        this.id = new EmballasjePK(eanNummer, avfallstype);
        this.kommentar = kommentar;
    }

    public EmballasjePK getId() {
        return id;
    }

    public void setId(EmballasjePK id) {
        this.id = id;
    }

    public String getKommentar() {
        return kommentar;
    }

    public void setKommentar(String kommentar) {
        this.kommentar = kommentar;
    }

    public Vare getVare() {
        return vare;
    }

    public void setVare(Vare vare) {
        this.vare = vare;
    }
}
