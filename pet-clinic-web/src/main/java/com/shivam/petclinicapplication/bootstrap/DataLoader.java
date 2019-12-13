package com.shivam.petclinicapplication.bootstrap;

import com.shivam.petclinicapplication.model.Owner;
import com.shivam.petclinicapplication.model.Pet;
import com.shivam.petclinicapplication.model.PetType;
import com.shivam.petclinicapplication.model.Vet;
import com.shivam.petclinicapplication.services.OwnerService;
import com.shivam.petclinicapplication.services.PetTypeService;
import com.shivam.petclinicapplication.services.VetService;
import org.apache.tomcat.jni.Local;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

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
        owner1.setAddress("RK Puram");
        owner1.setCity("New Delhi");
        owner1.setTelephone("7777777777");

        Pet cotton = new Pet();
        cotton.setName("Cotton");
        cotton.setPetType(savedDogPetType);
        cotton.setOwner(owner1);
        cotton.setBirthDate(LocalDate.now());
        owner1.getPets().add(cotton);

        Pet shinzo = new Pet();
        shinzo.setName("Shinzo");
        shinzo.setPetType(savedDogPetType);
        shinzo.setOwner(owner1);
        shinzo.setBirthDate(LocalDate.now());
        owner1.getPets().add(shinzo);


        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Arpit");
        owner2.setLastName("Srivastava");
        owner2.setAddress("Indra Nagar");
        owner2.setCity("Lucknow");
        owner2.setTelephone("8888888888");

        Pet myCat = new Pet();
        myCat.setName("Garfield");
        myCat.setOwner(owner2);
        myCat.setPetType(savedCatPetType);
        myCat.setBirthDate(LocalDate.now());
        owner2.getPets().add(myCat);

        myCat = new Pet();
        myCat.setName("Meoww");
        myCat.setOwner(owner2);
        myCat.setPetType(savedCatPetType);
        myCat.setBirthDate(LocalDate.now());
        owner2.getPets().add(myCat);

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
