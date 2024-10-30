package com.ibeus.Comanda.Digital.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ibeus.Comanda.Digital.model.Pedido;
import com.ibeus.Comanda.Digital.repository.PedidoRepository;

import java.util.List;

@Service
public class PedidoService {

    private static final Logger logger = LoggerFactory.getLogger(PedidoService.class);

    @Autowired
    private PedidoRepository pedidoRepository;

    public List<Pedido> findAll() {
        return pedidoRepository.findAll();
    }

    public List<Pedido> findByStatus(String status) {
        return pedidoRepository.findByStatus(status);
    }

    public Pedido save(Pedido pedido) {
        try {
            return pedidoRepository.save(pedido);
        } catch (Exception e) {
            logger.error("Erro ao salvar o pedido: ", e);
            throw e;
        }
    }

    public Pedido findById(Long id) {
        try {
            return pedidoRepository.findById(id).orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
        } catch (Exception e) {
            logger.error("Erro ao buscar o pedido com ID " + id, e);
            throw e;
        }
    }

    public void delete(Long id) {
        try {
            Pedido pedido = findById(id);
            pedidoRepository.delete(pedido);
        } catch (Exception e) {
            logger.error("Erro ao deletar o pedido com ID " + id, e);
            throw e;
        }
    }
}