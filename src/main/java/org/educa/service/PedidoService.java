package org.educa.service;

import org.educa.dao.PedidoDAO;
import org.educa.dao.PedidoDAOImpl;
import org.educa.entity.EstadoPedidoEntity;
import org.educa.entity.PedidoEntity;

import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * Class of the methods related with purchases
 *
 * @Author Joel Murillo Masa
 */
public class PedidoService {
    private final PedidoDAO pedidoDAO = new PedidoDAOImpl();

    /**
     * Method to insert a purchase
     *
     * @param purchase Purchase to insert
     */
    public void insertarPedido(PedidoEntity purchase) {
        EstadoPedidoEntity estadoPedido = pedidoDAO.obtenerEstado(1);

        //We set the date and the state of the purchase
        purchase.setFecha(Timestamp.valueOf(LocalDateTime.now()));
        purchase.setEstadoPedido(estadoPedido);
        pedidoDAO.insertarPedido(purchase);
    }
}
