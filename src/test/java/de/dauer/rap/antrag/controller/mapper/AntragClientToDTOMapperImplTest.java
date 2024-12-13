package de.dauer.rap.antrag.controller.mapper;

import de.dauer.rap.antrag.business.PersonServiceImpl;
import de.dauer.rap.antrag.business.modell.AntragDTO;
import de.dauer.rap.antrag.business.modell.PartnerDTO;
import de.dauer.rap.antrag.controller.modell.Antrag;
import de.dauer.rap.antrag.controller.modell.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AntragClientToDTOMapperImplTest {

    @InjectMocks
    private AntragClientToDTOMapperImpl antragMapper;

    @Spy
    private PersonClientToDTOMapperImpl personMapper;

    @Test
    @DisplayName("Mapping Antrag to AntragDTO" )
    void test_mapAntragMitAllenAtributen(){
        // when
        Antrag antrag=new Antrag();
        Person person=new Person();
        person.setVorname("Nik");
        person.setNachname("Tomasov");
        antrag.setPerson(person);
//        PartnerDTO partnerDTO=new PartnerDTO();

//        when(personMapper.mapPerson(antrag.getPerson())).thenReturn(partnerDTO);

        // act
        AntragDTO antragDTO=antragMapper.mapAntrag(antrag);

        // then
//        assertThat(antragDTO.getPartnerDTO().getVollName()).isEqualTo("Nik Tomasov");
        assertThat(antragDTO.getPartnerDTO().getVorname()).isEqualTo("Nik");
        assertThat(antragDTO.getPartnerDTO().getName()).isEqualTo("Tomasov");
        assertThat(antragDTO.getPartnerDTO()).isNotNull();

    }
    @Test
    @DisplayName("Mapping Antrag to AntragDTO when Antrag null ist" )
    void test_mapAntragNull(){
        // when
        // act
        AntragDTO antragDTO=antragMapper.mapAntrag(null);
        // then
        assertThat(antragDTO).isNull();
    }
    @Test
    @DisplayName("Mapping Antrag to AntragDTO" )
    void test_mapAntragPersonNull(){
        // when
        Antrag antrag=new Antrag();
        // act
        AntragDTO antragDTO=antragMapper.mapAntrag(antrag);

        // then
        assertThat(antragDTO).isNotNull();
    }
}