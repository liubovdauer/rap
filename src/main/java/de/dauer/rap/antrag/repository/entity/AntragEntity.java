package de.dauer.rap.antrag.repository.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.time.LocalDate;

@Entity
@Table(name="antrag")
public class AntragEntity {

    @Id
//    @SequenceGenerator(name="antragSequence", sequenceName="antragSequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String antrags_nummer;

    private LocalDate erstelldatum;

    private String businesspartnerid;

    //    @JsonIgnore
    @OneToOne(mappedBy ="antrag", cascade = CascadeType.ALL)
    private PersonEntity person;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAntrags_nummer() {
        return antrags_nummer;
    }

    public void setAntrags_nummer(String antrags_nummer) {
        this.antrags_nummer = antrags_nummer;
    }

    public LocalDate getErstelldatum() {
        return erstelldatum;
    }

    public void setErstelldatum(LocalDate erstelldatum) {
        this.erstelldatum = erstelldatum;
    }

    public String getBusinesspartnerid() {
        return businesspartnerid;
    }

    public void setBusinesspartnerid(String businesspartnerid) {
        this.businesspartnerid = businesspartnerid;
    }

    public PersonEntity getPerson() {
        return person;
    }

    public void setPerson(PersonEntity person) {
        this.person = person;
    }


}
