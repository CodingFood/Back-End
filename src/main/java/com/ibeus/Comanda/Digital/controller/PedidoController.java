package com.ibeus.Comanda.Digital.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.ibeus.Comanda.Digital.model.Dish;
import com.ibeus.Comanda.Digital.service.DishService;

import java.util.List;

@RestController
@RequestMapping("/dishes")
@CrossOrigin(origins = "http://localhost:4200")
// Atributos
public class PedidoController {
    private int id;
    private String itens;
    private float valor;
    private int identificacao;

    //Métodos Construtor
    public PedidoController(){

    }


    public PedidoController(int id, String itens, float valor, int identificacao) {
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
