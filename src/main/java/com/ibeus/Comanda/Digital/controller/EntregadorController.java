package com.ibeus.Comanda.Digital.controller;

import com.ibeus.Comanda.Digital.model.Entregador;
import com.ibeus.Comanda.Digital.repository.EntregadorRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/entregadores")
@CrossOrigin(origins = "http://localhost:4200") // Permitindo requisições do Angular
public class EntregadorController {

    private final EntregadorRepository entregadorRepository;

    public EntregadorController(EntregadorRepository entregadorRepository) {
        this.entregadorRepository = entregadorRepository;
    }

    // Endpoint para cadastrar um novo entregador (POST)
    @PostMapping
    public ResponseEntity<Entregador> cadastrarEntregador(@RequestBody Entregador entregador) {
        Entregador novoEntregador = entregadorRepository.save(entregador);
        return ResponseEntity.ok(novoEntregador);
    }

    // Endpoint para listar todos os entregadores (GET)
    @GetMapping
    public ResponseEntity<List<Entregador>> listarEntregadores() {
        List<Entregador> entregadores = entregadorRepository.findAll();
        return ResponseEntity.ok(entregadores);
    }

    // Endpoint para deletar um entregador pelo ID (DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarEntregador(@PathVariable Long id) {
        Optional<Entregador> entregadorExistente = entregadorRepository.findById(id);
        if (entregadorExistente.isPresent()) {
            entregadorRepository.deleteById(id);
            return ResponseEntity.noContent().build();  // 204 No Content
        } else {
            return ResponseEntity.notFound().build();  // 404 Not Found
        }
    }
}
