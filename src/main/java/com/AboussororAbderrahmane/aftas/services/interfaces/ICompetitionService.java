package com.AboussororAbderrahmane.aftas.services.interfaces;

import com.AboussororAbderrahmane.aftas.dtos.competition.CompetitionDTO;
import com.AboussororAbderrahmane.aftas.dtos.competition.RequestCompetitionDTO;
import com.AboussororAbderrahmane.aftas.services.IData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICompetitionService extends IData<CompetitionDTO, RequestCompetitionDTO, String> {
    Page<CompetitionDTO> pagination(Pageable pageable);
}
