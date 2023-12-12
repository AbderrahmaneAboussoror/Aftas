package com.AboussororAbderrahmane.aftas.services.implementations;

import com.AboussororAbderrahmane.aftas.dtos.competition.CompetitionDTO;
import com.AboussororAbderrahmane.aftas.dtos.competition.RequestCompetitionDTO;
import com.AboussororAbderrahmane.aftas.exceptions.InvalidDataException;
import com.AboussororAbderrahmane.aftas.exceptions.NotFoundException;
import com.AboussororAbderrahmane.aftas.repositories.CompetitionRepository;
import com.AboussororAbderrahmane.aftas.services.interfaces.ICompetitionService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
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
    public CompetitionDTO findById(String s) throws NotFoundException {
        return null;
    }

    @Override
    public CompetitionDTO save(RequestCompetitionDTO bean) throws InvalidDataException {
        return null;
    }

    @Override
    public CompetitionDTO update(String s, RequestCompetitionDTO bean) throws NotFoundException, InvalidDataException {
        return null;
    }

    @Override
    public boolean delete(String s) throws NotFoundException {
        return false;
    }
}
