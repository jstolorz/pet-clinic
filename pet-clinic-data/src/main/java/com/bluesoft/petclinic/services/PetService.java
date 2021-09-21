package com.bluesoft.petclinic.services;

import com.bluesoft.petclinic.model.Pet;

import java.util.Set;

interface PetService {
    Pet findById(Long id);
    Pet save(Pet pet);
    Set<Pet> findAll();
}
