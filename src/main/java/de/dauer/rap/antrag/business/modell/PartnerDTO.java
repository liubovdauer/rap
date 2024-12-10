package de.dauer.rap.antrag.business.modell;

public class PartnerDTO {

    private String vorname;
    private String name;
    private String vollName;

    public void setVorname(String vorname){
        this.vorname=vorname;
    }

    public String getVorname(){
        return vorname;
    }

    public void setName(String name){
        this.name=name;
    }

    public String getName(){
        return name;
    }
    public void setVollName(String vollName){
        this.vollName=vollName;
    }

    public String getVollName(){
        return vollName;
    }

}
