package com.ibeus.Comanda.Digital.repository;


import com.ibeus.Comanda.Digital.model.Cozinha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CozinhaRepository extends JpaRepository<Cozinha, Long> {
}
