package com.bluesoft.petclinic.bootstrap;

import com.bluesoft.petclinic.model.Owner;
import com.bluesoft.petclinic.model.PetType;
import com.bluesoft.petclinic.model.Vet;
import com.bluesoft.petclinic.services.OwnerService;
import com.bluesoft.petclinic.services.PetTypeService;
import com.bluesoft.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(final OwnerService ownerService, final VetService vetService, final PetTypeService petTypeService) {

        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(final String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Zoja");
        final PetType savedPetType = petTypeService.save(dog);

        PetType dog2 = new PetType();
        dog.setName("Tymek");
        final PetType savedPetType2 = petTypeService.save(dog2);


        Owner owner1 = new Owner();
        owner1.setFirstName("Janusz");
        owner1.setLastName("Stolorz");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Iwona");
        owner2.setLastName("Stolorz");

        ownerService.save(owner2);

        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Alex");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Leon");
        vet2.setLastName("Bold");

        vetService.save(vet2);

        System.out.println("Loaded Vets...");
    }
}
