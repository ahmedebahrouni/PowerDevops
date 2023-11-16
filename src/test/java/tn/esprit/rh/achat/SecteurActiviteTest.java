package tn.esprit.rh.achat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import tn.esprit.rh.achat.controllers.SecteurActiviteController;
import tn.esprit.rh.achat.entities.SecteurActivite;
import tn.esprit.rh.achat.services.ISecteurActiviteService;

@ExtendWith(MockitoExtension.class)
public class SecteurActiviteTest {

    @Mock
    private ISecteurActiviteService secteurActiviteService;

    @InjectMocks
    private SecteurActiviteController secteurActiviteController;

    @Test
    public void testGetSecteurActivite() {
        // Arrange
        SecteurActivite secteurActivite = new SecteurActivite();
        secteurActivite.setIdSecteurActivite(1L);
        List<SecteurActivite> secteurActiviteList = Arrays.asList(secteurActivite);

        when(secteurActiviteService.retrieveAllSecteurActivite()).thenReturn(secteurActiviteList);

        // Act
        List<SecteurActivite> result = secteurActiviteController.getSecteurActivite();

        // Assert
        assertEquals(1, result.size());
        assertEquals(1L, result.get(0).getIdSecteurActivite());
    }

    @Test
    public void testRetrieveSecteurActivite() {
        // Arrange
        Long secteurActiviteId = 1L;
        SecteurActivite secteurActivite = new SecteurActivite();
        secteurActivite.setIdSecteurActivite(secteurActiviteId);

        when(secteurActiviteService.retrieveSecteurActivite(secteurActiviteId)).thenReturn(secteurActivite);

        // Act
        SecteurActivite result = secteurActiviteController.retrieveSecteurActivite(secteurActiviteId);

        // Assert
        assertEquals(secteurActiviteId, result.getIdSecteurActivite());
    }

    @Test
    public void testAddSecteurActivite() {
        // Arrange
        SecteurActivite secteurActivite = new SecteurActivite();
        secteurActivite.setIdSecteurActivite(1L);

        when(secteurActiviteService.addSecteurActivite(any(SecteurActivite.class))).thenReturn(secteurActivite);

        // Act
        SecteurActivite result = secteurActiviteController.addSecteurActivite(new SecteurActivite());

        // Assert
        assertEquals(1L, result.getIdSecteurActivite());
    }

    @Test
    public void testRemoveSecteurActivite() {
        // Arrange
        Long secteurActiviteId = 1L;

        // Act
        secteurActiviteController.removeSecteurActivite(secteurActiviteId);

        // Assert
        verify(secteurActiviteService, times(1)).deleteSecteurActivite(secteurActiviteId);
    }

    @Test
    public void testModifySecteurActivite() {
        // Arrange
        SecteurActivite secteurActivite = new SecteurActivite();
        secteurActivite.setIdSecteurActivite(1L);

        when(secteurActiviteService.updateSecteurActivite(any(SecteurActivite.class))).thenReturn(secteurActivite);

        // Act
        SecteurActivite result = secteurActiviteController.modifySecteurActivite(new SecteurActivite());

        // Assert
        assertEquals(1L, result.getIdSecteurActivite());
    }
}
