package de.dauer.rap.antrag.controller;

import de.dauer.rap.antrag.controller.modell.AntragErgebnis;
import de.dauer.rap.antrag.controller.modell.Person;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/antrag")
public class AntragController {

    @GetMapping("/{id}")
    public String antragIdLesen(){
        return "Hello";
    }

    @PostMapping()
    public AntragErgebnis antragAnlegen(@RequestBody Person person){
        AntragErgebnis antragErgebnis= new AntragErgebnis();
        antragErgebnis.setAntragId(1L);
        antragErgebnis.setIstGenehmigt(false);
        antragErgebnis.setBusinessPartnerId("AV45GT67");
       return antragErgebnis ;
    }
}
