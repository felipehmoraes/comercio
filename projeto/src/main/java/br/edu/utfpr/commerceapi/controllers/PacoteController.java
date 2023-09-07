package br.edu.utfpr.commerceapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.utfpr.commerceapi.repositories.PacoteRepository;

@RestController
@RequestMapping("/pacote")
public class PacoteController {
@Autowired
    PacoteRepository pacoteRepository;

    /**
     * Obter todas as pessoas do banco.
     */
    @GetMapping(value = { "", "/" })
    public List<Pacote> getAll() {
        return pacoteRepository.findAll();

    }

    /**
     * Obter 1 pessoa pelo ID
     */
    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable String id) {
        Optional<Pacote> PacoteOpt = PacoteRepository.findById(UUID.fromString(id));

        return PacoteOpt.isPresent()
                ? ResponseEntity.ok(PacoteOpt.get())
                : ResponseEntity.notFound().build();
    }

    /**
     * Criar uma pessoa na API
     */
    @PostMapping("")
    public ResponseEntity<Object> create(@RequestBody PacoteDTO PacoteDTO) {
        var pes = new Pacote();
        BeanUtils.copyProperties(PacoteDTO, pes);

        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(PacoteRepository.save(pes));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity
                    .status((HttpStatus.BAD_REQUEST))
                    .body("falha ao criar pacote ");
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
