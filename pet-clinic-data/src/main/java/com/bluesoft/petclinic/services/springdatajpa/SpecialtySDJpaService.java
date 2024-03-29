package com.bluesoft.petclinic.services.springdatajpa;

import com.bluesoft.petclinic.model.Speciality;
import com.bluesoft.petclinic.repositories.SpecialityRepository;
import com.bluesoft.petclinic.services.SpecialtyService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
class SpecialtySDJpaService implements SpecialtyService {

    private final SpecialityRepository specialityRepository;

    SpecialtySDJpaService(final SpecialityRepository specialityRepository) {
        this.specialityRepository = specialityRepository;
    }

    @Override
    public Set<Speciality> findAll() {
        Set<Speciality> specialities = new HashSet<>();
        specialityRepository.findAll().forEach(specialities::add);
        return specialities;
    }

    @Override
    public Speciality findById(final Long aLong) {
        return specialityRepository.findById(aLong).orElse(null);
    }

    @Override
    public Speciality save(final Speciality object) {
        return specialityRepository.save(object);
    }

    @Override
    public void delete(final Speciality object) {
       specialityRepository.delete(object);
    }

    @Override
    public void deleteById(final Long aLong) {
        specialityRepository.deleteById(aLong);
    }
}
