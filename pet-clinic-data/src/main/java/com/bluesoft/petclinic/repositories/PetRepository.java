package com.bluesoft.petclinic.repositories;

import com.bluesoft.petclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet ,Long> {
}
