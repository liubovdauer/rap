package de.dauer.rap.antrag.controller.modell;

import io.swagger.v3.oas.annotations.media.Schema;

public class AntragErgebnis {

    @Schema(name = "istGenehmigt", example = "true", required = true)
    private boolean istGenehmigt;

    @Schema(name = "antragsNummer", example = "T12H7858874FR", required = false)
    private String antragsNummer;

    @Schema(name = "antragId", example = "123456789542", required = false)
    private Long antragId;

    public void setIstGenehmigt(boolean istGenehmigt){
        this.istGenehmigt=istGenehmigt;
    }

    public boolean isIstGenehmigt(){
        return istGenehmigt;
    }

    public void setAntragsNummer(String businessPartnerId){
        this.antragsNummer=businessPartnerId;
    }

    public String getAntragsNummer(){
        return antragsNummer;
    }

    public void setAntragId(Long antragId) {
        this.antragId = antragId;
    }

    public Long getAntragId() {
        return antragId;
    }
}
