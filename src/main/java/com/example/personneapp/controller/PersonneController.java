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
        return service.findAll();
    }

    @PostMapping
    public Personne create(@RequestBody Personne p) {
        return service.save(p);
    }
}
