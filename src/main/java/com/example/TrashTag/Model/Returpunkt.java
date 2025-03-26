package com.example.TrashTag.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "returpunkt", schema = "vareinformasjon")
public class Returpunkt {

    @Id
    private Integer returid;

    private String adresse;
    private int postnr;
    private String koordinater;

    public Returpunkt() {}

    public Returpunkt(Integer returid, String adresse, int postnr, String koordinater) {
        this.returid = returid;
        this.adresse = adresse;
        this.postnr = postnr;
        this.koordinater = koordinater;
    }


    public Integer getReturid() {
        return returid;
    }

    public void setReturid(Integer returid) {
        this.returid = returid;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getPostnr() {
        return postnr;
    }

    public void setPostnr(int postnr) {
        this.postnr = postnr;
    }

    public String getKoordinater() {
        return koordinater;
    }

    public void setKoordinater(String koordinater) {
        this.koordinater = koordinater;
    }
}
