package com.bluesoft.petclinic.bootstrap;

import com.bluesoft.petclinic.model.Owner;
import com.bluesoft.petclinic.model.Pet;
import com.bluesoft.petclinic.model.PetType;
import com.bluesoft.petclinic.model.Vet;
import com.bluesoft.petclinic.services.OwnerService;
import com.bluesoft.petclinic.services.PetTypeService;
import com.bluesoft.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

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
        dog.setName("dog");
        final PetType savedPetType = petTypeService.save(dog);

        PetType dog2 = new PetType();
        dog.setName("dog");
        final PetType savedPetType2 = petTypeService.save(dog2);


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
