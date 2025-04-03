package com.example.TrashTag.Util;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class BrukerValidering {
    @NotNull(message = "Brukernavn må fylles inn!")
    @Pattern(regexp = "^[A-ZÆØÅa-zæøå0-9 -]{2,20}$", message = "Brukernavn må inneholde 2-20 tegn")
    private String brukernavn;

    @NotNull(message = "Fornavn må være fylt inn!")
    @Pattern(regexp = "^[A-ZÆØÅ][A-ZÆØÅa-zæøå-]{1,29}$", message = "Fornavn må starte med stor bokstav og inneholde 2-30 bokstaver")
    private String fornavn;

    @NotNull(message = "Etternavn må være fylt inn!")
    @Pattern(regexp = "^[A-ZÆØÅ][A-ZÆØÅa-zæøå-]{1,29}$", message = "Etternavn må starte med stor bokstav og inneholde 2-30 bokstaver")
    private String etternavn;

    @NotNull(message = "Postnummer må være fylt inn!")
    @Pattern(regexp = "^\\d{4}$", message = "Postnummer må være 4 tall")
    private String postnr;

    @NotNull(message = "Gatenavn må være fylt inn!")
    @Pattern(regexp = "^[A-Za-zÆØÅæøå]{4,40}$", message = "Gatenavn må være minst 4 bokstaver, og skal ikke inneholde tall")
    private String gatenavn;

    private String nabolag;

    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,16}$", message = "Passord må inneholde minst en stor bokstav og et tall. Lengde mellom 8 og 16 tegn")
    @NotNull(message = "Passord må fylles inn!")
    private String passord;

    private String repPassord;

    public BrukerValidering(String brukernavn, String fornavn, String etternavn, String postnr,
                            String gatenavn, String passord, String repPassord) {
        this.brukernavn = brukernavn;
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.postnr = postnr;
        this.gatenavn = gatenavn;
        this.passord = passord;
    }

    public String getBrukernavn() {
        return brukernavn;
    }

    public void setBrukernavn(String brukernavn) {
        this.brukernavn = brukernavn;
    }

    public String getFornavn() {
        return fornavn;
    }

    public void setFornavn(String fornavn) {
        this.fornavn = fornavn;
    }

    public String getEtternavn() {
        return etternavn;
    }

    public void setEtternavn(String etternavn) {
        this.etternavn = etternavn;
    }

    public String getPostnr() {
        return postnr;
    }

    public void setPostnr(String postnr) {
        this.postnr = postnr;
    }

    public String getGatenavn() {
        return gatenavn;
    }

    public void setGatenavn(String gatenavn) {
        this.gatenavn = gatenavn;
    }

    public String getNabolag() {
        return nabolag;
    }

    public void setNabolag(String nabolag) {
        this.nabolag = nabolag;
    }

    public String getPassord() {
        return passord;
    }

    public void setPassord(String passord) {
        this.passord = passord;
    }

    public String getRepPassord() {
        return repPassord;
    }

    public void setRepPassord(String repPassord) {
        this.repPassord = repPassord;
    }
}
