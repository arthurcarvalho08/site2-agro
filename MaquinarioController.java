package com.agromono.controller;

import com.agromono.model.Maquinario;
import com.agromono.repository.MaquinarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/maquinarios")
@CrossOrigin(origins = "*")
public class MaquinarioController {

    @Autowired
    private MaquinarioRepository repository;

    @GetMapping
    public List<Maquinario> listar() {
        List<Maquinario> lista = repository.findAll();
        LocalDate hoje = LocalDate.now();
        for (Maquinario m : lista) {
            if (m.getProximaManutencao() != null) {
                m.setAlertaManutencao(!m.getProximaManutencao().isAfter(hoje.plusDays(7)));
            }
        }
        return lista;
    }

    @PostMapping
    public Maquinario cadastrar(@RequestBody Maquinario maquinario) {
        return repository.save(maquinario);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        repository.deleteById(id);
    }
}