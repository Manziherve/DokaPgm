package com.example.personneapp.controller;

import com.example.personneapp.model.Personne;
import com.example.personneapp.service.PersonneService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/personnes")
@CrossOrigin(origins = "*")
public class PersonneController {

    private final PersonneService service;

    public PersonneController(PersonneService service) {
        this.service = service;
    }

    @GetMapping
    public List<Personne> getAll() {
        System.out.println("GET /api/personnes appelé");
        List<Personne> personnes = service.findAll();
        System.out.println("Retour: " + personnes.size() + " personnes");
        return personnes;
    }

    @PostMapping
    public Personne create(@RequestBody Personne p) {
        System.out.println("POST /api/personnes appelé avec: " + p);
        try {
            Personne saved = service.save(p);
            System.out.println("Personne sauvée: " + saved);
            return saved;
        } catch (Exception e) {
            System.err.println("Erreur lors de la sauvegarde: " + e.getMessage());
            e.printStackTrace();
            throw e;
        }
    }
}
