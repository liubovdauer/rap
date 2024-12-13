package de.dauer.rap.antrag.business;


import de.dauer.rap.antrag.business.modell.AntragDTO;
import de.dauer.rap.antrag.business.modell.PartnerDTO;
import de.dauer.rap.antrag.controller.modell.AntragErgebnis;

import org.springframework.stereotype.Service;

@Service
class AntragServiceImpl implements AntragService {

    @Override
    public AntragDTO leseAntrag(int id) {
        AntragDTO antragDTO = new AntragDTO();
        PartnerDTO partnerDTO = new PartnerDTO();
        partnerDTO.setVorname("Artur");
        partnerDTO.setName("Dauer");
        antragDTO.setPartnerDTO(partnerDTO);
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
        return antragId>10000;
    }

    @Override
    public AntragErgebnis legeAntragAn(AntragDTO antragDTO) {
        AntragErgebnis antragErgebnis= new AntragErgebnis();
        antragErgebnis.setAntragId(1L);
        antragErgebnis.setIstGenehmigt(false);
        antragErgebnis.setBusinessPartnerId("AV45GT67");
        return antragErgebnis;
    }

}


