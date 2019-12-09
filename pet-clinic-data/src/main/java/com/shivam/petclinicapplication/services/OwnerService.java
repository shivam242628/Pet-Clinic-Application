package com.shivam.petclinicapplication.services;

import com.shivam.petclinicapplication.model.Owner;

import java.util.Set;

public interface OwnerService extends CrudService<Owner, Long>{

    Owner findByLastName(String lastName);
}
