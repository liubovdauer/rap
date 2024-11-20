package de.dauer.rap.antrag.controller.modell;


public class Person {

    private String vorname;


    private String nachname;

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
