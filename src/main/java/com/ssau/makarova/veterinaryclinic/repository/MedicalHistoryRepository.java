package com.ssau.makarova.veterinaryclinic.repository;

import com.ssau.makarova.veterinaryclinic.entity.MedicalHistory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicalHistoryRepository extends CrudRepository<MedicalHistory, Long> { }
