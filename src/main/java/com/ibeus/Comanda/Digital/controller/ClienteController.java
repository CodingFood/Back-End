package com.ibeus.Comanda.Digital.controller;

import com.ibeus.Comanda.Digital.model.Cliente;
import com.ibeus.Comanda.Digital.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
@CrossOrigin(origins = "http://localhost:4200")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    // Endpoint para listar todos os clientes
    @GetMapping
    public List<Cliente> getAllClientes() {
        return clienteService.findAll();
    }

    // Endpoint para obter um cliente por ID
    @GetMapping("/{id}")
    public Cliente getClienteById(@PathVariable Long id) {
        return clienteService.findById(id);
    }

    // Endpoint para criar um novo cliente
    @PostMapping
    public Cliente criarCliente(@RequestBody Cliente cliente) {
        return clienteService.save(cliente);
    }

    // Endpoint para atualizar um cliente existente
    @PutMapping("/{id}")
    public Cliente updateCliente(@PathVariable Long id, @RequestBody Cliente cliente) {
        Cliente clienteExistente = clienteService.findById(id);
        if (clienteExistente != null) {
            clienteExistente.setNome(cliente.getNome());
            clienteExistente.setEndereco(cliente.getEndereco());
            return clienteService.save(clienteExistente);
        }
        return null;
    }

    // Endpoint para deletar um cliente
    @DeleteMapping("/{id}")
    public void deleteCliente(@PathVariable Long id) {
        clienteService.delete(id);
    }
}
