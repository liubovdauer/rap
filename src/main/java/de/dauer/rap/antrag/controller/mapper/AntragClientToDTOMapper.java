package de.dauer.rap.antrag.controller.mapper;

import de.dauer.rap.antrag.business.modell.AntragDTO;
import de.dauer.rap.antrag.controller.modell.Antrag;

public interface AntragClientToDTOMapper {
    AntragDTO mapAntrag(Antrag antrag);
}
