package de.dauer.rap.antrag.controller.mapper;

import de.dauer.rap.antrag.business.modell.PartnerDTO;
import de.dauer.rap.antrag.controller.modell.Person;
import de.dauer.rap.antrag.repository.entity.PersonEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PartnerDTOToPersonEntityMapperImplTest {

    @InjectMocks
    private PartnerDTOToPersonEntityMapperImpl partnerDTOToPersonEntityMapper;

    @Test
    @DisplayName("Mapping PartnerDTO to PersonEntity" )
    void test_mapPersonMitAllenAtributen(){
        // when
        PartnerDTO partnerDTO=new PartnerDTO();
        partnerDTO.setVorname("Nik");
        partnerDTO.setName("Tomasov");

        // act
        PersonEntity personEntity=partnerDTOToPersonEntityMapper.mapPerson(partnerDTO);

        // then
        
        assertThat(partnerDTO.getVorname()).isEqualTo("Nik");
        assertThat(partnerDTO.getName()).isEqualTo("Tomasov");

    }

    @Test
    @DisplayName("Mapping PartnerDTO to PersonEntity, Vorname ist null" )
    void test_mapPersonVornameNull(){
        // when
        PartnerDTO partnerDTO=new PartnerDTO();
        partnerDTO.setVorname(null);
        partnerDTO.setName("Dauer");
        partnerDTO.setVollName("Sofia Dauer");

        // act
        PersonEntity personEntity=partnerDTOToPersonEntityMapper.mapPerson(partnerDTO);
        // then
        assertThat(personEntity.getVollname()).isEqualTo("Sofia Dauer");
        assertThat(personEntity.getVorname()).isNull();
        assertThat(personEntity.getName()).isNotNull();
        assertThat(personEntity.getName()).isEqualTo("Dauer");

    }
    @Test
    @DisplayName("When PartnerDTO null wird null erwartet")
    void test_mapPersonWennPartnerDTONull(){
//        when

//        act
        PersonEntity personEntity=partnerDTOToPersonEntityMapper.mapPerson(null);

//        then
        assertThat(personEntity).isNull();
    }
}