package com.ibeus.Comanda.Digital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.ibeus.Comanda.Digital.model.Cozinha;
import com.ibeus.Comanda.Digital.service.CozinhaService;

import java.util.List;

@RestController
@RequestMapping("/cozinhas")
@CrossOrigin(origins = "http://localhost:4200")
public class CozinhaController {

    @Autowired
    private CozinhaService cozinhaService;

    @GetMapping
    public List<Cozinha> getAllCozinhas() {
        return cozinhaService.findAll();
    }

    @GetMapping("/{id}")
    public Cozinha getCozinhaById(@PathVariable Long id) {
        return cozinhaService.findById(id);
    }

    @PostMapping
    public Cozinha createCozinha(@RequestBody Cozinha cozinha) {
        return cozinhaService.create(cozinha);
    }

    @PutMapping("/{id}")
    public Cozinha updateCozinha(@PathVariable Long id, @RequestBody Cozinha cozinha) {
        return cozinhaService.update(id, cozinha);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCozinha(@PathVariable Long id) {
        cozinhaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
