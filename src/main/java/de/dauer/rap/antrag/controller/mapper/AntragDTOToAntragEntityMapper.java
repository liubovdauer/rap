package de.dauer.rap.antrag.controller.mapper;

import de.dauer.rap.antrag.business.modell.AntragDTO;
import de.dauer.rap.antrag.repository.entity.AntragEntity;

public interface AntragDTOToAntragEntityMapper {
    AntragEntity mapAntrag(AntragDTO antragDTO);
}
