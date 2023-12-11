package com.AboussororAbderrahmane.aftas.services.implementations;

import com.AboussororAbderrahmane.aftas.dtos.fish.FishDTO;
import com.AboussororAbderrahmane.aftas.dtos.fish.RequestFishDTO;
import com.AboussororAbderrahmane.aftas.entities.Fish;
import com.AboussororAbderrahmane.aftas.entities.Level;
import com.AboussororAbderrahmane.aftas.exceptions.InvalidDataException;
import com.AboussororAbderrahmane.aftas.exceptions.NotFoundException;
import com.AboussororAbderrahmane.aftas.repositories.FishRepository;
import com.AboussororAbderrahmane.aftas.repositories.LevelRepository;
import com.AboussororAbderrahmane.aftas.services.interfaces.IFishService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class FishService implements IFishService {
    private final ModelMapper modelMapper;
    private final FishRepository fishRepository;
    private final LevelRepository levelRepository;

    @Override
    public List<FishDTO> findAll() {
        log.info("Retrieving all fishes");
        return List.of(modelMapper.map(fishRepository.findAll(), FishDTO[].class));
    }

    @Override
    public FishDTO findById(String s) throws NotFoundException {
        log.info("Retrieving one fish");
        Fish fish = fishRepository.findFishByName(s)
                .orElseThrow(() -> new NotFoundException("Fish not found"));
        return modelMapper.map(fish, FishDTO.class);
    }

    @Override
    public FishDTO save(RequestFishDTO bean) throws InvalidDataException {
        Fish fish  = modelMapper.map(bean, Fish.class);
        log.info("Checking if the name already exists");
        Optional<Fish> fishOptional = fishRepository.findFishByName(bean.getName());
        if (fishOptional.isPresent())
            throw new InvalidDataException("This fish already exists in the database");

        log.info("Fetching the level with the code {}", bean.getLevel_code());
        Optional<Level> levelOptional = levelRepository.findById(bean.getLevel_code());
        fish.setLevel(
                levelOptional.orElseThrow(
                        () -> new InvalidDataException("Invalid level code")
                )
        );

        log.info("Saving new fish {}", fish.getName());
        return modelMapper.map(fishRepository.save(fish), FishDTO.class);
    }

    @Override
    public FishDTO update(String s, RequestFishDTO bean) throws NotFoundException, InvalidDataException {
        log.info("Checking if the fish exists");
        Fish fish = fishRepository.findFishByName(bean.getName())
                .orElseThrow(() -> new NotFoundException("Fish not found"));
        fish.setAverageWeight(
                bean.getAverageWeight()
        );

        log.info("Checking if the level exists");
        Optional<Level> levelOptional = levelRepository.findById(bean.getLevel_code());
        fish.setLevel(
                levelOptional.orElseThrow(
                        () -> new NotFoundException("Level not found")
                )
        );

        log.info("Updating fish {}", fish.getName());
        return modelMapper.map(fishRepository.save(fish), FishDTO.class);
    }

    @Override
    public boolean delete(String s) throws NotFoundException {
        return false;
    }
}
