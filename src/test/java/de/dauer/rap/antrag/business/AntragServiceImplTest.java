package de.dauer.rap.antrag.business;

import de.dauer.rap.antrag.business.modell.AntragDTO;
import de.dauer.rap.antrag.business.modell.PartnerDTO;
import de.dauer.rap.antrag.controller.mapper.AntragDTOToAntragEntityMapperImpl;
import de.dauer.rap.antrag.controller.mapper.AntragEntityToAntragDTOMapperImpl;
import de.dauer.rap.antrag.controller.modell.Antrag;
import de.dauer.rap.antrag.controller.modell.AntragErgebnis;
import de.dauer.rap.antrag.controller.modell.Person;
import de.dauer.rap.antrag.repository.AntragRepository;
import de.dauer.rap.antrag.repository.entity.AntragEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AntragServiceImplTest {

    @InjectMocks
    private AntragServiceImpl antragService;

    @Mock
    private AntragRepository antragRepository;

    @Mock
    private AntragDTOToAntragEntityMapperImpl antragMapper;

    @Mock
    private AntragEntityToAntragDTOMapperImpl antragEntityToAntragDTOMapper;

    @Test
    @DisplayName("Wenn Antrag vollständig ist, muss Ergebnis zurückgeliefert werden")
    void test_leseAntragErfolgreich(){
        // when
        int id=702;
        AntragEntity antragEntity=new AntragEntity();
        AntragDTO antragDTO=new AntragDTO();
        when(antragRepository.findById(id)).thenReturn(Optional.of(antragEntity));
        when(antragEntityToAntragDTOMapper.mapAntrag(antragEntity)).thenReturn(antragDTO);

        // act
        AntragDTO ergebnis = antragService.leseAntrag(id);


        // then
        assertThat(ergebnis).isNotNull();
        verify(antragRepository, times(1)).findById(any());
        verify(antragEntityToAntragDTOMapper,times(1)).mapAntrag(any());

    }

    @Test
    @DisplayName("Wenn Antrag nicht gefunden wird, wird keine Exception geworfen")
    void test_leseAntrag_AntragNichtGefundenKeinException(){
//        when
        int id=500;
        when(antragRepository.findById(id)).thenReturn(Optional.empty());

//        act
        assertDoesNotThrow(() -> antragService.leseAntrag(id));

        verify(antragRepository,times(1)).findById(id);
        verify(antragEntityToAntragDTOMapper,times(0)).mapAntrag(null);
    }

    @Test
    @DisplayName("Wenn Antrag enthält Person, ist Antrag valid")
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
    @DisplayName("Wenn in Antrag ohne Person ist, ist Antrag nicht valid")
    void test_istAntragValidFalse(){
        // when
        AntragDTO antragDTO= new AntragDTO();

        // act

        // then
        assertFalse(antragService.istAntragValid(antragDTO));
    }
    @Test
    @DisplayName("Wenn Antrag null ist, ist Antrag nicht valid")
    void test_istAntragValidNull(){
        // when

        // act

        // then
        assertFalse(antragService.istAntragValid(null));
    }

    @Test
    @DisplayName("Wenn in Antrag enthaltene Person unvollständig ist (Vorname oder Nachname null ist), ist Antrag nicht valid")
    void test_istAntragValidFalsePersonUnvollständig(){
        // when
        AntragDTO antragDTO= new AntragDTO();
        PartnerDTO partnerDTO=new PartnerDTO();
        partnerDTO.setVorname("Tom");
        antragDTO.setPartnerDTO(partnerDTO);
        // act

        // then
        assertTrue(antragService.istAntragValid(antragDTO));
    }
    @Test
    @DisplayName("Antrag id muss > 0 sein")
    void test_istAntragIdValidFalse(){
        // when
        int antragId=10;
        // act
        // then
        assertTrue(antragService.istAntragIdValid(antragId));
    }


    @Test
    @DisplayName("When Antrag id 0 ist, muss 400 zurück geliefert werden")
    void test_istAntragIdValid10000(){
        // when
        int antragId=0;
        // act
        // then
        assertFalse(antragService.istAntragIdValid(antragId));
    }
    @Test
    @DisplayName("Testen legeAntragAn")
    void test_legeAntragAn(){
        // when

        AntragEntity antragEntity=new AntragEntity();
        antragEntity.setId(1L);
        AntragDTO antragDTO= new AntragDTO();

        when(antragMapper.mapAntrag(antragDTO)).thenReturn(antragEntity);
        when(antragRepository.save(antragEntity)).thenReturn(antragEntity);
        // act
       AntragErgebnis result = antragService.legeAntragAn(antragDTO);

        // then

        assertThat(result).isNotNull();
        assertThat(result.getAntragId()).isEqualTo(1L);
        assertTrue(result.isIstGenehmigt());

    }
    @Test
    @DisplayName("Wenn Methode bei Ausfürung der legeAntragAn, mapAntrag liefert Null")
    void test_legeAntragAn_mapAntragLiefertNull(){

    }
}