package com.ibeus.Comanda.Digital.model;


// Atributos
public class Pedido {
    private int id;
    private String itens;
    private float valor;
    private int identificacao;

    //Métodos Construtor
    public Pedido(int id, String itens, float valor, int identificacao) {
        this.id = id;
        this.itens = itens;
        this.valor = valor;
        this.identificacao = identificacao;
    }

    //  outros métodos

    public void enviarEntregador(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItens() {
        return itens;
    }

    public void setItens(String itens) {
        this.itens = itens;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public int getIdentificacao() {
        return identificacao;
    }

    public void setIdentificacao(int identificacao) {
        this.identificacao = identificacao;
    }
}