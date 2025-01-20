package de.dauer.rap.antrag.controller;

import de.dauer.rap.antrag.business.AntragService;
import de.dauer.rap.antrag.business.modell.AntragDTO;
import de.dauer.rap.antrag.controller.mapper.AntragClientToDTOMapperImpl;
import de.dauer.rap.antrag.controller.mapper.AntragDTOToClientMapperImpl;
import de.dauer.rap.antrag.controller.modell.Antrag;
import de.dauer.rap.antrag.controller.modell.AntragErgebnis;
import de.dauer.rap.antrag.controller.modell.Person;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import jdk.jfr.ContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static java.util.Objects.isNull;

@RestController
@RequestMapping("/antrag")
public class AntragController {

    @Autowired
    private AntragService antragService;

    @Autowired
    private AntragClientToDTOMapperImpl antragClientToDTOMapper;

    @Autowired
    private AntragDTOToClientMapperImpl antragDTOToClientMapper;

    @Operation(summary = "Den Antrag nach id erhalten", description = " Liefert den Antrag nach id zurück")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "200", description = "Der Antrag ist erfolgreich zurück geliefert.", content={@Content(mediaType = "application/json",schema =
                    @Schema(implementation = Antrag.class))}),
            @ApiResponse(responseCode = "400", description = "Bad Request.", content={@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", description = "Der Antrag wurde nicht gefunden.", content={@Content(mediaType = "application/json")})
    })
    @GetMapping("/{id}")
    public ResponseEntity<Antrag> antragIdLesen(@PathVariable int id){


        if (!antragService.istAntragIdValid(id)){
            return ResponseEntity.badRequest().build();
        }
        AntragDTO antragDTO= antragService.leseAntrag(id);
        if(isNull(antragDTO)){
            return ResponseEntity.notFound().build();
        }
        Antrag antrag=antragDTOToClientMapper.mapAntragDTOToClient(antragDTO);

        return ResponseEntity.ok().body(antrag);

    }

    @Operation(summary = "Einen neuen Antrag anlegen", description = " Einen neuen Antrag anlegen")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "200", description = "Der Antrag ist angekommen."),
            @ApiResponse(responseCode = "400", description = "Bad Request."),
            @ApiResponse(responseCode = "401", description = "Unauthorized Exception.")
    })
    @PostMapping()
    public ResponseEntity<AntragErgebnis> antragAnlegen(@RequestBody @Valid Antrag antrag){

        AntragDTO antragDTO = new AntragDTO();
        antragDTO=antragClientToDTOMapper.mapAntrag(antrag);
        if (antragService.istAntragValid(antragDTO))
            return ResponseEntity.ok().body(antragService.legeAntragAn(antragDTO));
        return ResponseEntity.badRequest().build();

    }
}
