package com.bluesoft.petclinic.services.map;

import com.bluesoft.petclinic.model.Speciality;
import com.bluesoft.petclinic.services.SpecialitiesService;

import java.util.Set;

class SpecialitiesMapService extends AbstractMapService<Speciality,Long> implements SpecialitiesService {
    @Override
    public Set<Speciality> findAll() {
        return super.findAll();
    }

    @Override
    public Speciality findById(final Long aLong) {
        return super.findById(aLong);
    }

    @Override
    public Speciality save(final Speciality object) {
        return super.save(object);
    }

    @Override
    public void delete(final Speciality object) {
        super.delete(object);
    }

    @Override
    public void deleteById(final Long aLong) {
        super.deleteById(aLong);
    }
}
