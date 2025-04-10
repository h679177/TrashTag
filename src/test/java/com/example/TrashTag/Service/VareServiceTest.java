package com.example.TrashTag.Service;

import com.example.TrashTag.Model.Vare;
import com.example.TrashTag.Repositories.VareRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class VareServiceTest {

    private VareRepo vareRepo;
    private VareService vareService;

    @BeforeEach
    void setUp() {
        vareRepo = mock(VareRepo.class);
        vareService = new VareService(vareRepo);
    }

    @Test
    void testSokMedGyldigEan() {
        // Arrange
        Vare vare = new Vare("1234567890123", "Melk", "Tine");
        when(vareRepo.findByEanNummer("1234567890123")).thenReturn(vare);

        // Act
        VareService.VareResponse response = vareService.Sok("1234567890123");

        // Assert
        assertNotNull(response.getVare());
        assertEquals("Melk", response.getVare().getVarenavn());
        assertNull(response.getErrorMelding());
    }

    @Test
    void testSokMedTomEan() {
        // Act
        VareService.VareResponse response = vareService.Sok("");

        // Assert
        assertNull(response.getVare());
        assertEquals("Vennligst oppgi et EAN-nummer", response.getErrorMelding());
    }

    @Test
    void testSokMedUkjentEan() {
        // Arrange
        when(vareRepo.findByEanNummer("9999999999999")).thenReturn(null);

        // Act
        VareService.VareResponse response = vareService.Sok("9999999999999");

        // Assert
        assertNull(response.getVare());
        assertEquals("Varen finnes ikke i vårt system, prøv igjen", response.getErrorMelding());
    }
}
