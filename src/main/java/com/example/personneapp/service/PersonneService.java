

package com.example.personneapp.service;

import com.example.personneapp.model.Personne;
import com.example.personneapp.repository.PersonneRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PersonneService {

    private final PersonneRepository repository;

    public PersonneService(PersonneRepository repository) {
        this.repository = repository;
    }

    public Personne save(Personne p) {
        return repository.save(p);
    }

    public List<Personne> findAll() {
        return repository.findAll();
    }

    public long count() {
        return repository.count();
    }
}
