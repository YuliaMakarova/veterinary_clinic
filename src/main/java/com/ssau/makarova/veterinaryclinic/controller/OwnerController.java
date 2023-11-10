package com.ssau.makarova.veterinaryclinic.controller;

import com.ssau.makarova.veterinaryclinic.entity.Owner;
import com.ssau.makarova.veterinaryclinic.entity.Pet;
import com.ssau.makarova.veterinaryclinic.entity.Veterinarian;
import com.ssau.makarova.veterinaryclinic.service.OwnerService;
import com.ssau.makarova.veterinaryclinic.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/veterinary_clinic/owners")
public class OwnerController {
    private final OwnerService ownerService;
    private final PetService petService;

    @Autowired
    public OwnerController(OwnerService ownerService, PetService petService) {
        this.ownerService = ownerService;
        this.petService = petService;
    }

    @GetMapping
    public String getAllPets(Model model) {
        List<Owner> owners = ownerService.getAllOwners();
        List<Pet> pets = petService.getAllPets();
        model.addAttribute("pets", pets);
        model.addAttribute("owners", owners);
        model.addAttribute("newOwner", new Owner());
        return "owners";
    }

    @PostMapping("/add")
    public String addOwner(@ModelAttribute("newOwner") @Validated Owner newOwner, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "redirect:/veterinary_clinic/owners";
        }

        Set<Pet> pets = newOwner.getPets();
        newOwner.setPets(new HashSet<>());
        for (Pet pet : pets) {
            Pet newPet = petService.getPetById(pet.getId());
            newOwner.getPets().add(newPet);
        }

        ownerService.saveOwner(newOwner);
        return "redirect:/veterinary_clinic/owners";
    }
}
