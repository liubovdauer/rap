package de.dauer.rap.antrag.business.modell;

public class AntragDTO {
    private PartnerDTO partnerDTO;

    public void setPartnerDTO(PartnerDTO partnerDTO){
        this.partnerDTO=partnerDTO;
    }

    public PartnerDTO getPartnerDTO(){
        return partnerDTO;
    }
}
