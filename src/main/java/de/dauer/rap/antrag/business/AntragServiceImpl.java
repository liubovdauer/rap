package de.dauer.rap.antrag.business;


import de.dauer.rap.antrag.business.modell.AntragDTO;
import de.dauer.rap.antrag.business.modell.PartnerDTO;
import de.dauer.rap.antrag.controller.mapper.AntragDTOToAntragEntityMapperImpl;
import de.dauer.rap.antrag.controller.mapper.AntragEntityToAntragDTOMapperImpl;
import de.dauer.rap.antrag.controller.modell.AntragErgebnis;

import de.dauer.rap.antrag.repository.AntragRepository;
import de.dauer.rap.antrag.repository.PersonRepository;
import de.dauer.rap.antrag.repository.entity.AntragEntity;
import de.dauer.rap.antrag.repository.entity.PersonEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Random;

@Service
class AntragServiceImpl implements AntragService {

    @Autowired
    private AntragRepository antragRepository;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private AntragDTOToAntragEntityMapperImpl antragMapper;

    @Autowired
    private AntragEntityToAntragDTOMapperImpl antragEntityToAntragDTOMapper;

//    @Autowired
//    private PersonRepository personRepository;

    @Override
    public AntragDTO leseAntrag(int id) {

        Optional<AntragEntity> antragEntityOptional=antragRepository.findById(id);
        AntragEntity antragEntity=antragEntityOptional.get();

        AntragDTO antragDTO=antragEntityToAntragDTOMapper.mapAntrag(antragEntity);

        return antragDTO;
    }

    @Override
    public boolean istAntragValid(AntragDTO antragDTO) {

        if (antragDTO==null || antragDTO.getPartnerDTO()==null ) {
            return false;
        }
            return antragDTO.getPartnerDTO().getVorname()!= null && antragDTO.getPartnerDTO().getName() != null;
    }

    @Override
    public boolean istAntragIdValid(int antragId) {
        return antragId>1;
    }

    @Override
    public AntragErgebnis legeAntragAn(AntragDTO antragDTO) {

        AntragEntity antragEntity=antragMapper.mapAntrag(antragDTO);
        antragRepository.save(antragEntity);
        Long antragId = antragEntity.getId();

        AntragErgebnis antragErgebnis= new AntragErgebnis();
        antragErgebnis.setIstGenehmigt(false);
        antragErgebnis.setAntragsNummer(antragEntity.getAntrags_nummer());
        antragErgebnis.setAntragId(antragId);
        return antragErgebnis;
    }

}


