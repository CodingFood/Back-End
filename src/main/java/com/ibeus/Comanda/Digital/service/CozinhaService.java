package com.ibeus.Comanda.Digital.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ibeus.Comanda.Digital.model.Cozinha;
import com.ibeus.Comanda.Digital.repository.CozinhaRepository;

import java.util.List;

@Service
public class CozinhaService {

    @Autowired
    private CozinhaRepository cozinhaRepository;

    public List<Cozinha> findAll() {
        return cozinhaRepository.findAll();
    }

    public Cozinha findById(Long id) {
        return cozinhaRepository.findById(id).orElseThrow(() -> new RuntimeException("Cozinha not found"));
    }

    public Cozinha create(Cozinha cozinha) {
        return cozinhaRepository.save(cozinha);
    }

    public Cozinha update(Long id, Cozinha cozinhaDetails) {
        Cozinha cozinha = findById(id);
        cozinha.setTipo(cozinhaDetails.getTipo());
        return cozinhaRepository.save(cozinha);
    }

    public void delete(Long id) {
        Cozinha cozinha = findById(id);
        cozinhaRepository.delete(cozinha);
    }
}
