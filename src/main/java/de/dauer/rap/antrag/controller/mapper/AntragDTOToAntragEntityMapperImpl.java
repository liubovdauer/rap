package de.dauer.rap.antrag.controller.mapper;

import de.dauer.rap.antrag.business.modell.AntragDTO;
import de.dauer.rap.antrag.business.modell.PartnerDTO;
import de.dauer.rap.antrag.controller.modell.Antrag;
import de.dauer.rap.antrag.repository.entity.AntragEntity;
import de.dauer.rap.antrag.repository.entity.PersonEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Random;

import static java.util.Objects.isNull;
@Service
public class AntragDTOToAntragEntityMapperImpl implements AntragDTOToAntragEntityMapper {

    @Autowired
    private PartnerDTOToPersonEntityMapperImpl personMapper;

    @Override
    public AntragEntity mapAntrag(AntragDTO antragDTO) {

        if(isNull(antragDTO)) return null;

        AntragEntity antragEntity=new AntragEntity();

        PersonEntity personEntity=personMapper.mapPerson(antragDTO.getPartnerDTO());
        antragEntity.setPerson(personEntity);
        antragEntity.setErstelldatum(LocalDate.now());
        antragEntity.setAntrags_nummer(randomBpId());
        return antragEntity;
    }

    public String randomBpId(){
        Random rn= new Random();
        int range= 9999999 - 1000000 + 1;
        int randomNum =rn.nextInt(range) + 1000000;  // For 7 digit number
        Random rc = new Random();
        char   c  = (char)(rc.nextInt(26) + 'A');
        return randomNum+""+c;
    }

}
