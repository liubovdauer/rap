package de.dauer.rap.antrag.controller.mapper;

import de.dauer.rap.antrag.business.modell.PartnerDTO;
import de.dauer.rap.antrag.controller.modell.Person;

public interface PersonClientToDTOMapper {
    PartnerDTO mapPerson(Person person);
}
