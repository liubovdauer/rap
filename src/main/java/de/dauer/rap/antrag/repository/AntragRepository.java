package de.dauer.rap.antrag.repository;




import de.dauer.rap.antrag.repository.entity.AntragEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AntragRepository extends JpaRepository<AntragEntity, Integer> {


}
