package com.ibeus.Comanda.Digital.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;

@Entity
public class Entregador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String veiculo;

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(String veiculo) {
        this.veiculo = veiculo;
    }

    // Método para entregar pedido
    public void entregarPedido() {
        System.out.println("Pedido entregue.");
        // Lógica adicional de entrega de pedido aqui
    }

    // Método para fazer pagamento
    public void fazerPagamento() {
        System.out.println("Pagamento realizado.");
        // Lógica adicional de pagamento aqui
    }
}
