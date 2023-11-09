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
class SecteurActiviteTest {

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
    void testAddSecteurActivite() throws Exception {
        // Arrange
        SecteurActivite secteurActivite = new SecteurActivite();
        when(secteurActiviteService.addSecteurActivite(any(SecteurActivite.class))).thenReturn(secteurActivite);

        // Act
        ResultActions resultActions = mockMvc.perform(post("/secteurActivite/add-secteurActivite")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{}"));

        // Assert
        resultActions.andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.idSecteurActivite").exists()); // Adjust this based on the actual structure of your response
        verify(secteurActiviteService, times(1)).addSecteurActivite(any(SecteurActivite.class));
    }

    @Test
    void testRemoveSecteurActivite() throws Exception {
        // Arrange
        long secteurActiviteId = 1L;

        // Act
        ResultActions resultActions = mockMvc.perform(delete("/secteurActivite/remove-secteurActivite/{secteurActivite-id}", secteurActiviteId));

        // Assert
        resultActions.andExpect(status().isOk());
        verify(secteurActiviteService, times(1)).deleteSecteurActivite(secteurActiviteId);
    }

    @Test
    void testModifySecteurActivite() throws Exception {
        // Arrange
        SecteurActivite secteurActivite = new SecteurActivite();
        when(secteurActiviteService.updateSecteurActivite(any(SecteurActivite.class))).thenReturn(secteurActivite);

        // Act
        ResultActions resultActions = mockMvc.perform(put("/secteurActivite/modify-secteurActivite")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{}"));

        // Assert
        resultActions.andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.idSecteurActivite").exists()); // Adjust this based on the actual structure of your response
        verify(secteurActiviteService, times(1)).updateSecteurActivite(any(SecteurActivite.class));
    }
}