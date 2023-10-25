package tn.esprit.rh.achat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import tn.esprit.rh.achat.controllers.SecteurActiviteController;
import tn.esprit.rh.achat.entities.SecteurActivite;
import tn.esprit.rh.achat.services.ISecteurActiviteService;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class SecteurActiviteTest {



        @InjectMocks
        private SecteurActiviteController secteurActiviteController;

        @Mock
        private ISecteurActiviteService secteurActiviteService;

        @Autowired
        private MockMvc mockMvc;

        @BeforeEach
        public void setup() {
            MockitoAnnotations.openMocks(this);
        }

        @Test
        public void testGetSecteurActivite() throws Exception {
            // Mock the service method
            List<SecteurActivite> secteurActiviteList = new ArrayList<>();
            secteurActiviteList.add(new SecteurActivite());
            Mockito.when(secteurActiviteService.retrieveAllSecteurActivite()).thenReturn(secteurActiviteList);

            // Perform the GET request to /secteurActivite/retrieve-all-secteurActivite
            mockMvc.perform(MockMvcRequestBuilders.get("/secteurActivite/retrieve-all-secteurActivite")
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk());
        }

        @Test
        public void testRetrieveSecteurActivite() throws Exception {
            // Mock the service method
            Long secteurActiviteId = 1L;
            when(secteurActiviteService.retrieveSecteurActivite(secteurActiviteId)).thenReturn(new SecteurActivite());

            // Perform the GET request to /secteurActivite/retrieve-secteurActivite/{secteurActivite-id}
            mockMvc.perform(MockMvcRequestBuilders.get("/secteurActivite/retrieve-secteurActivite/{secteurActivite-id}", secteurActiviteId)
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk());
        }

        @Test
        public void testAddSecteurActivite() throws Exception {
            SecteurActivite secteurActivite = new SecteurActivite();
            // Mock the service method
            when(secteurActiviteService.addSecteurActivite(secteurActivite)).thenReturn(secteurActivite);

            // Perform the POST request to /secteurActivite/add-secteurActivite
            mockMvc.perform(MockMvcRequestBuilders.post("/secteurActivite/add-secteurActivite")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content("{\"someKey\":\"someValue\"}"))  // Replace with your JSON content
                    .andExpect(status().isOk());
        }

        @Test
        public void testRemoveSecteurActivite() throws Exception {
            // Mock the service method
            Long secteurActiviteId = 1L;
            // Use Mockito's doNothing() when dealing with void methods
            doNothing().when(secteurActiviteService).deleteSecteurActivite(secteurActiviteId);

            // Perform the DELETE request to /secteurActivite/remove-secteurActivite/{secteurActivite-id}
            mockMvc.perform(MockMvcRequestBuilders.delete("/secteurActivite/remove-secteurActivite/{secteurActivite-id}", secteurActiviteId)
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk());
        }

        @Test
        public void testModifySecteurActivite() throws Exception {
            SecteurActivite secteurActivite = new SecteurActivite();
            // Mock the service method
            when(secteurActiviteService.updateSecteurActivite(secteurActivite)).thenReturn(secteurActivite);

            // Perform the PUT request to /secteurActivite/modify-secteurActivite
            mockMvc.perform(MockMvcRequestBuilders.put("/secteurActivite/modify-secteurActivite")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content("{\"someKey\":\"someValue\"}"))  // Replace with your JSON content
                    .andExpect(status().isOk());
        }
    }


