package com.ssau.makarova.veterinaryclinic.entity;

        import jakarta.persistence.*;
        import lombok.Getter;
        import lombok.Setter;

        import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "pet")
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int age;
    private String species;

    @OneToOne(mappedBy = "pet")
    private MedicalHistory medicalHistory;

    @ManyToOne
    private Veterinarian veterinarian;

    @ManyToMany(mappedBy = "pets")
    private Set<Owner> owners;
}

