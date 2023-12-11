package com.AboussororAbderrahmane.aftas.services.implementations;

import com.AboussororAbderrahmane.aftas.dtos.fish.FishDTO;
import com.AboussororAbderrahmane.aftas.dtos.fish.RequestFishDTO;
import com.AboussororAbderrahmane.aftas.entities.Fish;
import com.AboussororAbderrahmane.aftas.exceptions.InvalidDataException;
import com.AboussororAbderrahmane.aftas.exceptions.NotFoundException;
import com.AboussororAbderrahmane.aftas.repositories.FishRepository;
import com.AboussororAbderrahmane.aftas.services.interfaces.IFishService;
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
public class FishService implements IFishService {
    private final ModelMapper modelMapper;
    private final FishRepository fishRepository;

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
        return null;
    }

    @Override
    public FishDTO update(String s, RequestFishDTO bean) throws NotFoundException, InvalidDataException {
        return null;
    }

    @Override
    public boolean delete(String s) throws NotFoundException {
        return false;
    }
}
