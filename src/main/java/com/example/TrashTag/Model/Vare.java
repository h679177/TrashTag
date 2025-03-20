package com.example.TrashTag.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(schema = "vare")
public class Vare {
    @Id
            @NotNull
    String EAN_Nummmer;
    String varenavn;
    String produsent;
    String kategori;

    public Vare() { }

    public Vare(String EAN_Nummmer, String varenavn, String produsent, String kategori) {
        this.EAN_Nummmer = EAN_Nummmer;
        this.varenavn = varenavn;
        this.produsent = produsent;
        this.kategori = kategori;
    }



    public String getEAN_Nummmer() {
        return EAN_Nummmer;
    }

    public void setEAN_Nummmer(String EAN_Nummmer) {
        this.EAN_Nummmer = EAN_Nummmer;
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

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }
}
