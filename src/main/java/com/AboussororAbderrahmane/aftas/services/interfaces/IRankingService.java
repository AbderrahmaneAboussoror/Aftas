package com.AboussororAbderrahmane.aftas.services.interfaces;

import com.AboussororAbderrahmane.aftas.dtos.ranking.RankingDTO;
import com.AboussororAbderrahmane.aftas.dtos.ranking.RequestRankingDTO;
import com.AboussororAbderrahmane.aftas.entities.RankingId;
import com.AboussororAbderrahmane.aftas.services.IData;

public interface IRankingService extends IData<RankingDTO, RequestRankingDTO, RankingId> {
    RankingDTO findByCompetition(String code);
}
