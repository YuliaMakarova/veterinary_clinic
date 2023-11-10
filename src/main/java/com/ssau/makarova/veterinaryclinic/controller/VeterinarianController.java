package com.ssau.makarova.veterinaryclinic.controller;

import com.ssau.makarova.veterinaryclinic.entity.Veterinarian;
import com.ssau.makarova.veterinaryclinic.service.VeterinarianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/veterinary_clinic/veterinarians")
public class VeterinarianController {
    private final VeterinarianService veterinarianService;

    @Autowired
    public VeterinarianController(VeterinarianService veterinarianService) {
        this.veterinarianService = veterinarianService;
    }

    @GetMapping
    public String getAllVeterinarians(Model model) {
        List<Veterinarian> veterinarians = veterinarianService.getAllVeterinarians();
        model.addAttribute("veterinarians", veterinarians);
        model.addAttribute("newVeterinarian", new Veterinarian());
        return "veterinarians";
    }

    @PostMapping("/add")
    public String addVeterinarian(@ModelAttribute Veterinarian newVeterinarian) {
        veterinarianService.saveVeterinarian(newVeterinarian);
        return "redirect:/veterinary_clinic/veterinarians";
    }
}
