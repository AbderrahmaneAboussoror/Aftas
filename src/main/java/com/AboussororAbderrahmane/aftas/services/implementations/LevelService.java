package com.AboussororAbderrahmane.aftas.services.implementations;

import com.AboussororAbderrahmane.aftas.dtos.LevelDTO;
import com.AboussororAbderrahmane.aftas.entities.Level;
import com.AboussororAbderrahmane.aftas.exceptions.InvalidDataException;
import com.AboussororAbderrahmane.aftas.exceptions.NotFoundException;
import com.AboussororAbderrahmane.aftas.repositories.LevelRepository;
import com.AboussororAbderrahmane.aftas.services.interfaces.ILevelService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public LevelDTO save(LevelDTO bean) throws InvalidDataException {
        log.info("Saving new level {}", bean.getDescription());
        Level level = modelMapper.map(bean, Level.class);

        log.info("Checking if the new level's points are higher than the last inserted level");
        Optional<Level> lastInsertedLevelOptional = levelRepository.findLevelByIdDesc();

        if (lastInsertedLevelOptional.isPresent()) {
            Level lastInsertedLevel = lastInsertedLevelOptional.get();
            if (lastInsertedLevel.getPoints() >= level.getPoints())
                throw new InvalidDataException("The points of the level you are trying to insert should be higher");
        }

        return modelMapper.map(levelRepository.save(level), LevelDTO.class);
    }

    @Override
    public LevelDTO update(Integer integer, LevelDTO bean) throws NotFoundException, InvalidDataException {
        log.info("Checking if the level exists in the database");
        Level level = levelRepository.findById(integer)
                .orElseThrow(() -> new NotFoundException("Level not found"));

        log.info("Checking if the level's points are higher than the last inserted level");
        Optional<Level> lastInsertedLevelOptional = levelRepository.findLevelByIdDesc();

        if (lastInsertedLevelOptional.isPresent()) {
            Level lastInsertedLevel = lastInsertedLevelOptional.get();
            if (lastInsertedLevel.getPoints() > bean.getPoints())
                throw new InvalidDataException("The points of the level you are trying to update should be higher");
        }

        level.setDescription(bean.getDescription());
        level.setPoints(bean.getPoints());

        log.info("Updating level {}", level.getDescription());
        return modelMapper.map(levelRepository.save(level), LevelDTO.class);
    }

    @Override
    public boolean delete(Integer integer) throws NotFoundException {
        log.info("Checking if the level exists in the database");
        Level level = levelRepository.findById(integer)
                .orElseThrow(() -> new NotFoundException("Level not found"));
        levelRepository.delete(level);
        return true;
    }
}
