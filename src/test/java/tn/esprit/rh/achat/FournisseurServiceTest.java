package tn.esprit.rh.achat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import tn.esprit.rh.achat.entities.Fournisseur;
import tn.esprit.rh.achat.repositories.FournisseurRepository;
import tn.esprit.rh.achat.services.FournisseurServiceImpl;

public class FournisseurServiceTest {

    @InjectMocks
    private FournisseurServiceImpl fournisseurService;

    @Mock
    private FournisseurRepository fournisseurRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testRetrieveAllFournisseurs() {
        // Create a list of Fournisseurs for testing
        List<Fournisseur> mockFournisseurs = new ArrayList<>();
        // Add some sample data to the list

        // Mock the behavior of the fournisseurRepository
        when(fournisseurRepository.findAll()).thenReturn(mockFournisseurs);

        // Call the method to be tested
        List<Fournisseur> result = fournisseurService.retrieveAllFournisseurs();

        // Verify that the method is called on the mock repository
        verify(fournisseurRepository, times(1)).findAll();

        // Assert the result
        assertEquals(mockFournisseurs, result);
    }

    @Test
    public void testAddFournisseur() {
        // Create a Fournisseur object for testing
        Fournisseur mockFournisseur = new Fournisseur();
        // Set any required properties on the mockFournisseur

        // Mock the behavior of the fournisseurRepository
        when(fournisseurRepository.save(any(Fournisseur.class))).thenReturn(mockFournisseur);

        // Call the method to be tested
        Fournisseur result = fournisseurService.addFournisseur(mockFournisseur);

        // Verify that the method is called on the mock repository
        verify(fournisseurRepository, times(1)).save(any(Fournisseur.class));

        // Assert the result
        assertEquals(mockFournisseur, result);
    }
}
