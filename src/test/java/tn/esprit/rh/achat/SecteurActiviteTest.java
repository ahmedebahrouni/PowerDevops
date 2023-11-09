package tn.esprit.rh.achat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import tn.esprit.rh.achat.controllers.SecteurActiviteController;
import tn.esprit.rh.achat.entities.SecteurActivite;
import tn.esprit.rh.achat.services.ISecteurActiviteService;

import java.util.Arrays;
import java.util.List;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class SecteurActiviteControllerTest {

    @Mock
    private ISecteurActiviteService secteurActiviteService;

    @InjectMocks
    private SecteurActiviteController secteurActiviteController;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(secteurActiviteController).build();
    }

    @Test
    void testGetSecteurActivite() throws Exception {
        // Arrange
        List<SecteurActivite> secteurActivites = Arrays.asList(new SecteurActivite(), new SecteurActivite());
        when(secteurActiviteService.retrieveAllSecteurActivite()).thenReturn(secteurActivites);

        // Act
        ResultActions resultActions = mockMvc.perform(get("/secteurActivite/retrieve-all-secteurActivite"));

        // Assert
        resultActions.andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(2));
        verify(secteurActiviteService, times(1)).retrieveAllSecteurActivite();
    }

    @Test
    void testRetrieveSecteurActivite() throws Exception {
        // Arrange
        long secteurActiviteId = 1L;
        SecteurActivite secteurActivite = new SecteurActivite();
        when(secteurActiviteService.retrieveSecteurActivite(secteurActiviteId)).thenReturn(secteurActivite);

        // Act
        ResultActions resultActions = mockMvc.perform(get("/secteurActivite/retrieve-secteurActivite/{secteurActivite-id}", secteurActiviteId));

        // Assert
        resultActions.andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(secteurActiviteId));
        verify(secteurActiviteService, times(1)).retrieveSecteurActivite(secteurActiviteId);
    }

    // Add similar tests for other controller methods (addSecteurActivite, removeSecteurActivite, modifySecteurActivite)
    // Use Mockito's when() and verify() methods to set up and verify the behavior of the service mock.
}