package com.example.TrashTag.Util;

import com.example.TrashTag.Model.Bruker;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class InputValideringTest {

    @Test
    void testValiderBrukernavn_godkjent() {
        assertThat(InputValidering.validerBrukernavn("TestBruker123")).isTrue();
    }

    @Test
    void testValiderBrukernavn_forKort() {
        assertThat(InputValidering.validerBrukernavn("a")).isFalse();
    }

    @Test
    void testValiderFornavn_gyldig() {
        assertThat(InputValidering.validerFornavn("Ola")).isTrue();
    }

    @Test
    void testValiderFornavn_ugyldig() {
        assertThat(InputValidering.validerFornavn("ola")).isFalse(); // liten bokstav
    }

    @Test
    void testValiderPostnummer_gyldig() {
        assertThat(InputValidering.validerPostnummer("6800")).isTrue();
    }

    @Test
    void testValiderPostnummer_ugyldig() {
        assertThat(InputValidering.validerPostnummer("123")).isFalse();
        assertThat(InputValidering.validerPostnummer("abcd")).isFalse();
    }

    @Test
    void testValiderPassord_godkjent() {
        assertThat(InputValidering.validerPassord("Test1234")).isTrue();
    }

    @Test
    void testValiderPassord_utenTall() {
        assertThat(InputValidering.validerPassord("BareBokstaver")).isFalse();
    }

    @Test
    void testValiderRepPassord_like() {
        assertThat(InputValidering.validerRepPassord("abc123", "abc123")).isTrue();
    }

    @Test
    void testValiderRepPassord_ulik() {
        assertThat(InputValidering.validerRepPassord("abc123", "abc321")).isFalse();
    }

    @Test
    void testValiderVekt_gyldig() {
        assertThat(InputValidering.validerVekt("2.5")).isTrue();
        assertThat(InputValidering.validerVekt("0")).isTrue();
    }

    @Test
    void testValiderVekt_ugyldig() {
        assertThat(InputValidering.validerVekt("abc")).isFalse();
        assertThat(InputValidering.validerVekt("-1")).isFalse();
    }

    @Test
    void testValiderBruker_feilinputGirFeilmeldinger() {
        Bruker bruker = new Bruker();
        bruker.setBrukernavn("x");
        bruker.setFornavn("ola");
        bruker.setEtternavn("larsen");
        bruker.setPostnummer(123); // ikke 4 siffer
        bruker.setGatenavn("Storgata 2");
        bruker.setPassord("pass");
        bruker.setRepPassord("pass123");

        List<String> feilmeldinger = InputValidering.validerBruker(bruker);

        assertThat(feilmeldinger).isNotEmpty();
        assertThat(feilmeldinger).anyMatch(msg -> msg.contains("Brukernavn"));
    }
}
