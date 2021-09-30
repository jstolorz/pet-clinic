package com.bluesoft.petclinic.repositories;

import com.bluesoft.petclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository  extends CrudRepository<Owner,Long> {
}
