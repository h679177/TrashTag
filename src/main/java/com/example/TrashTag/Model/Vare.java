package com.example.TrashTag.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "vare", schema = "vareinformasjon")
public class Vare {

    @Id
    @Column(name = "ean_nummer")
    private String eanNummer;

    private String varenavn;
    private String produsent;

    public Vare() {
    }

    public Vare(String eanNummer, String varenavn, String produsent, String kategori) {
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
}