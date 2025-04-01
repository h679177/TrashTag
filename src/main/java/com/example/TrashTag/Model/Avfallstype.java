package com.example.TrashTag.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "avfallstype", schema = "vareinformasjon")
public class Avfallstype {
    @Id
    String avfallstype;
    String instruksjon;

    public Avfallstype() {}
    public Avfallstype(String avfallstype, String instruksjon) {
        this.avfallstype = avfallstype;
        this.instruksjon = instruksjon;
    }

    public String getInstruksjon() {
        return instruksjon;
    }

    public void setInstruksjon(String instruksjon) {
        this.instruksjon = instruksjon;
    }

    public String getAvfallstype() {
        return avfallstype;
    }

    public void setAvfallstype(String avfallstype) {
        this.avfallstype = avfallstype;
    }

    @Override
    public String toString() {
        return avfallstype;
    }
}
