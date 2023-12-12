package com.AboussororAbderrahmane.aftas.services.implementations;

import com.AboussororAbderrahmane.aftas.dtos.hunting.HuntingDTO;
import com.AboussororAbderrahmane.aftas.dtos.hunting.RequestHuntingDTO;
import com.AboussororAbderrahmane.aftas.entities.Hunting;
import com.AboussororAbderrahmane.aftas.exceptions.InvalidDataException;
import com.AboussororAbderrahmane.aftas.exceptions.NotFoundException;
import com.AboussororAbderrahmane.aftas.repositories.CompetitionRepository;
import com.AboussororAbderrahmane.aftas.repositories.FishRepository;
import com.AboussororAbderrahmane.aftas.repositories.HuntingRepository;
import com.AboussororAbderrahmane.aftas.repositories.MemberRepository;
import com.AboussororAbderrahmane.aftas.services.interfaces.IHuntingService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class HuntingService implements IHuntingService {
    private final ModelMapper modelMapper;
    private final HuntingRepository huntingRepository;
    private final MemberRepository memberRepository;
    private final CompetitionRepository competitionRepository;
    private final FishRepository fishRepository;

    @Override
    public List<HuntingDTO> findAll() {
        log.info("Retrieving all hunting's");
        return List.of(modelMapper.map(huntingRepository.findAll(), HuntingDTO[].class));
    }

    @Override
    public HuntingDTO findById(Integer id) throws NotFoundException {
        log.info("Retrieving one hunting");
        Hunting hunting = huntingRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Hunting not found"));
        return modelMapper.map(hunting, HuntingDTO.class);
    }

    @Override
    public HuntingDTO save(RequestHuntingDTO bean) throws InvalidDataException {

        return null;
    }

    @Override
    public HuntingDTO update(Integer id, RequestHuntingDTO bean) throws NotFoundException, InvalidDataException {
        return null;
    }

    @Override
    public boolean delete(Integer id) throws NotFoundException {
        return false;
    }
}
