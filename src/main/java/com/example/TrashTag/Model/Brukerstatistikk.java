package com.example.TrashTag.Model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "brukerstatistikk", schema = "brukerinformasjon")
public class Brukerstatistikk {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int nummer;

    private String brukernavn;
    private LocalDate dato;
    private String avfallstype;
    private double vekt;

    public Brukerstatistikk() {}

    public Brukerstatistikk(String brukernavn, LocalDate dato, String avfallstype, double vekt) {
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
