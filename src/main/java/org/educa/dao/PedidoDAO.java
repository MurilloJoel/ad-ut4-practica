package org.educa.dao;

import org.educa.entity.EstadoPedidoEntity;
import org.educa.entity.PedidoEntity;

/**
 * Interface that implement all methods related from pedido
 *
 * @Author Joel Murillo Masa
 */
public interface PedidoDAO {
    /**
     * Method to insert the purchase
     *
     * @param purchase purchase to insert
     */
    void insertarPedido(PedidoEntity purchase);

    /**
     * Method to search the state of the purchase
     *
     * @param number State of the purchase
     * @return Return the state of the purchase
     */
    EstadoPedidoEntity obtenerEstado(int number);
}
