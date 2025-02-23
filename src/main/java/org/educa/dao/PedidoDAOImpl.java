package org.educa.dao;

import org.educa.dao.hibernate.DAOSession;
import org.educa.entity.EstadoPedidoEntity;
import org.educa.entity.HistoricoPedidoEntity;
import org.educa.entity.PedidoEntity;
import org.hibernate.Session;

import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * Class to implements the methods related to purchases
 *
 * @Author Joel Murillo Masa
 */
public class PedidoDAOImpl implements PedidoDAO {
    /**
     * Method to insert a purchase
     *
     * @param purchase Purchase to insert
     */
    @Override
    public void insertarPedido(PedidoEntity purchase) {
        try (Session session = DAOSession.getSession()) {
            //When inserting the purchase needs to be update the table from historicoPedido
            HistoricoPedidoEntity historicoPedidoEntity = new HistoricoPedidoEntity();
            historicoPedidoEntity.setPedido(purchase);
            historicoPedidoEntity.setCambios("0");
            historicoPedidoEntity.setFecMod(Timestamp.valueOf(LocalDateTime.now()));
            historicoPedidoEntity.setUsuMod("ADMIN");
            purchase.setHistoricos(historicoPedidoEntity);
            session.merge(purchase);
            session.getTransaction().commit();
        }
    }

    /**
     * Method to obtain the state of the purchase
     *
     * @param number State of the purchase
     * @return Return the state of the purchase.
     */
    @Override
    public EstadoPedidoEntity obtenerEstado(int number) {
        try (Session session = DAOSession.getSession()) {
            return session.get(EstadoPedidoEntity.class, number);
        }
    }
}
