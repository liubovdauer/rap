package de.dauer.rap.antrag.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.dauer.rap.antrag.business.AntragService;
import de.dauer.rap.antrag.business.PersonServiceImpl;
import de.dauer.rap.antrag.business.modell.AntragDTO;
import de.dauer.rap.antrag.business.modell.PartnerDTO;
import de.dauer.rap.antrag.controller.mapper.AntragClientToDTOMapperImpl;
import de.dauer.rap.antrag.controller.mapper.AntragDTOToClientMapper;
import de.dauer.rap.antrag.controller.mapper.AntragDTOToClientMapperImpl;
import de.dauer.rap.antrag.controller.mapper.PersonClientToDTOMapperImpl;
import de.dauer.rap.antrag.controller.modell.Antrag;
import de.dauer.rap.antrag.controller.modell.AntragErgebnis;
import de.dauer.rap.antrag.controller.modell.Person;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.nio.charset.Charset;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AntragController.class)
class AntragControllerTest {

    @MockBean
    private AntragService antragService;

    @Autowired
    private MockMvc mvc;

    @MockBean
    private AntragClientToDTOMapperImpl antragClientToDTOMapper;

    @MockBean
    private AntragDTOToClientMapperImpl antragDTOToClientMapper;


    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    @DisplayName("Wenn Antrag vollständig ist, muss 200 zurück geliefert werden")
    void test_LegeAntragAn200(@Value("classpath:antrag/antragVollständigPerson.json") final Resource jsonResource) throws Exception {

        //when
        final String jsonRequest= jsonResource.getContentAsString(Charset.defaultCharset());
        AntragDTO antragDTO = new AntragDTO();
        PartnerDTO partnerDTO=new PartnerDTO();
        partnerDTO.setVorname("Max");
        partnerDTO.setName("Musterman");
        antragDTO.setPartnerDTO(partnerDTO);

        when(antragClientToDTOMapper.mapAntrag(any())).thenReturn(antragDTO);
        when(antragService.istAntragValid(antragDTO)).thenReturn(Boolean.TRUE);

        //Act

        mvc.perform(post("/antrag")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonRequest))
                .andExpect(status()
                        .isOk());

    }


    @Test
    @DisplayName("Wenn Antrag nicht vollständig ist, muss 400 zurück geliefert werden")
    void test_AntragAnlegen400() throws Exception {

        //when
        Antrag antrag = new Antrag();
        String antragAsJson = objectMapper.writeValueAsString(antrag);

        //Act
        mvc.perform(post("/antrag")
                .contentType(MediaType.APPLICATION_JSON)
                .content(antragAsJson))
                //Then
                .andExpect(status().isBadRequest());

    }

    @Test
    @DisplayName("Wenn Path Parameter < 10000, muss Bad Request zurück geliefert werden")
    void testAntragLesenId0() throws Exception {

        //when
        AntragDTO antragDTO = new AntragDTO();
        PartnerDTO partnerDTO = new PartnerDTO();
        partnerDTO.setVorname("Artur");
        partnerDTO.setName("Dauer");
        antragDTO.setPartnerDTO(partnerDTO);
        int id = 1;
        Antrag antrag=new Antrag();
        Person person=new Person();
        person.setVorname("Artur");
        person.setNachname("Dauer");
        antrag.setPerson(person);
        when(!antragService.istAntragIdValid(id)).thenReturn(Boolean.FALSE);
        when(antragService.leseAntrag(id)).thenReturn(antragDTO);
        when(antragDTOToClientMapper.mapAntragDTOToClient(antragDTO)).thenReturn(antrag);


        //Act
        mvc.perform(MockMvcRequestBuilders.get("/antrag/{id}",id)
                                          .accept(MediaType.APPLICATION_JSON))
                //Then Bad Request is expexted
                                          .andExpect(status().isBadRequest());

    }

    @Test
    @DisplayName("Wenn Path Parameter = 10000, muss Bad Request zurück geliefert werden")
    void testAntragLesenId10000() throws Exception {

        //when
        AntragDTO antragDTO = new AntragDTO();
        PartnerDTO partnerDTO = new PartnerDTO();
        partnerDTO.setVorname("Artur");
        partnerDTO.setName("Dauer");
        antragDTO.setPartnerDTO(partnerDTO);
        int id = 10000;
        Antrag antrag=new Antrag();
        Person person=new Person();
        person.setVorname("Artur");
        person.setNachname("Dauer");
        antrag.setPerson(person);
        when(!antragService.istAntragIdValid(id)).thenReturn(Boolean.FALSE);
        when(antragService.leseAntrag(id)).thenReturn(antragDTO);
        when(antragDTOToClientMapper.mapAntragDTOToClient(antragDTO)).thenReturn(antrag);


        //Act
        mvc.perform(MockMvcRequestBuilders.get("/antrag/{id}",id)
                        .accept(MediaType.APPLICATION_JSON))
                //Then Bad Request is expexted
                .andExpect(status().isBadRequest());

    }

    @Test
    @DisplayName("Wenn Path Parameter > 10000, muss Antrag zurück geliefert werden")
    void testAntragLesenId10001() throws Exception {

        //when
        AntragDTO antragDTO = new AntragDTO();
        PartnerDTO partnerDTO = new PartnerDTO();
        partnerDTO.setVorname("Artur");
        partnerDTO.setName("Dauer");
        antragDTO.setPartnerDTO(partnerDTO);
        int id = 10001;
        Antrag antrag=new Antrag();
        Person person=new Person();
        person.setVorname("Artur");
        person.setNachname("Dauer");
        antrag.setPerson(person);
        String antragAsJson = objectMapper.writeValueAsString(antrag);
        when(antragService.istAntragIdValid(id)).thenReturn(Boolean.TRUE);
        when(antragService.leseAntrag(id)).thenReturn(antragDTO);
        when(antragDTOToClientMapper.mapAntragDTOToClient(antragDTO)).thenReturn(antrag);

        //Act
        mvc.perform(MockMvcRequestBuilders.get("/antrag/{id}",id)
                        .contentType(MediaType.APPLICATION_JSON).content(antragAsJson))
                //Then Bad Request is expexted
                .andExpect(status().isOk());

    }
}
