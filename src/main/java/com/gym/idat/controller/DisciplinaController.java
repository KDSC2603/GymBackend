package com.gym.idat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gym.idat.model.Disciplinas;
import com.gym.idat.services.DisciplinaService;

@RestController //indica que es un Servicio REST
@RequestMapping("/disciplina")
public class DisciplinaController {

    @Autowired
    private DisciplinaService service;

    @PostMapping("/registrar")
    public Disciplinas addDisciplina(@RequestBody Disciplinas disciplinas) {
        return service.save(disciplinas);
    }

    @GetMapping("/lista")
    public List<Disciplinas> findAllCliente() {
        return service.getDisciplinas();
    }

    @GetMapping("/{id}")
    public Disciplinas findDisciplinaById(@PathVariable int id) {
        return service.getDisciplinaById(id);
    }

    @GetMapping("/{nombre}")
    public Disciplinas findDisciplinaByNombre(@PathVariable String nombre) {
        return service.getDisciplinaByNombre(nombre);
    }

    @DeleteMapping("/borrar/{id}")
    public String deleteDisciplina(@PathVariable int id) {
        return service.deleteDisciplina(id);
    }
}
