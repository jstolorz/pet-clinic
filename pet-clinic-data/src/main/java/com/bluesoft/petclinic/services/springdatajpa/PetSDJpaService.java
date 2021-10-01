package com.bluesoft.petclinic.services.springdatajpa;

import com.bluesoft.petclinic.model.Pet;
import com.bluesoft.petclinic.repositories.PetRepository;
import com.bluesoft.petclinic.services.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
@Service
@Profile("springdatajpa")
class PetSDJpaService implements PetService {

    private final PetRepository petRepository;

    PetSDJpaService(final PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Override
    public Set<Pet> findAll() {
        Set<Pet> pets = new HashSet<>();
        petRepository.findAll().forEach(pets::add);
        return pets;
    }

    @Override
    public Pet findById(final Long aLong) {
        return petRepository.findById(aLong).orElse(null);
    }

    @Override
    public Pet save(final Pet object) {
        return petRepository.save(object);
    }

    @Override
    public void delete(final Pet object) {
        petRepository.delete(object);
    }

    @Override
    public void deleteById(final Long aLong) {
       petRepository.deleteById(aLong);
    }
}
