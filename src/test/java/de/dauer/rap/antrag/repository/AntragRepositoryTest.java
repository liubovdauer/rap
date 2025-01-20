package de.dauer.rap.antrag.repository;

import de.dauer.rap.antrag.repository.entity.AntragEntity;
import de.dauer.rap.antrag.repository.entity.PersonEntity;
import jakarta.inject.Inject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class AntragRepositoryTest {
    @Autowired
    private AntragRepository antragRepository;


    @Test
    @DisplayName("Methode FindById ergibt Gespeicherte AntragEntity")
    void test_findByIdErfolgreich(){
//        when
        AntragEntity antragEntity=new AntragEntity();
        PersonEntity personEntity=new PersonEntity();
        antragEntity.setAntrags_nummer("456345TZ");
        antragEntity.setPerson(personEntity);
        personEntity.setVorname("Anton");
        personEntity.setName("Antonov");
        personEntity.setVollname("Anton Antonov");
        antragEntity.setPerson(personEntity);

        antragRepository.save(antragEntity);
        Long id =antragEntity.getId();
//        act
        Optional<AntragEntity> resultOptional=antragRepository.findById(id.intValue());
//        Optional<AntragEntity> resultOptional=antragRepository.findById(343);
        //        verify
        assertThat(resultOptional).isPresent();
        AntragEntity antragErgebnis = resultOptional.get();
        assertThat(antragErgebnis.getPerson()).isNotNull();
        assertThat(antragErgebnis.getPerson().getName()).isEqualTo("Antonov");
        assertThat(antragErgebnis.getId()).isEqualTo(id);

    }

    @Test
    @DisplayName("Wenn es zu einer Id kein Antrag vorliegt, wird Ergebnis empty.")
    void test_findById_AntragNichtVorhanden(){
//        when
        AntragEntity antragEntity=new AntragEntity();
        PersonEntity personEntity=new PersonEntity();
        antragEntity.setAntrags_nummer("456345TZ");
        antragEntity.setPerson(personEntity);
        personEntity.setVorname("Anton");
        personEntity.setName("Antonov");
        personEntity.setVollname("Anton Antonov");
        antragEntity.setPerson(personEntity);

        antragRepository.save(antragEntity);
        Long id =antragEntity.getId();
//                act

        Optional<AntragEntity> resultOptional=antragRepository.findById(343);
        //        verify
        assertThat(resultOptional).isEmpty();

    }



}