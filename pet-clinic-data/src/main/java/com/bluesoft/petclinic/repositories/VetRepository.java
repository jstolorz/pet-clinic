package com.bluesoft.petclinic.repositories;

import com.bluesoft.petclinic.model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Vet,Long> {
}
