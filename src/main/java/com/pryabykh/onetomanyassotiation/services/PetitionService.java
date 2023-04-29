package com.pryabykh.onetomanyassotiation.services;

import com.pryabykh.onetomanyassotiation.entities.Petition;
import com.pryabykh.onetomanyassotiation.repositories.PetitionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PetitionService {
    private final PetitionRepository petitionRepository;

    public List<Petition> findAll(Sort sort) {
        return petitionRepository.findAll(sort);
    }
}
