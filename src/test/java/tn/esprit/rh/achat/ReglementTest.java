package tn.esprit.rh.achat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import tn.esprit.rh.achat.entities.Reglement;
import tn.esprit.rh.achat.repositories.FactureRepository;
import tn.esprit.rh.achat.repositories.ReglementRepository;
import tn.esprit.rh.achat.services.ReglementServiceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ContextConfiguration(classes = {ReglementServiceImpl.class})
@ExtendWith(SpringExtension.class)
public class ReglementTest {

    @MockBean
    private FactureRepository factureRepository;

    @MockBean
    private ReglementRepository reglementRepository;

    @Autowired
    private ReglementServiceImpl reglementServiceImpl;

    @Test
    void testRetrieveAllReglements() {
        ArrayList<Reglement> reglementList = new ArrayList<>();
        when(reglementRepository.findAll()).thenReturn(reglementList);
        List<Reglement> actualRetrieveAllReglementsResult = reglementServiceImpl.retrieveAllReglements();
        assertSame(reglementList, actualRetrieveAllReglementsResult);
        assertTrue(actualRetrieveAllReglementsResult.isEmpty());
        verify(reglementRepository).findAll();
    }

    @Test
    void testAddReglement() {
        Reglement reglement = new Reglement();
        when(reglementRepository.save(reglement)).thenReturn(reglement);

        Reglement addedReglement = reglementServiceImpl.addReglement(reglement);

        assertSame(reglement, addedReglement);
    }

    // Add more test methods for other functions in ReglementServiceImpl if needed
}
