package de.dauer.rap.antrag.controller;

import de.dauer.rap.antrag.controller.modell.Antrag;
import de.dauer.rap.antrag.controller.modell.AntragErgebnis;
import de.dauer.rap.antrag.controller.modell.Person;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/antrag")
public class AntragController {

    @GetMapping("/{id}")
    public String antragIdLesen(){
        return "Hello";
    }

    @PostMapping()

    public ResponseEntity<AntragErgebnis> antragAnlegen(@RequestBody Antrag antrag){
        AntragErgebnis antragErgebnis= new AntragErgebnis();
        antragErgebnis.setAntragId(1L);
        antragErgebnis.setIstGenehmigt(false);
        antragErgebnis.setBusinessPartnerId("AV45GT67");
        if (antrag.getPerson()!=null)
            return ResponseEntity.ok().body(antragErgebnis);
        return ResponseEntity.badRequest().build();
    }
}
