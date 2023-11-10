package com.ssau.makarova.veterinaryclinic.controller;

import com.ssau.makarova.veterinaryclinic.entity.MedicalHistory;
import com.ssau.makarova.veterinaryclinic.entity.Pet;
import com.ssau.makarova.veterinaryclinic.service.MedicalHistoryService;
import com.ssau.makarova.veterinaryclinic.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/veterinary_clinic/medical_histories")
public class MedicalHistoryController {
    private final MedicalHistoryService medicalHistoryService;
    private final PetService petService;

    @Autowired
    public MedicalHistoryController(PetService petService, MedicalHistoryService medicalHistoryService) {
        this.petService = petService;
        this.medicalHistoryService = medicalHistoryService;
    }

    @GetMapping
    public String getAllMedicalHistories(Model model) {
        List<Pet> pets = petService.getAllPets();
        List<MedicalHistory> medicalHistories  = medicalHistoryService.getAllMedicalHistories();
        model.addAttribute("pets", pets);
        model.addAttribute("medicalHistories", medicalHistories);
        model.addAttribute("newMedicalHistory", new MedicalHistory());
        return "medicalHistories";
    }

    @PostMapping("/add")
    public String addMedicalHistory(@ModelAttribute("newMedicalHistory") @Validated MedicalHistory newMedicalHistory,
                                    BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "redirect:/veterinary_clinic/medical_histories";
        }

        Long petId = newMedicalHistory.getPet().getId();
        Pet pet = petService.getPetById(petId);
        newMedicalHistory.setPet(pet);

        medicalHistoryService.saveMedicalHistory(newMedicalHistory);
        return "redirect:/veterinary_clinic/medical_histories";
    }
}

