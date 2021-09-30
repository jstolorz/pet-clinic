package com.bluesoft.petclinic.repositories;

import com.bluesoft.petclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit,Long> {
}
