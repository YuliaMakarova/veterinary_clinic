package com.ssau.makarova.veterinaryclinic.repository;

import com.ssau.makarova.veterinaryclinic.entity.Pet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository extends CrudRepository<Pet, Long> { }

