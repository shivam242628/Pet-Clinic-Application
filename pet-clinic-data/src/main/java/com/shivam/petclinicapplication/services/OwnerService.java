package com.shivam.petclinicapplication.services;


import com.shivam.petclinicapplication.model.Owner;

public interface OwnerService extends CrudService<Owner, Long>{

    Owner findByLastName(String lastName);
}
