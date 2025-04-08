package com.example.TrashTag.Service;

import com.example.TrashTag.Model.Bruker;
import com.example.TrashTag.Repositories.BrukerRepo;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class BrukerServiceTest {

    @Mock
    private BrukerRepo brukerRepo;

    @InjectMocks
    private  BrukerService brukerService;

    private Bruker allInfo;
    private Bruker ingenInfo;

    @BeforeEach
    public  void setup() {
        allInfo = new Bruker("test", "Test", "Testesen", 6812, "Testveien");
        ingenInfo = new Bruker("test2");

    }

    @Test
    @Order(1)
    void lagreBruker() {
        // precondition
        given(brukerRepo.save(allInfo)).willReturn(allInfo);

        //action
        Bruker lagret = brukerService.lagreBruker(allInfo);

        // verify the output
        assertThat(lagret).isNotNull();
    }

    @Test
    void registrerResirkulering() {
    }

    @Test
    void oppdaterBruker() {
    }

    @Test
    void slettBruker() {

    }
}