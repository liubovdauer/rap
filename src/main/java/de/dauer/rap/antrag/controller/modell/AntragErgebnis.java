package de.dauer.rap.antrag.controller.modell;

public class AntragErgebnis {
    private boolean istGenehmigt;
    private String businessPartnerId;
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
