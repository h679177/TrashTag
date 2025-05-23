package com.example.TrashTag.Util;

import com.example.TrashTag.Model.Bruker;

import java.util.ArrayList;
import java.util.List;

public class InputValidering {

        public static final String BRUKERNAVN_REGEX = "^[A-ZÆØÅa-zæøå0-9 -]{2,20}$";
        public static final String NAVN_REGEX = "^([A-ZÆØÅ][A-ZÆØÅa-zæøå-]{2,29}|)$";
        public static final String POSTNR_REGEX = "^(\\d{4}|)$";
        public static final String GATENAVN_REGEX = "^(?:[A-Za-zÆØÅæøå]{4,40}(?:\\s+[A-Za-zÆØÅæøå]{4,40})*)?$";
        public static final String PASSORD_REGEX = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,16}$";
        public static final String VEKT_VALIDERING = "^(?:[0-4]?[0-9](\\.\\d+)?|50(\\.0+)?|0(\\.\\d+)?|(?:0|0\\.\\d+))$";


        public static boolean validerBrukernavn(String brukernavn) {
            return brukernavn != null && brukernavn.matches(BRUKERNAVN_REGEX);
        }

        public static boolean validerFornavn(String fornavn) {
            return fornavn != null && fornavn.matches(NAVN_REGEX);
        }

        public static boolean validerEtternavn(String etternavn) {
            return etternavn != null && etternavn.matches(NAVN_REGEX);
        }

        public static boolean validerPostnummer(String postnummer) {
            System.out.println(postnummer == null);
            System.out.println("postnummer: " + postnummer);
            if (postnummer.isEmpty() || postnummer == "null") {
                System.out.println("postnummer is empty");
                return true;
                }
             System.out.println("postnummer is not empty");
             return postnummer.matches(POSTNR_REGEX);
        }


         public static boolean validerGatenavn(String gatenavn) {
            return gatenavn != null && gatenavn.matches(GATENAVN_REGEX);
        }

        public static boolean validerPassord(String passord) {
            return passord != null && passord.matches(PASSORD_REGEX);
        }

        public static boolean validerRepPassord(String passord, String repPassord) {
            return passord != null && passord.equals(repPassord);
        }

        public static boolean validerVekt(String vekt) {
        return vekt != null && vekt.matches(VEKT_VALIDERING);
        }

        public static List<String> validerBruker(Bruker bruker) {
        List<String> feilmeldinger = new ArrayList<>();

        if (!validerBrukernavn(bruker.getBrukernavn())) {
            feilmeldinger.add("Brukernavn må inneholde 2-20 tegn.");
        }
        if (!validerFornavn(bruker.getFornavn())) {
            feilmeldinger.add("Fornavn må starte med stor bokstav og inneholde 2-30 bokstaver.");
        }
        if (!validerEtternavn(bruker.getEtternavn())) {
            feilmeldinger.add("Etternavn må starte med stor bokstav og inneholde 2-30 bokstaver.");
        }
        if (!validerPostnummer(String.valueOf(bruker.getPostnummer()))) {
            feilmeldinger.add("Postnummer må være 4 tall.");
        }
        if (!validerGatenavn(bruker.getGatenavn())) {
            feilmeldinger.add("Gatenavn må være minst 4 bokstaver, og skal ikke inneholde tall.");
        }
        if (!validerPassord(bruker.getPassord())) {
            feilmeldinger.add("Passord må inneholde minst en stor bokstav og et tall. Lengde mellom 8 og 16 tegn.");
        }
        if (!validerRepPassord(bruker.getPassord(), bruker.getRepPassord())) {
            feilmeldinger.add("Passordene er ikke like!");
        }

        return feilmeldinger;
    }

    public static List<String> validerRedigerBruker(Bruker bruker) {
            List<String> feilmeldinger = new ArrayList<>();
        if (!validerFornavn(bruker.getFornavn())) {
            feilmeldinger.add("Fornavn må starte med stor bokstav og inneholde 2-30 bokstaver.");
        }
        if (!validerEtternavn(bruker.getEtternavn())) {
            feilmeldinger.add("Etternavn må starte med stor bokstav og inneholde 2-30 bokstaver.");
        }
        if (!validerPostnummer(String.valueOf(bruker.getPostnummer()))) {
            feilmeldinger.add("Postnummer må være 4 tall.");
        }
        if (!validerGatenavn(bruker.getGatenavn())) {
            feilmeldinger.add("Gatenavn må være minst 4 bokstaver, og skal ikke inneholde tall.");
        }
        return feilmeldinger;
    }

    public static List<String> validerResirkulering(String resirkulering) {
            List<String> feilmeldinger = new ArrayList<>();
            if(!validerVekt(resirkulering)) {
                feilmeldinger.add("Feil i resirkulering!");
            }
            return feilmeldinger;
    }
}
