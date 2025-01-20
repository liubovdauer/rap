package de.dauer.rap.antrag.controller.mapper;

import de.dauer.rap.antrag.business.modell.AntragDTO;
import de.dauer.rap.antrag.business.modell.PartnerDTO;
import de.dauer.rap.antrag.repository.entity.AntragEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static java.util.Objects.isNull;

@Service
public class AntragEntityToAntragDTOMapperImpl implements AntragEntityToAntragDTOMapper {

    @Autowired
    private PersonEntityToPartnerDTOMapperImpl personEntityToPartnerDTOMapper;

    @Override
    public AntragDTO mapAntrag(AntragEntity antrag) {
        if(isNull(antrag)) return null;

        AntragDTO antragDTO=new AntragDTO();
        PartnerDTO partnerDTO=personEntityToPartnerDTOMapper.mapPeson(antrag.getPerson());
        antragDTO.setPartnerDTO(partnerDTO);
        return antragDTO;
    }
}
