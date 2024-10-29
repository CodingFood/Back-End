package com.ibeus.Comanda.Digital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ibeus.Comanda.Digital.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
