package de.dauer.rap.antrag.business;

import de.dauer.rap.antrag.controller.modell.Antrag;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class PersonServiceImplTest {

    @InjectMocks
    PersonServiceImpl personService;

    @Test
    @DisplayName("Erstelle vollName von Vorname und Nachname" )
    void test_createVollname(){
        // when
        String vorname="Ivan";
        String nachname="Ivanov";


        // act

        String vollName=personService.konvertireName(vorname, nachname);
        // then

        assertThat(vollName).isEqualTo("Ivan Ivanov");
    }
    @Test
    @DisplayName("Erstelle vollName wenn Vorname is ' ' und Nachname is ' '" )
    void test_createVollnameRaumzeichen(){
        // when
        String vorname=" ";
        String nachname=" ";
        // act
        String vollName=personService.konvertireName(vorname, nachname);
        // then
        assertThat(vollName).isNotNull();
        assertThat(vollName).isEqualTo("   ");
    }

    @Test
    @DisplayName("Erstelle vollName wenn Vorname ist ' ' und Nachname ist ' '" )
    void test_createVollnameNull(){
        // when
        String vorname=null;
        String nachname=null;
        // act
        String vollName=personService.konvertireName(vorname, nachname);
        // then
        assertThat(vollName).isNull();
    }
    @Test
    @DisplayName("Erstelle vollName wenn Vorname ist ' ' und Nachname ist ' '" )
    void test_createVollnameNull1(){
        // when
        String vorname=null;
        String nachname="null";
        // act
        String vollName=personService.konvertireName(vorname, nachname);
        // then
        assertThat(vollName).isNotNull();
    }
    @Test
    @DisplayName("Erstelle vollName wenn Vorname ist ' ' und Nachname ist ' '" )
    void test_createVollnameNachnameNull(){
        // when
        String vorname="Max";
        String nachname=null;
        // act
        String vollName=personService.konvertireName(vorname, nachname);
        // then
        assertThat(vollName).isNotNull();
    }
    @Test
    @DisplayName("Erstelle vollName wenn Vorname ist ' ' und Nachname ist ' '" )
    void test_createVollnameVornameNull(){
        // when
        String vorname=null;
        String nachname="Ivanov";
        // act
        String vollName=personService.konvertireName(vorname, nachname);
        // then
        assertThat(vollName).isNotNull();
    }
    private static Stream<Arguments> konvertiereNameKonstallation() {
        return Stream.of(
                Arguments.of(null, null, null),
                Arguments.of("Ivan", "Ivanov", "Ivan Ivanov")
//                Arguments.of("  ", true),
//                Arguments.of("not blank", false)
        );
    }
    @ParameterizedTest
    @MethodSource("konvertiereNameKonstallation")
    void test_konvertiereName(String vorname, String nachname, String vollName){
        assertThat(personService.konvertireName(vorname,nachname)).isEqualTo(vollName);
    }


}