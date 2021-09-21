package com.bluesoft.petclinic.services.map;

import com.bluesoft.petclinic.model.Vet;
import com.bluesoft.petclinic.services.CrudService;

import java.util.Set;

class VetServiceMap extends AbstractMapService<Vet, Long> implements CrudService<Vet,Long> {
    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(final Long id) {
         super.deleteById(id);
    }

    @Override
    public void delete(final Vet object) {
         super.delete(object);
    }

    @Override
    public Vet save(final Vet object) {
        return super.save(object.getId(),object);
    }

    @Override
    public Vet findById(final Long id) {
        return super.findById(id);
    }
}
