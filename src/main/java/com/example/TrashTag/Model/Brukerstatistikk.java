package com.example.TrashTag.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "brukerstatistikk", schema = "brukerinformasjon")
public class Brukerstatistikk {

    @Id
    private int nummer;

    private String brukernavn;
    private LocalDate dato;
    private String avfallstype;
    private double vekt;

    public Brukerstatistikk() {}

    public Brukerstatistikk(int nummer, String brukernavn, LocalDate dato, String avfallstype, double vekt) {
        this.nummer = nummer;
        this.brukernavn = brukernavn;
        this.dato = dato;
        this.avfallstype = avfallstype;
        this.vekt = vekt;
    }

    public int getNummer() {
        return nummer;
    }

    public void setNummer(int nummer) {
        this.nummer = nummer;
    }

    public String getBrukernavn() {
        return brukernavn;
    }

    public void setBrukernavn(String brukernavn) {
        this.brukernavn = brukernavn;
    }

    public LocalDate getDato() {
        return dato;
    }

    public void setDato(LocalDate dato) {
        this.dato = dato;
    }

    public String getAvfallstype() {
        return avfallstype;
    }

    public void setAvfallstype(String avfallstype) {
        this.avfallstype = avfallstype;
    }

    public double getVekt() {
        return vekt;
    }

    public void setVekt(double vekt) {
        this.vekt = vekt;
    }

}
