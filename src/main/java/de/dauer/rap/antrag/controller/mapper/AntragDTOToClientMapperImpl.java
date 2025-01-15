package de.dauer.rap.antrag.controller.mapper;

import de.dauer.rap.antrag.business.modell.AntragDTO;
import de.dauer.rap.antrag.controller.modell.Antrag;
import de.dauer.rap.antrag.controller.modell.Person;
import org.springframework.stereotype.Service;

import static java.util.Objects.isNull;

@Service
public class AntragDTOToClientMapperImpl implements AntragDTOToClientMapper{
    @Override
    public Antrag mapAntragDTOToClient(AntragDTO antragDTO) {

        if (antragDTO==null){
            return null;
        }
        if (antragDTO.getPartnerDTO()==null){
            Antrag antrag= new Antrag();
            antrag.setPerson(null);
            return antrag;
        }
        Antrag antrag= new Antrag();
        Person person=new Person();
        person.setVorname(antragDTO.getPartnerDTO().getVorname());
        person.setBusinessPartnerId(antragDTO.getPartnerDTO().getBusinessPartnerId());
        person.setNachname(antragDTO.getPartnerDTO().getName());
        antrag.setPerson(person);

        return antrag;
    }
}
