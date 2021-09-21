package com.bluesoft.petclinic.services;

import com.bluesoft.petclinic.model.Vet;

import java.util.Set;

interface VetService {
    Vet findById(Long id);
    Vet save(Vet vet);
    Set<Vet> findAll();
}
