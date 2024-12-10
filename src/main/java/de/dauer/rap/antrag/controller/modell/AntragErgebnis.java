package de.dauer.rap.antrag.controller.modell;

import io.swagger.v3.oas.annotations.media.Schema;

public class AntragErgebnis {

    @Schema(name = "istGenehmigt", example = "true", required = true)
    private boolean istGenehmigt;

    @Schema(name = "businessPartnerId", example = "T12H7858874FR", required = false)
    private String businessPartnerId;

    @Schema(name = "antragId", example = "123456789542", required = false)
    private Long antragId;

    public void setIstGenehmigt(boolean istGenehmigt){
        this.istGenehmigt=istGenehmigt;
    }

    public boolean isIstGenehmigt(){
        return istGenehmigt;
    }

    public void setBusinessPartnerId(String businessPartnerId){
        this.businessPartnerId=businessPartnerId;
    }

    public String getBusinessPartnerId(){
        return businessPartnerId;
    }

    public void setAntragId(Long antragId) {
        this.antragId = antragId;
    }

    public Long getAntragId() {
        return antragId;
    }
}
