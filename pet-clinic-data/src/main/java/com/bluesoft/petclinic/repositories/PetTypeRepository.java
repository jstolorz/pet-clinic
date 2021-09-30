package com.bluesoft.petclinic.repositories;

import com.bluesoft.petclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType,Long> {
}
