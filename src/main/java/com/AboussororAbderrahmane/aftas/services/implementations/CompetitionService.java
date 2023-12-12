package com.AboussororAbderrahmane.aftas.services.implementations;

import com.AboussororAbderrahmane.aftas.dtos.competition.CompetitionDTO;
import com.AboussororAbderrahmane.aftas.dtos.competition.RequestCompetitionDTO;
import com.AboussororAbderrahmane.aftas.entities.Competition;
import com.AboussororAbderrahmane.aftas.exceptions.InvalidDataException;
import com.AboussororAbderrahmane.aftas.exceptions.NotFoundException;
import com.AboussororAbderrahmane.aftas.repositories.CompetitionRepository;
import com.AboussororAbderrahmane.aftas.services.interfaces.ICompetitionService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class CompetitionService implements ICompetitionService {
    private final ModelMapper modelMapper;
    private final CompetitionRepository competitionRepository;

    @Override
    public List<CompetitionDTO> findAll() {
        log.info("Retrieving all competitions");
        return List.of(modelMapper.map(competitionRepository.findAll(), CompetitionDTO[].class));
    }

    @Override
    public Page<CompetitionDTO> pagination(Pageable pageable) {
        log.info("Retrieving all competitions with pagination");
        Page<Competition> competitions = competitionRepository.findAll(pageable);
        return competitions.map(
                competition -> modelMapper.map(competition, CompetitionDTO.class)
        );
    }

    @Override
    public CompetitionDTO findById(String s) throws NotFoundException {
        log.info("Retrieving one competition");
        Competition competition = competitionRepository.findCompetitionByCode(s)
                .orElseThrow(() -> new NotFoundException("Competition not found"));
        return modelMapper.map(competition, CompetitionDTO.class);
    }

    @Override
    public CompetitionDTO save(RequestCompetitionDTO bean) throws InvalidDataException {
        log.info("Checking if the competition date exists in the database");
        if (competitionRepository.existsByDate(bean.getDate()))
            throw new InvalidDataException("A competition with the same date already exists");

        Competition competition = modelMapper.map(bean, Competition.class);
        log.info("Saving new competition {}", competition.getCode());
        return modelMapper.map(competitionRepository.save(competition), CompetitionDTO.class);
    }

    @Override
    public CompetitionDTO update(String s, RequestCompetitionDTO bean) throws NotFoundException, InvalidDataException {
        log.info("Checking if the competition exists");
        Competition competition = competitionRepository.findCompetitionByCode(s)
                .orElseThrow(() -> new NotFoundException("Competition not found"));

        competition.setAmount(bean.getAmount());
        competition.setLocation(bean.getLocation());
        competition.setStartTime(bean.getStartTime());
        competition.setEndTime(bean.getEndTime());
        competition.setNumberOfParticipants(bean.getNumberOfParticipants());

        log.info("Updating competition {}", competition.getCode());
        return modelMapper.map(competitionRepository.save(competition), CompetitionDTO.class);
    }

    @Override
    public boolean delete(String s) throws NotFoundException {
        return false;
    }
}
