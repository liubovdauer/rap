package de.dauer.rap.antrag.controller.mapper;

import de.dauer.rap.antrag.business.PersonService;
import de.dauer.rap.antrag.business.PersonServiceImpl;
import de.dauer.rap.antrag.business.modell.PartnerDTO;
import de.dauer.rap.antrag.controller.modell.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static java.util.Objects.isNull;

@Service
public class PersonClientToDTOMapperImpl implements PersonClientToDTOMapper{

    @Autowired
    private PersonServiceImpl personService;

    @Override
    public PartnerDTO mapPerson(Person person) {
        if (isNull(person)) return null;
        PartnerDTO partnerDTO= new PartnerDTO();
        partnerDTO.setName(person.getNachname());
        partnerDTO.setVorname(person.getVorname());
        partnerDTO.setVollName(personService.konvertireName(person.getVorname(), person.getNachname()));
        return partnerDTO;
    }
}
