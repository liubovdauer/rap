package de.dauer.rap.antrag.controller.mapper;

import de.dauer.rap.antrag.business.PersonServiceImpl;
import de.dauer.rap.antrag.business.modell.AntragDTO;
import de.dauer.rap.antrag.business.modell.PartnerDTO;
import de.dauer.rap.antrag.controller.modell.Antrag;
import de.dauer.rap.antrag.controller.modell.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static java.util.Objects.isNull;

@Service
public class AntragClientToDTOMapperImpl implements AntragClientToDTOMapper{
    @Autowired
    private PersonClientToDTOMapperImpl personMapper;

    @Override
    public AntragDTO mapAntrag(Antrag antrag) {
        if(isNull(antrag)) return null;

        AntragDTO antragDTO=new AntragDTO();
        PartnerDTO partnerDTO=personMapper.mapPerson(antrag.getPerson());
        antragDTO.setPartnerDTO(partnerDTO);
        return antragDTO;
    }
}
