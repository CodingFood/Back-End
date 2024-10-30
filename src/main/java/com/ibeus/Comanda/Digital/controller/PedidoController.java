package com.ibeus.Comanda.Digital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ibeus.Comanda.Digital.model.Pedido;
import com.ibeus.Comanda.Digital.service.PedidoService;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
@CrossOrigin(origins = "http://localhost:4200")  // Permitir requisições do frontend Angular
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    // Endpoint para listar todos os pedidos
    @GetMapping
    public List<Pedido> getAllPedidos() {
        return pedidoService.findAll();
    }

    // Endpoint para listar pedidos por status
    @GetMapping("/status/{status}")
    public List<Pedido> getPedidosByStatus(@PathVariable String status) {
        return pedidoService.findByStatus(status);
    }

    // Endpoint para criar um novo pedido (Método POST)
    @PostMapping
    public Pedido criarPedido(@RequestBody Pedido pedido) {
        try {
            // Verificação de dados do pedido
            System.out.println("Recebendo pedido: " + pedido.toString());
            System.out.println("Nome do Cliente: " + pedido.getCliente());
            System.out.println("Endereço do Cliente: " + pedido.getEndereco());
            System.out.println("Pratos: " + (pedido.getDishes() != null ? pedido.getDishes().size() : "Nenhum prato informado"));

            // Salvar o pedido no serviço
            return pedidoService.save(pedido);
        } catch (Exception e) {
            System.err.println("Erro ao salvar o pedido: " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("Erro ao criar pedido: " + e.getMessage(), e);
        }
    }

    // Endpoint para atualizar o status de um pedido
    @PutMapping("/{id}/status")
    public Pedido updateStatus(@PathVariable Long id, @RequestBody String novoStatus) {
        Pedido pedido = pedidoService.findById(id);
        if (pedido != null) {
            // Corrigir o status se vier como JSON no corpo da requisição
            String statusLimpo = novoStatus.replaceAll("[{}\"]", "").split(":")[1].trim();

            // Atualiza o status do pedido
            pedido.setStatus(statusLimpo);
            return pedidoService.save(pedido);
        } else {
            throw new RuntimeException("Pedido não encontrado com ID: " + id);
        }
    }

    // Novo Endpoint para retornar apenas o status de um pedido pelo ID
    @GetMapping("/{id}/status")
    public String getStatus(@PathVariable Long id) {
        Pedido pedido = pedidoService.findById(id);
        if (pedido != null) {
            return pedido.getStatus();  // Retorna apenas o status
        } else {
            throw new RuntimeException("Pedido não encontrado com ID: " + id);
        }
    }

    // Endpoint para buscar um pedido específico por ID
    @GetMapping("/{id}")
    public Pedido getPedidoById(@PathVariable Long id) {
        Pedido pedido = pedidoService.findById(id);
        if (pedido != null) {
            return pedido;  // Retorna o pedido completo
        } else {
            throw new RuntimeException("Pedido não encontrado com ID: " + id);
        }
    }
}

