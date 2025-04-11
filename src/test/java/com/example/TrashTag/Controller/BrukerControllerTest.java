package com.example.TrashTag.Controller;

import com.example.TrashTag.Service.BrukerService;
import com.example.TrashTag.Service.PassordService;
import com.example.TrashTag.Service.ReturpunktService;
import jakarta.servlet.http.HttpSession;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = com.example.TrashTag.Controllere.BrukerController.class)
class BrukerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BrukerService brukerService;

    @MockBean
    private PassordService passordService;

    @MockBean
    private ReturpunktService returpunktService;

    @Test
    void testVisOpprettBrukerSkjema() throws Exception {
        mockMvc.perform(get("/opprettBruker"))
                .andExpect(status().isOk())
                .andExpect(view().name("opprettBruker"));
    }

    @Test
    void testRedigerBrukerKreverInnlogging() throws Exception {
        mockMvc.perform(get("/redigerBruker"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("loggInn"));
    }

    @Test
    void testLagBrukerMedFeilRedirecterTilProfil() throws Exception {
        mockMvc.perform(post("/lagBruker")
                        .param("brukernavn", "")
                        .param("fornavn", "")
                        .param("etternavn", "")
                        .param("postnummer", ""))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("profil"));
    }

    @Test
    void testSlettBruker_redirectTilLoggInn() throws Exception {
        MockHttpSession session = new MockHttpSession();
        session.setAttribute("bruker", new Object()); // dummy bruker

        mockMvc.perform(post("/slettBruker").session(session))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("loggInn"));
    }
}
