package de.dauer.rap.antrag.repository;

import de.dauer.rap.antrag.repository.entity.AntragEntity;
import de.dauer.rap.antrag.repository.entity.PersonEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@DataJpaTest
class PersonRepositoryTest {
    @Autowired
    private PersonRepository personRepository;

    @Test
    @DisplayName("Test Methode findById")
    void test_findByBusinesspartnerid(){
        //        when
        PersonEntity personEntity=new PersonEntity();
        personEntity.setBusinesspartnerid("123456");

        personRepository.save(personEntity);
        Optional<PersonEntity> personEntityOptional= Optional.ofNullable(personRepository.findByBusinesspartnerid("123456"));


//        verify
        assertThat(personEntityOptional).isPresent();
        personEntity=personEntityOptional.get();
        assertThat(personEntity.getBusinesspartnerid()).isEqualTo("123456");
        assertThat(personEntity).isNotNull();

    }


}