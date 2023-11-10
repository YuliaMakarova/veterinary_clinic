package com.ssau.makarova.veterinaryclinic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/veterinary_clinic")
public class MenuController {

    @GetMapping
    public String showMenu() {
        return "menu";
    }
}

