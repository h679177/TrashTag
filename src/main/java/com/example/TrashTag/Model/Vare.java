package com.example.TrashTag.Model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "vare", schema = "vareinformasjon")
public class Vare {

    @Id
    @Column(name = "ean_nummer")
    private String eanNummer;

    private String varenavn;
    private String produsent;

    @OneToMany(mappedBy = "vare", cascade =  CascadeType.ALL, fetch =  FetchType.EAGER)
    private List<Emballasje> emballasjer = new ArrayList<>();

    public Vare() {
    }

    public Vare(String eanNummer, String varenavn, String produsent) {
        this.eanNummer = eanNummer;
        this.varenavn = varenavn;
        this.produsent = produsent;
    }

    // Getters and Setters

    public String getEanNummer() {
        return eanNummer;
    }

    public void setEanNummer(String eanNummer) {
        this.eanNummer = eanNummer;
    }

    public String getVarenavn() {
        return varenavn;
    }

    public void setVarenavn(String varenavn) {
        this.varenavn = varenavn;
    }

    public String getProdusent() {
        return produsent;
    }

    public void setProdusent(String produsent) {
        this.produsent = produsent;
    }

    public List<Emballasje> getEmballasjer() {
        return emballasjer;
    }

}