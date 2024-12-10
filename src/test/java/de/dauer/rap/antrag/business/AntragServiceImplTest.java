package de.dauer.rap.antrag.business;

import de.dauer.rap.antrag.business.modell.AntragDTO;
import de.dauer.rap.antrag.business.modell.PartnerDTO;
import de.dauer.rap.antrag.controller.modell.Antrag;
import de.dauer.rap.antrag.controller.modell.AntragErgebnis;
import de.dauer.rap.antrag.controller.modell.Person;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class AntragServiceImplTest {

    @InjectMocks
    private AntragServiceImpl antragService;

    @Test
    @DisplayName("Wenn Antrag vollständig ist, muss 200 zurück geliefert werden")
    void leseAntragTest(){
        // when
        int id=10001;
        // act
        AntragDTO antragDTO = antragService.leseAntrag(id);

        // then
        assertThat(antragDTO).isNotNull();
        assertThat(antragDTO.getPartnerDTO()).isNotNull();
        assertThat(antragDTO.getPartnerDTO().getName()).isEqualTo("Dauer");
    }

    @Test
    @DisplayName("Wenn Antrag enthält Person, muss 200 zurück geliefert werden")
    void test_istAntragValidTrue(){
        // when
        AntragDTO antragDTO= new AntragDTO();
        PartnerDTO partnerDTO=new PartnerDTO();
        partnerDTO.setVorname("Anton");
        partnerDTO.setName("Antonov");
        antragDTO.setPartnerDTO(partnerDTO);
                // act

        // then
        assertTrue(antragService.istAntragValid(antragDTO));
    }

    @Test
    @DisplayName("Wenn in Antrag enthaltene Person null ist, muss 400 zurück geliefert werden")
    void test_istAntragValidFalse(){
        // when
        AntragDTO antragDTO= new AntragDTO();

        // act

        // then
        assertFalse(antragService.istAntragValid(antragDTO));
    }
    @Test
    @DisplayName("Wenn in Antrag enthaltene Person null ist, muss 400 zurück geliefert werden")
    void test_istAntragValidNull(){
        // when

        // act

        // then
        assertFalse(antragService.istAntragValid(null));
    }

    @Test
    @DisplayName("Wenn in Antrag enthaltene Person unvollständig ist (Vorname oder Nachname null ist), muss 400 zurück geliefert werden")
    void test_istAntragValidFalsePersonUnvollständig(){
        // when
        AntragDTO antragDTO= new AntragDTO();
        PartnerDTO partnerDTO=new PartnerDTO();
        partnerDTO.setVorname("Tom");
        antragDTO.setPartnerDTO(partnerDTO);
        // act

        // then
        assertFalse(antragService.istAntragValid(antragDTO));
    }
    @Test
    @DisplayName("When Antrag id <10000 ist, muss 400 zurück geliefert werden")
    void test_istAntragIdValidFalse(){
        // when
        int antragId=10;
        // act
        // then
        assertFalse(antragService.istAntragIdValid(antragId));
    }

    @Test
    @DisplayName("When Antrag id >10000 ist, muss 200 zurück geliefert werden")
    void test_istAntragIdValidTrue(){
        // when
        int antragId=10001;
        // act
        // then
        assertTrue(antragService.istAntragIdValid(antragId));
    }

    @Test
    @DisplayName("When Antrag id =10000 ist, muss 400 zurück geliefert werden")
    void test_istAntragIdValid10000(){
        // when
        int antragId=10000;
        // act
        // then
        assertFalse(antragService.istAntragIdValid(antragId));
    }
    @Test
    @DisplayName("")
    void test_legeAntragAn(){
        // when
        AntragDTO input= new AntragDTO();

        // act
       AntragErgebnis result = antragService.legeAntragAn(input);
        // then
        assertThat(result).isNotNull();
        assertThat(result.getAntragId()).isEqualTo(1L);
        assertThat(result.getBusinessPartnerId()).isEqualTo("AV45GT67");
        assertThat(result.isIstGenehmigt()).isFalse();
    }
}