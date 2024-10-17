package com.ibeus.Comanda.Digital.controller;

import com.ibeus.Comanda.Digital.model.Client;
import com.ibeus.Comanda.Digital.repository.ClientRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/clientes")
@CrossOrigin(origins = "http://localhost:4200") // Permitindo requisições do Angular
public class ClientController {

    private final ClientRepository clientRepository;

    // Construtor com a injeção correta
    public ClientController(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    // Endpoint para cadastrar um novo cliente (POST)
    @PostMapping
    public ResponseEntity<Client> cadastrarClient(@RequestBody Client client) {
        Client novoClient = clientRepository.save(client);
        return ResponseEntity.ok(novoClient);
    }

    // Endpoint para listar todos os clientes (GET)
    @GetMapping
    public ResponseEntity<List<Client>> listarClientes() {
        List<Client> clientes = clientRepository.findAll();
        return ResponseEntity.ok(clientes);
    }

    // Endpoint para deletar um cliente pelo ID (DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCliente(@PathVariable Long id) {
        Optional<Client> clienteExistente = clientRepository.findById(id);
        if (clienteExistente.isPresent()) {
            clientRepository.deleteById(id);
            return ResponseEntity.noContent().build();  // 204 No Content
        } else {
            return ResponseEntity.notFound().build();  // 404 Not Found
        }
    }
}
