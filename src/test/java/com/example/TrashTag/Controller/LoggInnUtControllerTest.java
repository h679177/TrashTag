package com.example.TrashTag.Controller;

import com.example.TrashTag.Controllere.LoggInnUtController;
import com.example.TrashTag.Model.Bruker;
import com.example.TrashTag.Repositories.BrukerRepo;
import com.example.TrashTag.Service.PassordService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(LoggInnUtController.class)
public class LoggInnUtControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PassordService passordService;

    @MockBean
    private BrukerRepo brukerRepo;

    @Test
    void testLoggInnVisning() throws Exception {
        mockMvc.perform(get("/loggInn"))
                .andExpect(status().isOk())
                .andExpect(view().name("loggInn"));
    }

    @Test
    void testLoginMedFeilBrukernavn() throws Exception {
        given(brukerRepo.findById("ukjent")).willReturn(Optional.empty());

        mockMvc.perform(post("/login")
                        .param("brukernavn", "ukjent")
                        .param("passord", "1234"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/loggInn"));
    }

    @Test
    void testLoginMedFeilPassord() throws Exception {
        Bruker bruker = new Bruker("test");
        bruker.setSalt("salt");
        bruker.setHash("hash");

        given(brukerRepo.findById("test")).willReturn(Optional.of(bruker));
        given(passordService.erKorrektPassord("feil", "salt", "hash")).willReturn(false);

        mockMvc.perform(post("/login")
                        .param("brukernavn", "test")
                        .param("passord", "feil"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/loggInn"));
    }

    @Test
    void testLoggUt() throws Exception {
        MockHttpSession session = new MockHttpSession();
        session.setAttribute("bruker", new Bruker("test"));

        mockMvc.perform(post("/loggUt").session(session))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/loggInn"));
    }
}
