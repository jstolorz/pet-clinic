package com.bluesoft.petclinic.services.springdatajpa;

import com.bluesoft.petclinic.model.Vet;
import com.bluesoft.petclinic.repositories.VetRepository;
import com.bluesoft.petclinic.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
class VetSDJpaService implements VetService {

    private final VetRepository vetRepository;

    VetSDJpaService(final VetRepository vetRepository) {
        this.vetRepository = vetRepository;
    }

    @Override
    public Set<Vet> findAll() {
        Set<Vet> vets = new HashSet<>();
        vetRepository.findAll().forEach(vets::add);
        return vets;
    }

    @Override
    public Vet findById(final Long aLong) {
        return vetRepository.findById(aLong).orElse(null);
    }

    @Override
    public Vet save(final Vet object) {
        return vetRepository.save(object);
    }

    @Override
    public void delete(final Vet object) {
        vetRepository.delete(object);
    }

    @Override
    public void deleteById(final Long aLong) {
       vetRepository.deleteById(aLong);
    }
}
