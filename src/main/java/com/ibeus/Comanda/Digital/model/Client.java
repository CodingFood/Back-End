package com.ibeus.Comanda.Digital.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;  // O ID deve ser gerado automaticamente.

    private String nome;

    // Construtor padrão
    public Client() {
    }

    // Construtor com parâmetros
    public Client(String nome) {
        this.nome = nome;
    }

    // Métodos

    public void receberPedido() {
        // implementação
    }

    public void verificarPedido() {
        // implementação
    }

    public void enviarParaCozinha() {
        // implementação
    }

    // Getters e setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
