package de.dauer.rap.antrag.controller.modell;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@Valid
public class Antrag {

    @Valid
    @NotNull
    private Person person;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
