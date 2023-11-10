package com.ssau.makarova.veterinaryclinic.repository;

import com.ssau.makarova.veterinaryclinic.entity.Owner;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepository extends CrudRepository<Owner, Long> { }
