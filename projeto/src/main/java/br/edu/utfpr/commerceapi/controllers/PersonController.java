package br.edu.utfpr.commerceapi.controllers;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.utfpr.commerceapi.dto.PersonDTO;
import br.edu.utfpr.commerceapi.models.Person;
import br.edu.utfpr.commerceapi.repositories.PersonRepository;

@RestController
@RequestMapping("/pessoa")
public class PersonController {
    @Autowired
    PersonRepository personRepository;

    /**
     * Obter todas as pessoas do banco.
     */
    @GetMapping(value = { "", "/" })
    public List<Person> getAll() {
        return personRepository.findAll();

    }

    /**
     * Obter 1 pessoa pelo ID
     */
    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable String id) {
        Optional<Person> personOpt = personRepository.findById(UUID.fromString(id));

        return personOpt.isPresent()
                ? ResponseEntity.ok(personOpt.get())
                : ResponseEntity.notFound().build();
    }

    /**
     * Criar uma pessoa na API
     */
    @PostMapping("")
    public ResponseEntity<Object> create(@RequestBody PersonDTO personDTO) {
        var pes = new Person();
        BeanUtils.copyProperties(personDTO, pes);

        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(personRepository.save(pes));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity
                    .status((HttpStatus.BAD_REQUEST))
                    .body("falha ao criar pessoa");
        }

    }

    /**
     * Atualizar 1 pessoa pelo ID
     */
    @PutMapping("/{id}")
    public String update(@PathVariable Long id) {
        return "Pessoa " + id + " atualizada";
    }

    /**
     * Deletar uma pessoa pelo ID
     */
    
    
    
    
    }
