package com.ssau.makarova.veterinaryclinic.service;

import com.ssau.makarova.veterinaryclinic.entity.Veterinarian;
import com.ssau.makarova.veterinaryclinic.repository.VeterinarianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VeterinarianService {
    private final VeterinarianRepository veterinarianRepository;

    @Autowired
    public VeterinarianService(VeterinarianRepository veterinarianRepository) {
        this.veterinarianRepository = veterinarianRepository;
    }

    public void saveVeterinarian(Veterinarian veterinarian) {
        veterinarianRepository.save(veterinarian);
    }

    public List<Veterinarian> getAllVeterinarians() {
        List<Veterinarian> veterinarians = new ArrayList<>();
        veterinarianRepository.findAll().forEach(veterinarians::add);
        return veterinarians;
    }

    public Veterinarian getVeterinarianById(Long veterinarianId) {
        Optional<Veterinarian> optionalVeterinarian = veterinarianRepository.findById(veterinarianId);
        return optionalVeterinarian.orElse(null);
    }

}
