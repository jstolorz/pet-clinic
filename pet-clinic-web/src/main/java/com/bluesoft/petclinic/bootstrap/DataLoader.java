package com.bluesoft.petclinic.bootstrap;

import com.bluesoft.petclinic.model.*;
import com.bluesoft.petclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;
    private final VisitService visitService;

    public DataLoader(final OwnerService ownerService, final VetService vetService, final PetTypeService petTypeService, final SpecialtyService specialtyService, final VisitService visitService) {

        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
        this.visitService = visitService;
    }

    @Override
    public void run(final String... args) throws Exception {

        final int size = petTypeService.findAll().size();

        if(size == 0){
            loadData();
        }

    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("dog");
        final PetType savedPetType = petTypeService.save(dog);

        PetType dog2 = new PetType();
        dog.setName("dog");
        final PetType savedPetType2 = petTypeService.save(dog2);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialtyService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialtyService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("dentistry");
        Speciality savedDentistry = specialtyService.save(dentistry);

        Owner owner1 = new Owner();
        owner1.setFirstName("Jan");
        owner1.setLastName("Kowalski");
        owner1.setAddress("Prosta 11");
        owner1.setCity("Chebzie");
        owner1.setTelephone("1232323232");

        Pet janPet = new Pet();
        janPet.setPetType(savedPetType);
        janPet.setOwner(owner1);
        janPet.setBirthDate(LocalDate.now());
        janPet.setName("Zoja");
        owner1.getPets().add(janPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Krystyna");
        owner2.setLastName("Nowak");
        owner2.setAddress("Cicha 3");
        owner2.setCity("Chebzie");
        owner2.setTelephone("12323233423");

        Pet krPet = new Pet();
        krPet.setPetType(savedPetType2);
        krPet.setOwner(owner2);
        krPet.setBirthDate(LocalDate.now());
        krPet.setName("Tymek");
        owner2.getPets().add(krPet);

        ownerService.save(owner2);

        Visit krVisit = new Visit();
        krVisit.setPet(krPet);
        krVisit.setDate(LocalDate.now());
        krVisit.setDescription("Sneezy Kitty");
        visitService.save(krVisit);

        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Alex");
        vet1.getSpecialities().add(savedRadiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Leon");
        vet2.setLastName("Bold");
        vet2.getSpecialities().add(savedSurgery);

        vetService.save(vet2);

        System.out.println("Loaded Vets...");
    }
}
