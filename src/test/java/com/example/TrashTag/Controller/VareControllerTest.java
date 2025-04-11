package com.example.TrashTag.Controller;

import com.example.TrashTag.Model.Vare;
import com.example.TrashTag.Service.VareService;
import com.example.TrashTag.Service.VareService.VareResponse;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = com.example.TrashTag.Controllere.VareController.class)
class VareControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private VareService vareService;

    @Test
    void testHjemVisning() throws Exception {
        mockMvc.perform(get("/hjem"))
                .andExpect(status().isOk())
                .andExpect(view().name("hjem"));
    }

    @Test
    void testVareSok_utenEAN() throws Exception {
        mockMvc.perform(get("/vareSok"))
                .andExpect(status().isOk())
                .andExpect(view().name("vareSok"));
    }

    @Test
    void testVareSok_medGyldigEAN() throws Exception {
        Vare dummyVare = new Vare(); // Hvis du har en tom konstruktør
        VareResponse response = new VareResponse(dummyVare, null);
        Mockito.when(vareService.Sok("123456789")).thenReturn(response);

        mockMvc.perform(get("/vareSok").param("EAN", "123456789"))
                .andExpect(status().isOk())
                .andExpect(view().name("vareSok"))
                .andExpect(model().attributeExists("vare"));
    }

    @Test
    void testVareSok_medFeilEAN() throws Exception {
        VareResponse response = new VareResponse(null, "Varen ble ikke funnet");
        Mockito.when(vareService.Sok("000000000")).thenReturn(response);

        mockMvc.perform(get("/vareSok").param("EAN", "000000000"))
                .andExpect(status().isOk())
                .andExpect(view().name("vareSok"))
                .andExpect(model().attributeExists("feilmelding"));
    }
}
