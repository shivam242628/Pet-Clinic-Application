package com.shivam.petclinicapplication.bootstrap;

import com.shivam.petclinicapplication.model.Owner;
import com.shivam.petclinicapplication.model.PetType;
import com.shivam.petclinicapplication.model.Vet;
import com.shivam.petclinicapplication.services.OwnerService;
import com.shivam.petclinicapplication.services.PetTypeService;
import com.shivam.petclinicapplication.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Shivam");
        owner1.setLastName("Srivastava");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Arpit");
        owner2.setLastName("Srivastava");

        ownerService.save(owner2);

        System.out.println("Loading Owners...");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Ritesh Kumar");
        vet1.setLastName("Parag");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Prateek");
        vet2.setLastName("Kansal");

        vetService.save(vet2);

        System.out.println("Loading Vets...");
    }
}
