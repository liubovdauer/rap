package de.dauer.rap.antrag.controller.mapper;

import de.dauer.rap.antrag.business.modell.AntragDTO;
import de.dauer.rap.antrag.business.modell.PartnerDTO;
import de.dauer.rap.antrag.controller.modell.Antrag;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class AntragDTOToClientMapperImplTest {

    @Autowired
    @InjectMocks
    private AntragDTOToClientMapperImpl antragDTOToClientMapper;

    @Test
    @DisplayName("Mapping AntragDTO to Antrag")
    void test_mapAntragDTOToClient() {
//        when
        AntragDTO antragDTO = new AntragDTO();
        PartnerDTO partnerDTO = new PartnerDTO();
        partnerDTO.setVorname("Robert");
        partnerDTO.setName("Dauer");
        antragDTO.setPartnerDTO(partnerDTO);
//        act
        Antrag antrag = antragDTOToClientMapper.mapAntragDTOToClient(antragDTO);
//        then
        assertThat(antrag.getPerson().getVorname()).isEqualTo("Robert");
        assertThat(antrag.getPerson().getNachname()).isEqualTo("Dauer");
        assertThat(antrag).isNotNull();
    }

    @Test
    @DisplayName("Mapping AntragDTO to Antrag wenn AntragDTO null ist")
    void test_mapAntragDTOToClient_antragDTOIstNull() {
//        when

//        act
        Antrag antrag = antragDTOToClientMapper.mapAntragDTOToClient(null);
//        then

        assertThat(antrag).isNull();
    }


    @Test
    @DisplayName("Test wenn Partner null ist ")
    void test_mapAntragDTOToClientPartnerNull() {
        // when
        AntragDTO antragDTO = new AntragDTO();
        // act
        Antrag antrag = antragDTOToClientMapper.mapAntragDTOToClient(antragDTO);
        // then
        assertThat(antrag).isNotNull();
    }
}