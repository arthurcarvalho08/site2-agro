package com.agromono.controller;

import com.agromono.model.CicloAgricola;
import com.agromono.repository.CicloAgricolaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/plantios")
@CrossOrigin(origins = "*")
public class PlantioController {

    @Autowired
    private CicloAgricolaRepository repository;

    @GetMapping
    public List<CicloAgricola> listar() {
        return repository.findAll();
    }

    @PostMapping
    public CicloAgricola cadastrar(@RequestBody CicloAgricola plantio) {
        return repository.save(plantio);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        repository.deleteById(id);
    }
}