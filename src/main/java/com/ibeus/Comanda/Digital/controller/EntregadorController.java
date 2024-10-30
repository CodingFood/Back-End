package com.ibeus.Comanda.Digital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.ibeus.Comanda.Digital.model.Entregador;
import com.ibeus.Comanda.Digital.service.EntregadorService;

import java.util.List;

@RestController
@RequestMapping("/entregadores")
@CrossOrigin(origins = "http://localhost:4200")
public class EntregadorController {

    @Autowired
    private EntregadorService entregadorService;

    @GetMapping
    public List<Entregador> getAllEntregadores() {
        return entregadorService.findAll();
    }

    @GetMapping("/{id}")
    public Entregador getEntregadorById(@PathVariable Long id) {
        return entregadorService.findById(id);
    }

    @PostMapping
    public Entregador createEntregador(@RequestBody Entregador entregador) {
        return entregadorService.create(entregador);
    }

    @PutMapping("/{id}")
    public Entregador updateEntregador(@PathVariable Long id, @RequestBody Entregador entregador) {
        return entregadorService.update(id, entregador);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEntregador(@PathVariable Long id) {
        entregadorService.delete(id);
        return ResponseEntity.noContent().build();
    }
}