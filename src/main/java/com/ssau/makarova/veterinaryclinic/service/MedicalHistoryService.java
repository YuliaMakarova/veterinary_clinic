package com.ssau.makarova.veterinaryclinic.service;

import com.ssau.makarova.veterinaryclinic.entity.MedicalHistory;
import com.ssau.makarova.veterinaryclinic.entity.Veterinarian;
import com.ssau.makarova.veterinaryclinic.repository.MedicalHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MedicalHistoryService {
    private final MedicalHistoryRepository medicalHistoryRepository;

    @Autowired
    public MedicalHistoryService(MedicalHistoryRepository medicalHistoryRepository) {
        this.medicalHistoryRepository = medicalHistoryRepository;
    }

    public MedicalHistory saveMedicalHistory(MedicalHistory medicalHistory) {
        return medicalHistoryRepository.save(medicalHistory);
    }

    public List<MedicalHistory> getAllMedicalHistories() {
        List<MedicalHistory> medicalHistories = new ArrayList<>();
        medicalHistoryRepository.findAll().forEach(medicalHistories::add);
        return medicalHistories;
    }
}
