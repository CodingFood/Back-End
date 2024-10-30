package com.ibeus.Comanda.Digital.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "entregadores")
@Data
public class Entregador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String placaVeiculo;
}

