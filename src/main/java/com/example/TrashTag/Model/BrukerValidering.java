package com.example.TrashTag.Model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class BrukerValidering {

    @NotNull(message = "Brukernavn må fylles inn!")
    @Pattern(regexp = "^[A-ZÆØÅa-zæøå0-9 -]{2,20}$\n", message = "Brukernavninneholde 2-20 bokstaver")
    private String brukernavn;

    @NotNull(message = "Fornavn må være fylt inn!")
    @Pattern(regexp = "^[A-ZÆØÅ][A-ZÆØÅa-zæøå-]{1,19}$", message = "Fornavn må starte med stor bokstav og inneholde 2-20 bokstaver")
    private String fornavn;

    @NotNull(message = "Etternavn må være fylt inn!")
    @Pattern(regexp = "^[A-ZÆØÅ][A-ZÆØÅa-zæøå-]{1,19}$", message = "Etternavn må starte med stor bokstav og inneholde 2-20 bokstaver")
    private String etternavn;

    @NotNull(message = "Postnummer må være fylt inn!")
    @Pattern(regexp = "^\\d{4}$\n", message = "Postnummer må være 4 tall")
    private int postnr;

    @NotNull(message = "Gatenavn må være fylt inn!")
    @Pattern(regexp = "^[A-Za-zÆØÅæøå]{4,}$\n", message = "Gatenavn må være minst 4 bokstaver, og skal ikke inneholde tall")
    private String gatenavn;

    @NotNull(message = "Nabolag må være fylt inn!")
    private String nabolag;
}
