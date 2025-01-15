package de.dauer.rap.antrag.controller.mapper;

import de.dauer.rap.antrag.business.modell.PartnerDTO;
import de.dauer.rap.antrag.repository.entity.PersonEntity;
import org.springframework.stereotype.Service;

import static java.util.Objects.isNull;
@Service
public class PersonEntityToPartnerDTOMapperImpl implements PersonEntityToPartnerDTOMapper{
    @Override
    public PartnerDTO mapPeson(PersonEntity person) {

        if(isNull(person)) return null;
        PartnerDTO partnerDTO=new PartnerDTO();
        partnerDTO.setVorname(person.getVorname());
        partnerDTO.setName(person.getName());
        partnerDTO.setVollName(person.getVollname());

        return partnerDTO;
    }
}
