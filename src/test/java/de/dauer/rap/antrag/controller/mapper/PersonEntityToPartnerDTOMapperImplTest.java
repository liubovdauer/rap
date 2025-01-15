package de.dauer.rap.antrag.controller.mapper;

import de.dauer.rap.antrag.business.modell.PartnerDTO;
import de.dauer.rap.antrag.repository.entity.PersonEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class PersonEntityToPartnerDTOMapperImplTest {

    @InjectMocks
    private PersonEntityToPartnerDTOMapperImpl personEntityToPartnerDTOMapper;

    @Test
    @DisplayName("Mapping personEntity to partnerDTO mi allen Attributen")
    void test_personEntityToPartnerDTOMitAllenAttributen(){
//        when
        PersonEntity personEntity=new PersonEntity();
        personEntity.setVorname("Liuba");
        personEntity.setName("Dauer");
        personEntity.setVollname("Liubov Dauer");
//        act
        PartnerDTO partnerDTO=personEntityToPartnerDTOMapper.mapPeson(personEntity);
//        then
        assertThat(partnerDTO.getVorname()).isEqualTo("Liuba");
        assertThat(partnerDTO.getName()).isEqualTo("Dauer");
        assertThat(partnerDTO.getVollName()).isEqualTo("Liubov Dauer");
    }

    @Test
    @DisplayName("Mapping wenn personEntity null ist")
    void test_personEntityToPartnerDTOWennPersonEntityNullIst(){
//        act
        PartnerDTO partnerDTO=personEntityToPartnerDTOMapper.mapPeson(null);
//        then
        assertThat(partnerDTO).isNull();
    }

    @Test
    @DisplayName("Mapping personEntity to partnerDTO wenn Name null ist")
    void test_personEntityToPartnerDTOWennNameNullIst(){
//        when
        PersonEntity personEntity=new PersonEntity();
        personEntity.setVorname("Liuba");
        personEntity.setVollname("Liubov Dauer");
//        act
        PartnerDTO partnerDTO=personEntityToPartnerDTOMapper.mapPeson(personEntity);
//        then
        assertThat(partnerDTO.getVorname()).isEqualTo("Liuba");
        assertThat(partnerDTO.getName()).isNull();
        assertThat(partnerDTO.getVollName()).isEqualTo("Liubov Dauer");

    }
}