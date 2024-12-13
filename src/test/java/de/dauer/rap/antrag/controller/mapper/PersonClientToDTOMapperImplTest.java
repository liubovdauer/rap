package de.dauer.rap.antrag.controller.mapper;

import de.dauer.rap.antrag.business.PersonService;
import de.dauer.rap.antrag.business.PersonServiceImpl;
import de.dauer.rap.antrag.business.modell.PartnerDTO;
import de.dauer.rap.antrag.controller.modell.Person;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PersonClientToDTOMapperImplTest {

    @InjectMocks
    private PersonClientToDTOMapperImpl mapper;

    @Spy
    private PersonServiceImpl personService;

    @Test
    @DisplayName("Mapping Person to PartnerDTO" )
    void test_mapPersonMitAllenAtributen(){
        // when
        Person person=new Person();
        person.setVorname("Nik");
        person.setNachname("Tomasov");
//        when(personService.konvertireName(person.getVorname(), person.getNachname())).thenReturn("Nik Tomasov");

        // act
        PartnerDTO partnerDTO=mapper.mapPerson(person);

        // then
        assertThat(partnerDTO.getVollName()).isEqualTo("Nik Tomasov");
        assertThat(partnerDTO.getVorname()).isEqualTo("Nik");
        assertThat(partnerDTO.getName()).isEqualTo("Tomasov");

    }
    @Test
    @DisplayName("Mapping Person to PartnerDTO, Vorname ist null" )
    void test_mapPersonVornameNull(){
        // when
        Person person=new Person();
        person.setVorname(null);
        person.setNachname(null);
        //when(personService.konvertireName(any(), anyString())).thenReturn("Max");
        when(personService.konvertireName(person.getVorname(), person.getNachname())).thenReturn("Max");
        // act
        PartnerDTO partnerDTO=mapper.mapPerson(person);
        // then
        assertThat(partnerDTO.getVollName()).isEqualTo("Max");
        assertThat(partnerDTO.getVorname()).isNull();
        assertThat(partnerDTO.getName()).isEqualTo("Tomasov");
        verify(personService, times(1)).konvertireName(any(), any());
    }

    @Test
    @DisplayName("Mapping wenn Person null ist, wird null erwartet" )
    void test_mapPersonNull(){
        // act
        assertThat(mapper.mapPerson(null)).isNull();

    }

    @Test
    @DisplayName("Mapping Person to PartnerDTO, Vorname ist null" )
    void test_mapPersonVornameNullNachnameNull(){
        // when
        Person person=new Person();
        person.setVorname(null);
        person.setNachname(null);
        //when(personService.konvertireName(any(), anyString())).thenReturn("");
        when(personService.konvertireName(person.getVorname(), person.getNachname())).thenReturn(null);
        // act
        PartnerDTO partnerDTO=mapper.mapPerson(person);
        // then
        assertThat(partnerDTO.getVollName()).isNull();
        assertThat(partnerDTO.getVorname()).isNull();
        assertThat(partnerDTO.getName()).isNull();
    }

}