package de.dauer.rap.antrag.repository;

import de.dauer.rap.antrag.repository.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<PersonEntity, Integer> {
    PersonEntity findByBusinesspartnerid(String businesspartnerid);
}
