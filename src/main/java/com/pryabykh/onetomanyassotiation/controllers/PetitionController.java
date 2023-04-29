package com.pryabykh.onetomanyassotiation.controllers;

import com.pryabykh.onetomanyassotiation.entities.Petition;
import com.pryabykh.onetomanyassotiation.services.PetitionService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/petitions")
public class PetitionController {
    private final PetitionService petitionService;

    @GetMapping("")
    public List<Petition> getAllPetitions(Sort sort) {
        return petitionService.findAll(sort);
    }


}
