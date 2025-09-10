package com.example.personneapp.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Personne {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private Integer age;
    
    // Constructeur par défaut nécessaire pour Spring
    public Personne() {}
    
    public Personne(String nom, Integer age) {
        this.nom = nom;
        this.age = age;
    }
}

