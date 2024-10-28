package com.ibeus.Comanda.Digital.service;

import com.ibeus.Comanda.Digital.model.Cliente;
import com.ibeus.Comanda.Digital.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    // Retorna todos os clientes
    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    // Busca um cliente pelo ID
    public Cliente findById(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }

    // Salva ou atualiza um cliente
    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    // Deleta um cliente pelo ID
    public void delete(Long id) {
        clienteRepository.deleteById(id);
    }
}
