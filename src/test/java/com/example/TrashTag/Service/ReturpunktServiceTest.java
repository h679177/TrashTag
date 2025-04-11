package com.example.TrashTag.Service;

import com.example.TrashTag.Model.Returpunkt;
import com.example.TrashTag.Repositories.ReturpunktRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class ReturpunktServiceTest {

    @Mock
    private ReturpunktRepo returpunktRepo;

    @InjectMocks
    private ReturpunktService returpunktService;

    private List<String> avfallstyper;
    private Set<Returpunkt> dummyReturpunkter;

    @BeforeEach
    void setUp() {
        avfallstyper = List.of("Plast");
        dummyReturpunkter = new HashSet<>();
        dummyReturpunkter.add(new Returpunkt(1, "Testpunkt", 6800, "61.45,5.89"));
    }

    @Test
    void testFormaterKoordinat_valid() {
        List<Double> koordinat = returpunktService.formaterKoordinat("61.45, 5.89");
        assertThat(koordinat).hasSize(2);
        assertThat(koordinat.get(0)).isEqualTo(61.45);
    }

    @Test
    void testFormaterPostNr_valid() {
        int postnr = returpunktService.formaterPostNr("6800");
        assertThat(postnr).isEqualTo(6800);
    }

    @Test
    void testFinnReturpunktFraInput_medKoordinat() {
        given(returpunktRepo.finnNermestePunkt(61.45, 5.89, avfallstyper)).willReturn(dummyReturpunkter);

        Set<Returpunkt> resultat = returpunktService.finnReturpunktFraInput("61.45, 5.89", avfallstyper);

        assertThat(resultat).isEqualTo(dummyReturpunkter);
    }

    @Test
    void testFinnReturpunktFraInput_medPostnummer() {
        given(returpunktRepo.sokEtterPostNr(avfallstyper, 6800)).willReturn(dummyReturpunkter);

        Set<Returpunkt> resultat = returpunktService.finnReturpunktFraInput("6800", avfallstyper);

        assertThat(resultat).isEqualTo(dummyReturpunkter);
    }

    @Test
    void testFinnReturpunktFraInput_invalidInput() {
        Set<Returpunkt> resultat = returpunktService.finnReturpunktFraInput("blabla", avfallstyper);
        assertThat(resultat).isNull();
    }
}
