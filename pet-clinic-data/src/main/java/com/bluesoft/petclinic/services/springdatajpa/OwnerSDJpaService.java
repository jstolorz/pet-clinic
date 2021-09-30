package com.bluesoft.petclinic.services.springdatajpa;

import com.bluesoft.petclinic.model.Owner;
import com.bluesoft.petclinic.repositories.OwnerRepository;
import com.bluesoft.petclinic.repositories.PetRepository;
import com.bluesoft.petclinic.repositories.PetTypeRepository;
import com.bluesoft.petclinic.services.OwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Profile("springdatajpa")
class OwnerSDJpaService implements OwnerService {

    private final OwnerRepository ownerRepository;
    private final PetRepository petRepository;
    private final PetTypeRepository petTypeRepository;

    OwnerSDJpaService(final OwnerRepository ownerRepository, final PetRepository petRepository,
                      final PetTypeRepository petTypeRepository) {
        this.ownerRepository = ownerRepository;
        this.petRepository = petRepository;
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public Set<Owner> findAll() {
        Set<Owner> owners = new HashSet<>();
        ownerRepository.findAll().forEach(owners::add);
        return owners;
    }

    @Override
    public Owner findById(final Long aLong) {
        return ownerRepository.findById(aLong).orElse(null);
    }

    @Override
    public Owner save(final Owner object) {
        return ownerRepository.save(object);
    }

    @Override
    public void delete(final Owner object) {
        ownerRepository.delete(object);
    }

    @Override
    public void deleteById(final Long aLong) {
       ownerRepository.deleteById(aLong);
    }

    @Override
    public Owner findByLastName(final String lastName) {
        return ownerRepository.findByLastName(lastName);
    }
}
