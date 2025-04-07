package com.example.TrashTag.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "bruker", schema = "brukerinformasjon")
public class Bruker {

    @Id
    private String brukernavn;

    private String fornavn;
    private String etternavn;
    private int postnummer;
    private String gatenavn;
    private boolean deler_data;
    private boolean deler_navn;
    private String nabolag;
    private String hash;
    private String salt;

    @Transient
    private String passord;

    @Transient
    private String repPassord;

    public Bruker() {}

    public Bruker(String brukernavn, String fornavn, String etternavn,
                  int postnr, String gatenavn, boolean deler_data,
                  String nabolag, boolean deler_navn) {
        this.brukernavn = brukernavn;
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.postnummer = postnr;
        this.gatenavn = gatenavn;
        this.deler_data = deler_data;
        this.nabolag = nabolag;
        this.deler_navn = deler_navn;
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


    public int getPostnummer() {
        return postnummer;
    }

    public void setPostnummer(int postnummer) {
        this.postnummer = postnummer;
    }

    public String getGatenavn() {
        return gatenavn;
    }

    public void setGatenavn(String gatenavn) {
        this.gatenavn = gatenavn;
    }

    public boolean isDeler_data() {
        return deler_data;
    }

    public void setDeler_data(boolean deler_data) {
        this.deler_data = deler_data;
    }

    public String getNabolag() {
        return nabolag;
    }

    public void setNabolag(String nabolag) {
        this.nabolag = nabolag;
    }

    public boolean isDeler_navn() {
        return deler_navn;
    }

    public void setDeler_navn(boolean deler_navn) {
        this.deler_navn = deler_navn;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
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
