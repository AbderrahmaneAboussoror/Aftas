package com.AboussororAbderrahmane.aftas.services.implementations;

import com.AboussororAbderrahmane.aftas.dtos.LevelDTO;
import com.AboussororAbderrahmane.aftas.entities.Level;
import com.AboussororAbderrahmane.aftas.exceptions.NotFoundException;
import com.AboussororAbderrahmane.aftas.repositories.LevelRepository;
import com.AboussororAbderrahmane.aftas.services.interfaces.ILevelService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class LevelService implements ILevelService {
    private final ModelMapper modelMapper;
    private final LevelRepository levelRepository;

    @Override
    public List<LevelDTO> findAll() {
        log.info("Retrieving all levels");
        return List.of(modelMapper.map(levelRepository.findAll(), LevelDTO[].class));
    }

    @Override
    public LevelDTO findById(Integer integer) throws NotFoundException {
        log.info("Retrieving one level");
        Level level = levelRepository.findById(integer)
                .orElseThrow(() -> new NotFoundException("Level not found"));
        return modelMapper.map(level, LevelDTO.class);
    }

    @Override
    public LevelDTO save(LevelDTO bean) {
        log.info("Saving new level {}", bean.getDescription());
        return null;
    }

    @Override
    public LevelDTO update(Integer integer, LevelDTO bean) throws NotFoundException {
        return null;
    }

    @Override
    public boolean delete(Integer integer) throws NotFoundException {
        return false;
    }
}
