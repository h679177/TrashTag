package com.example.TrashTag.Controller;

import com.example.TrashTag.Service.ReturpunktService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.Set;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = com.example.TrashTag.Controllere.ReturpunktController.class)
class ReturpunktControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ReturpunktService returpunktService;

    @Test
    void testKartVisning() throws Exception {
        Mockito.when(returpunktService.hentAlleTyper()).thenReturn(List.of());

        mockMvc.perform(get("/kart"))
                .andExpect(status().isOk())
                .andExpect(view().name("kart"))
                .andExpect(model().attributeExists("kategorier"));
    }

    @Test
    void testAvfallstypeValg() throws Exception {
        Mockito.when(returpunktService.finnReturpunktFraInput(Mockito.anyString(), Mockito.anyList()))
                .thenReturn(Set.of());

        mockMvc.perform(post("/avfallstypeValg")
                        .param("kategori", "Plast")
                        .param("koordinat", "61.45, 5.89"))
                .andExpect(status().isOk())
                .andExpect(view().name("kart"))
                .andExpect(model().attributeExists("returpunkter"));
    }
}
