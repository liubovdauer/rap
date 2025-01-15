package de.dauer.rap.antrag.controller.modell;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public class Person {

    @Schema(name = "vorname", example = "Tom", required = true)
    @NotNull
    @NotBlank
    private String vorname;

    @Schema(name = "nachname", example = "Hanks", required = false)
    @Valid
    private String nachname;

    @Schema(name="businessPartnerId", example="HZGF65R", required=false)
    @Valid
    private String businessPartnerId;

    public @Valid String getBusinessPartnerId() {
        return businessPartnerId;
    }

    public void setBusinessPartnerId(@Valid String businessPartnerId) {
        this.businessPartnerId = businessPartnerId;
    }

    public String getVorname(){
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public void setNachname(String nachname){
        this.nachname = nachname;
    }
    public String getNachname() {
        return nachname;
    }
}
