package com.AboussororAbderrahmane.aftas.services.implementations;

import com.AboussororAbderrahmane.aftas.dtos.ranking.RankingDTO;
import com.AboussororAbderrahmane.aftas.dtos.ranking.RequestRankingDTO;
import com.AboussororAbderrahmane.aftas.entities.Competition;
import com.AboussororAbderrahmane.aftas.entities.Member;
import com.AboussororAbderrahmane.aftas.entities.Ranking;
import com.AboussororAbderrahmane.aftas.entities.RankingId;
import com.AboussororAbderrahmane.aftas.exceptions.InvalidDataException;
import com.AboussororAbderrahmane.aftas.exceptions.NotFoundException;
import com.AboussororAbderrahmane.aftas.repositories.CompetitionRepository;
import com.AboussororAbderrahmane.aftas.repositories.MemberRepository;
import com.AboussororAbderrahmane.aftas.repositories.RankingRepository;
import com.AboussororAbderrahmane.aftas.services.interfaces.IRankingService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@Transactional
@RequiredArgsConstructor
public class RankingService implements IRankingService {
    private final ModelMapper modelMapper;
    private final RankingRepository rankingRepository;
    private final CompetitionRepository competitionRepository;
    private final MemberRepository memberRepository;

    @Override
    public List<RankingDTO> findAll() {
        log.info("Retrieving all rankings");
        return List.of(modelMapper.map(rankingRepository.findAll(), RankingDTO[].class));
    }

    @Override
    public RankingDTO findById(RankingId rankingId) throws NotFoundException {
        log.info("Retrieving one rank");
        Ranking ranking = rankingRepository.findById(rankingId)
                .orElseThrow(() -> new NotFoundException("Rank not found"));
        return modelMapper.map(ranking, RankingDTO.class);
    }

    @Override
    public RankingDTO findByCompetition(String code) throws NotFoundException {
        log.info("Retrieving one rank by competition id");
        Ranking ranking = rankingRepository.findRankingById_CompetitionCode(code)
                .orElseThrow(() -> new NotFoundException("the competition code doesn't exist"));
        return modelMapper.map(ranking, RankingDTO.class);
    }

    @Override
    public RankingDTO save(RequestRankingDTO bean) throws InvalidDataException {
        log.info("Checking if the competition exists");
        Competition competition = competitionRepository.findCompetitionByCode(bean.getCompetitionCode())
                .orElseThrow(() -> new InvalidDataException("Competition id inserted doesn't exist"));
        Member member = memberRepository.findMemberByNum(bean.getMemberNum())
                .orElseThrow(() -> new InvalidDataException("Member id inserted doesn't exist"));

        RankingId rankingId = new RankingId(bean.getMemberNum(), bean.getCompetitionCode());
        Ranking ranking = new Ranking();
        ranking.setId(rankingId);
        ranking.setMember(member);
        ranking.setCompetition(competition);

        log.info("Saving new ranking");
        return modelMapper.map(rankingRepository.save(ranking), RankingDTO.class);
    }

    @Override
    public RankingDTO update(RankingId rankingId, RequestRankingDTO bean) throws NotFoundException, InvalidDataException {
        return null;
    }

    @Override
    public boolean delete(RankingId rankingId) throws NotFoundException {
        log.info("Checking if the rank exists");
        Ranking ranking = rankingRepository.findById(rankingId)
                .orElseThrow(() -> new NotFoundException("Rank not found"));

        log.info("Deleting rank");
        rankingRepository.delete(ranking);
        return true;
    }
}
