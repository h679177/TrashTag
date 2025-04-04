package com.example.TrashTag.Model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "returpunkt", schema = "vareinformasjon")
public class Returpunkt {

    @Id
    private Integer returid;

    private String navn;
    private int postnummer;
    private String koordinater;

    @ManyToMany
    @JoinTable(
            name = "sorteringssteder",
            schema = "vareinformasjon",
            joinColumns = @JoinColumn(name = "returid"),  // Adjust column name if needed
            inverseJoinColumns = @JoinColumn(name = "avfallstype")  // Adjust column name if needed
    )
    private Set<Avfallstype> avfallstype;

    public Returpunkt() {}

    public Returpunkt(Integer returid, String navn, int postnr, String koordinater) {
        this.returid = returid;
        this.navn = navn;
        this.postnummer = postnr;
        this.koordinater = koordinater;
    }


    public Integer getReturid() {
        return returid;
    }

    public void setReturid(Integer returid) {
        this.returid = returid;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public int getPostnummer() {
        return postnummer;
    }

    public void setPostnummer(int postnummer) {
        this.postnummer = postnummer;
    }

    public String getKoordinater() {
        return koordinater;
    }

    public void setKoordinater(String koordinater) {
        this.koordinater = koordinater;
    }

    public Set<Avfallstype> getAvfallstype() {
        return avfallstype;
    }
}

