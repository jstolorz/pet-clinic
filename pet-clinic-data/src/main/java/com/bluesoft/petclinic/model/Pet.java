package com.bluesoft.petclinic.model;

import java.time.LocalDate;

public class Pet {
    private PetType petType;
    private Owner owner;
    private LocalDate birthDate;

    PetType getPetType() {
        return petType;
    }

    void setPetType(final PetType petType) {
        this.petType = petType;
    }

    Owner getOwner() {
        return owner;
    }

    void setOwner(final Owner owner) {
        this.owner = owner;
    }

    LocalDate getBirthDate() {
        return birthDate;
    }

    void setBirthDate(final LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}
