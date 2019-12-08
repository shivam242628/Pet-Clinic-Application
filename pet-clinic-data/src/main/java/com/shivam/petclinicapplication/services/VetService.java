package com.shivam.petclinicapplication.services;

import com.shivam.petclinicapplication.model.Vet;

import java.util.Set;

public interface VetService {

    Vet findById(Long id);

    Vet save(Vet vet);

    Set<Vet> findAll();
}
