package com.bluesoft.petclinic.services.map;

import com.bluesoft.petclinic.model.PetType;
import com.bluesoft.petclinic.services.PetTypeService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
class PetTypeMapService extends AbstractMapService<PetType,Long> implements PetTypeService {
    @Override
    public Set<PetType> findAll() {
        return super.findAll();
    }

    @Override
    public PetType findById(final Long aLong) {
        return super.findById(aLong);
    }

    @Override
    public PetType save(final PetType object) {
        return super.save(object);
    }

    @Override
    public void delete(final PetType object) {
           super.delete(object);
    }

    @Override
    public void deleteById(final Long aLong) {
          super.deleteById(aLong);
    }
}
