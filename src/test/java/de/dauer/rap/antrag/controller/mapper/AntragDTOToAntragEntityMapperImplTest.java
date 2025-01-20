package de.dauer.rap.antrag.controller.mapper;

import de.dauer.rap.antrag.business.modell.AntragDTO;
import de.dauer.rap.antrag.business.modell.PartnerDTO;
import de.dauer.rap.antrag.controller.modell.Antrag;
import de.dauer.rap.antrag.repository.entity.AntragEntity;
import de.dauer.rap.antrag.repository.entity.PersonEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AntragDTOToAntragEntityMapperImplTest {

//    @Autowired
    @InjectMocks
    private AntragDTOToAntragEntityMapperImpl antragDTOToAntragEntityMapper;

    @Spy
    private PartnerDTOToPersonEntityMapperImpl personMapper;

    @Test
    @DisplayName("Mapping AntragDTO to AntragEntity wenn AntragDTO null ist")
    void test_mapAntragIstNull() {
//        when

//        act
        AntragEntity antragEntity = antragDTOToAntragEntityMapper.mapAntrag(null);
//        then

        assertThat(antragEntity).isNull();
    }
    @Test
    @DisplayName("Test wenn Partner null ist ")
    void test_mapAntragDTOToAntragEntityPartnerNull() {
        // when
        AntragDTO antragDTO = new AntragDTO();
        // act
        AntragEntity antragEntity = antragDTOToAntragEntityMapper.mapAntrag(antragDTO);
        // then
        assertThat(antragEntity).isNotNull();
    }

    @Test
    @DisplayName("Mapping AntragDTO to AntragEntity")
    void test_mapAntragDTOToAntragEntity() {
//        when
        AntragDTO antragDTO = new AntragDTO();
        PartnerDTO partnerDTO = new PartnerDTO();
        partnerDTO.setVorname("Robert");
        partnerDTO.setName("Dauer");
        antragDTO.setPartnerDTO(partnerDTO);
//        act
        AntragEntity antragEntity = antragDTOToAntragEntityMapper.mapAntrag(antragDTO);
//        then
        assertThat(antragEntity.getPerson().getVorname()).isEqualTo("Robert");
        assertThat(antragEntity.getPerson().getName()).isEqualTo("Dauer");
        assertThat(antragEntity).isNotNull();
    }
}