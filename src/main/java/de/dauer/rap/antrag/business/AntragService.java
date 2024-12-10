package de.dauer.rap.antrag.business;


import de.dauer.rap.antrag.business.modell.AntragDTO;
import de.dauer.rap.antrag.controller.modell.AntragErgebnis;

public interface AntragService {
    AntragDTO leseAntrag(int id);

    /**
     * Prüft ob Antrag valid ist. Ohne Person nicht valid
     * @param antragDTO Antrag mit Partnerdaten
     * @return Ergebnis, ob Antrag valid ist
     */
    boolean istAntragValid(AntragDTO antragDTO);

    boolean istAntragIdValid(int antragId);

    AntragErgebnis legeAntragAn(AntragDTO antragDTO);
}
