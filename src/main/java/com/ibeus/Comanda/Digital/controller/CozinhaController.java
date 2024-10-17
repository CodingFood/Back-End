package com.ibeus.Comanda.Digital.controller;

import com.ibeus.Comanda.Digital.model.Cozinha;
import com.ibeus.Comanda.Digital.repository.CozinhaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cozinha")
@CrossOrigin(origins = "http://localhost:4200") // Permitindo requisições do Angular
public class CozinhaController {

    private final CozinhaRepository cozinhaRepository;

    // Construtor com injeção de dependência
    public CozinhaController(CozinhaRepository cozinhaRepository) {
        this.cozinhaRepository = cozinhaRepository;
    }

    // Endpoint para cadastrar um novo pedido na cozinha (POST)
    @PostMapping
    public ResponseEntity<Cozinha> cadastrarPedido(@RequestBody Cozinha pedido) {
        Cozinha novoPedido = cozinhaRepository.save(pedido);
        return ResponseEntity.ok(novoPedido);
    }

    // Endpoint para listar todos os pedidos (GET)
    @GetMapping
    public ResponseEntity<List<Cozinha>> listarPedidos() {
        List<Cozinha> pedidos = cozinhaRepository.findAll();
        return ResponseEntity.ok(pedidos);
    }

    // Endpoint para deletar um pedido pelo ID (DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPedido(@PathVariable Long id) {
        Optional<Cozinha> pedidoExistente = cozinhaRepository.findById(id);
        if (pedidoExistente.isPresent()) {
            cozinhaRepository.deleteById(id);
            return ResponseEntity.noContent().build();  // 204 No Content
        } else {
            return ResponseEntity.notFound().build();  // 404 Not Found
        }
    }
}

