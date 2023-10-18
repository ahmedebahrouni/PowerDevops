package tn.esprit.rh.achat;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.rh.achat.entities.Reglement;
import tn.esprit.rh.achat.repositories.FactureRepository;
import tn.esprit.rh.achat.repositories.ReglementRepository;
import tn.esprit.rh.achat.services.ReglementServiceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class ReglementTest {

    @InjectMocks
    private ReglementServiceImpl reglementService;

    @Mock
    private FactureRepository factureRepository;

    @Mock
    private ReglementRepository reglementRepository;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testRetrieveAllReglements() {
        List<Reglement> reglements = new ArrayList<>();
        // Add some Reglement objects to the list

        when(reglementRepository.findAll()).thenReturn(reglements);

        List<Reglement> result = reglementService.retrieveAllReglements();

        assertEquals(reglements, result);
    }

    @Test
    public void testAddReglement() {
        Reglement reglement = new Reglement();
        // Initialize reglement as needed

        when(reglementRepository.save(any(Reglement.class))).thenReturn(reglement);

        Reglement result = reglementService.addReglement(reglement);

        assertEquals(reglement, result);
    }

    @Test
    public void testRetrieveReglement() {
        Long id = 1L; // Replace with the appropriate ID
        Reglement reglement = new Reglement();
        // Initialize reglement as needed

        when(reglementRepository.findById(id)).thenReturn(Optional.of(reglement));

        Reglement result = reglementService.retrieveReglement(id);

        assertEquals(reglement, result);
    }

    @Test
    public void testRetrieveReglementByFacture() {
        Long idFacture = 1L; // Replace with the appropriate ID
        List<Reglement> reglements = new ArrayList<>();
        // Add some Reglement objects to the list

        when(reglementRepository.retrieveReglementByFacture(idFacture)).thenReturn(reglements);

        List<Reglement> result = reglementService.retrieveReglementByFacture(idFacture);

        assertEquals(reglements, result);
    }

    @Test
    public void testGetChiffreAffaireEntreDeuxDate() {
        Date startDate = new Date(); // Replace with a specific date
        Date endDate = new Date();   // Replace with a specific date

        float chiffreAffaire = 1000.0f; // Replace with the expected result

        when(reglementRepository.getChiffreAffaireEntreDeuxDate(startDate, endDate)).thenReturn(chiffreAffaire);

        float result = reglementService.getChiffreAffaireEntreDeuxDate(startDate, endDate);

        assertEquals(chiffreAffaire, result, 0.0); // Use 0.0 as the delta for float comparison
    }
}
