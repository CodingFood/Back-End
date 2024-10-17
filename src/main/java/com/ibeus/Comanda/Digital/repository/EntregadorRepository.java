package com.ibeus.Comanda.Digital.repository;

import com.ibeus.Comanda.Digital.model.Entregador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntregadorRepository extends JpaRepository<Entregador, Long> {
    // Métodos de CRUD são herdados de JpaRepository
}
