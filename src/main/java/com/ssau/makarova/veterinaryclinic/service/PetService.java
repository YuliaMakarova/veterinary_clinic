package com.ssau.makarova.veterinaryclinic.service;

import com.ssau.makarova.veterinaryclinic.entity.Pet;
import com.ssau.makarova.veterinaryclinic.entity.Veterinarian;
import com.ssau.makarova.veterinaryclinic.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PetService {

    private final PetRepository petRepository;

    @Autowired
    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    public void savePet(Pet pet) {
        petRepository.save(pet);
    }

    public List<Pet> getAllPets() {
        List<Pet> pets = new ArrayList<>();
        petRepository.findAll().forEach(pets::add);
        return pets;
    }

    public Pet getPetById(Long petId) {
        Optional<Pet> optionalPet = petRepository.findById(petId);
        return optionalPet.orElse(null);
    }
}
