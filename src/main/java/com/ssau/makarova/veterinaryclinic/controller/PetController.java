package com.ssau.makarova.veterinaryclinic.controller;

import com.ssau.makarova.veterinaryclinic.entity.Pet;
import com.ssau.makarova.veterinaryclinic.entity.Veterinarian;
import com.ssau.makarova.veterinaryclinic.service.PetService;
import com.ssau.makarova.veterinaryclinic.service.VeterinarianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/veterinary_clinic/pets")
public class PetController {
    private final PetService petService;
    private final VeterinarianService veterinarianService;

    @Autowired
    public PetController(PetService petService, VeterinarianService veterinarianService) {
        this.petService = petService;
        this.veterinarianService = veterinarianService;
    }

    @GetMapping
    public String getAllPets(Model model) {
        List<Pet> pets = petService.getAllPets();
        List<Veterinarian> veterinarians = veterinarianService.getAllVeterinarians();
        model.addAttribute("pets", pets);
        model.addAttribute("veterinarians", veterinarians);
        model.addAttribute("newPet", new Pet());
        return "pets";
    }

    @PostMapping("/add")
    public String addPet(@ModelAttribute("newPet") @Validated Pet newPet, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "redirect:/veterinary_clinic/pets";
        }

        Long veterinarianId = newPet.getVeterinarian().getId();
        Veterinarian veterinarian = veterinarianService.getVeterinarianById(veterinarianId);
        newPet.setVeterinarian(veterinarian);

        petService.savePet(newPet);
        return "redirect:/veterinary_clinic/pets";
    }
}
