package de.dauer.rap.antrag.controller.mapper;

import de.dauer.rap.antrag.business.modell.PartnerDTO;
import de.dauer.rap.antrag.repository.entity.PersonEntity;

public interface PersonEntityToPartnerDTOMapper {
    PartnerDTO mapPeson(PersonEntity person);
}
