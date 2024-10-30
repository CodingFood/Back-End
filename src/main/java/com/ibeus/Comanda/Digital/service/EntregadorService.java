package com.ibeus.Comanda.Digital.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ibeus.Comanda.Digital.model.Entregador;
import com.ibeus.Comanda.Digital.repository.EntregadorRepository;

import java.util.List;

@Service
public class EntregadorService {

    @Autowired
    private EntregadorRepository entregadorRepository;

    public List<Entregador> findAll() {
        return entregadorRepository.findAll();
    }

    public Entregador findById(Long id) {
        return entregadorRepository.findById(id).orElseThrow(() -> new RuntimeException("Entregador not found"));
    }

    public Entregador create(Entregador entregador) {
        return entregadorRepository.save(entregador);
    }

    public Entregador update(Long id, Entregador entregadorDetails) {
        Entregador entregador = findById(id);
        entregador.setNome(entregadorDetails.getNome());
        entregador.setPlacaVeiculo(entregadorDetails.getPlacaVeiculo());
        return entregadorRepository.save(entregador);
    }

    public void delete(Long id) {
        Entregador entregador = findById(id);
        entregadorRepository.delete(entregador);
    }
}