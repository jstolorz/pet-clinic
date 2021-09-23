package com.bluesoft.petclinic.bootstrap;

import com.bluesoft.petclinic.model.Owner;
import com.bluesoft.petclinic.model.Vet;
import com.bluesoft.petclinic.services.OwnerService;
import com.bluesoft.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(final OwnerService ownerService, final VetService vetService) {

        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(final String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Janusz");
        owner1.setLastName("Stolorz");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Iwona");
        owner2.setLastName("Stolorz");

        ownerService.save(owner2);

        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Sam");
        vet1.setLastName("Alex");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Leon");
        vet2.setLastName("Bold");

        vetService.save(vet2);

        System.out.println("Loaded Vets...");
    }
}
