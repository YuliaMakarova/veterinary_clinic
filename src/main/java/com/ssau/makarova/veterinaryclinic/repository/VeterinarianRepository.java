package com.ssau.makarova.veterinaryclinic.repository;

import com.ssau.makarova.veterinaryclinic.entity.Veterinarian;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeterinarianRepository extends CrudRepository<Veterinarian, Long> { }
