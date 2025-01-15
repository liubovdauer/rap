package de.dauer.rap.antrag.controller.mapper;

import de.dauer.rap.antrag.business.modell.PartnerDTO;
import de.dauer.rap.antrag.repository.entity.PersonEntity;
import org.springframework.stereotype.Service;

import static java.util.Objects.isNull;

@Service
public class PartnerDTOToPersonEntityMapperImpl implements PartnerDTOToPersonEntityMapper{
    @Override
    public PersonEntity mapPerson(PartnerDTO partnerDTO) {

        if(isNull(partnerDTO)) return null;

        PersonEntity personEntity=new PersonEntity();
        personEntity.setVorname(partnerDTO.getVorname());
        personEntity.setName(partnerDTO.getName());
        personEntity.setVollname(partnerDTO.getVollName());
        personEntity.setBusinesspartnerid(personEntity.getBusinesspartnerid());
        return personEntity;
    }
}
