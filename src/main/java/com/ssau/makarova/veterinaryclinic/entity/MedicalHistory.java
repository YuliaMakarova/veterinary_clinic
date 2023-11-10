package com.ssau.makarova.veterinaryclinic.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "medicalhistory")
public class MedicalHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String diagnosis;
    private String description;

    @OneToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;
}

