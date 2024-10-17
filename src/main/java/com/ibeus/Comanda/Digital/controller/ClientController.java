package com.ibeus.Comanda.Digital.controller;

import com.ibeus.Comanda.Digital.model.Client;
import com.ibeus.Comanda.Digital.repository.ClientRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
}
