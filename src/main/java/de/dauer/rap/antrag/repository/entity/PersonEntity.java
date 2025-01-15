package de.dauer.rap.antrag.repository.entity;

import jakarta.persistence.*;

@Entity
@Table(name="Person")
public class PersonEntity {
    @Id
//    @SequenceGenerator(name="personSequence", sequenceName="personSequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getVollname() {
        return vollname;
    }

    public void setVollname(String vollname) {
        this.vollname = vollname;
    }

    public String getBusinesspartnerid() {
        return businesspartnerid;
    }

    public void setBusinesspartnerid(String businesspartnerid) {
        this.businesspartnerid = businesspartnerid;
    }

    public AntragEntity getAntrag() {
        return antrag;
    }

    public void setAntrag(AntragEntity antrag) {
        this.antrag = antrag;
    }

    private String name;

    private String vorname;

    private String vollname;

    private String businesspartnerid;

    @OneToOne
    @JoinColumn(name="antrag_id", referencedColumnName = "id")
    private AntragEntity antrag;

}
