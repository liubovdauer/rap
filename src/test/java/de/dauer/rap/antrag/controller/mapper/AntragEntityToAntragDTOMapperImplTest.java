package de.dauer.rap.antrag.controller.mapper;

import de.dauer.rap.antrag.business.modell.AntragDTO;
import de.dauer.rap.antrag.repository.entity.AntragEntity;
import de.dauer.rap.antrag.repository.entity.PersonEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class AntragEntityToAntragDTOMapperImplTest {

    @InjectMocks
    private AntragEntityToAntragDTOMapperImpl antragEntityToAntragDTOMapper;

    @Spy
    private PersonEntityToPartnerDTOMapperImpl personEntityToPartnerDTOMapper;

    @Test
    @DisplayName("Mapping antragEntity to antragDTO")
    void test_AntragEntityToAntragDTOPositiv(){
//        when
        AntragEntity antragEntity=new AntragEntity();
        PersonEntity personEntity=new PersonEntity();
        personEntity.setVorname("Ivan");
        personEntity.setName("Pupkin");
        personEntity.setVollname("Ivan Pupkin");
        antragEntity.setPerson(personEntity);

//        act
        AntragDTO antragDTO=antragEntityToAntragDTOMapper.mapAntrag(antragEntity);
//        then

        assertThat(antragDTO.getPartnerDTO()).isNotNull();
        assertThat(antragDTO.getPartnerDTO().getVorname()).isEqualTo("Ivan");
        assertThat(antragDTO).isNotNull();
    }

    @Test
    @DisplayName("Mapping antragEntity to antragDTO, wenn AntragEntity null ist")
    void test_AntragEntityToAntragDTOWennAntragEntityNullIst(){
//        whenn

//        act
        AntragDTO antragDTO=antragEntityToAntragDTOMapper.mapAntrag(null);
//        then
        assertThat(antragDTO).isNull();
    }

    @Test
    @DisplayName("Mapping antragEntity to antragDTO wenn personEntity null ist")
    void test_AntragEntityToAntragDTOWennPersonNullIst(){
//        when
        AntragEntity antragEntity=new AntragEntity();
//        act
        AntragDTO antragDTO=antragEntityToAntragDTOMapper.mapAntrag(antragEntity);
//        then
        assertThat(antragDTO).isNotNull();
        assertThat(antragDTO.getPartnerDTO()).isNull();

    }

}