package tn.esprit.rh.achat;
import org.aspectj.lang.annotation.Before;


import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.rh.achat.entities.Operateur;
import tn.esprit.rh.achat.entities.SecteurActivite;
import tn.esprit.rh.achat.repositories.OperateurRepository;
import tn.esprit.rh.achat.repositories.SecteurActiviteRepository;
import tn.esprit.rh.achat.services.OperateurServiceImpl;
import tn.esprit.rh.achat.services.SecteurActiviteServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class SecteurActiviteTest {
    @InjectMocks
    private SecteurActiviteServiceImpl secteurActiviteService;

    @Mock
    private SecteurActiviteRepository secteurActiviteRepository;

    @Before("")
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetSecteurActivite() {
        List<SecteurActivite> secteurActivites= new ArrayList<>();
        // Add some Operateur objects to the list

        when(secteurActiviteRepository.findAll()).thenReturn(secteurActivites);

        List<SecteurActivite> result = secteurActiviteService.retrieveAllSecteurActivite();

        assertEquals(secteurActivites, result);
    }

    @Test
    public void testAddSecteurActivite() {
        SecteurActivite secteuractivite = new SecteurActivite();
        // Initialize operateur as needed

        when(secteurActiviteRepository.save(any(SecteurActivite.class))).thenReturn(secteuractivite);

        SecteurActivite result = secteurActiviteService.addSecteurActivite(secteuractivite);

        assertEquals(secteuractivite, result);
    }

    @Test
    public void testDeleteSecteurActivite() {
        Long id = 1L; // Replace with the appropriate ID
        doNothing().when(secteurActiviteRepository).deleteById(id);

        secteurActiviteService.deleteSecteurActivite(id);

        verify(secteurActiviteRepository, times(1)).deleteById(id);
    }

    @Test
    public void testUpdateSecteurActivite() {
        SecteurActivite secteuractivite = new SecteurActivite();
        // Initialize secteuractivite as needed

        when(secteurActiviteRepository.save(any(SecteurActivite.class))).thenReturn(secteuractivite);

        SecteurActivite result = secteurActiviteService.updateSecteurActivite(secteuractivite);

        assertEquals(secteuractivite, result);
    }

    @Test
    public void testRetrieveSecteurActivite() {
        Long id = 1L; // Replace with the appropriate ID
        SecteurActivite secteuractivite = new SecteurActivite();
        // Initialize secteuractivite as needed

        when(secteurActiviteRepository.findById(id)).thenReturn(Optional.of(secteuractivite));

        SecteurActivite result = secteurActiviteService.retrieveSecteurActivite(id);

        assertEquals(secteuractivite, result);
    }

}