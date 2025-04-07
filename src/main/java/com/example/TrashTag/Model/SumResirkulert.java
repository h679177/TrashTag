package com.example.TrashTag.Model;

public class SumResirkulert {

    private String avfallstype;
    private double vekt;

    public SumResirkulert() {}

    public SumResirkulert(String avfallstype, double vekt) {
        this.avfallstype = avfallstype;
        this.vekt = vekt;
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
