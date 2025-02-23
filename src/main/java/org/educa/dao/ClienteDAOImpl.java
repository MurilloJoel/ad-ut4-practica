package org.educa.dao;

import org.educa.dao.hibernate.DAOSession;
import org.educa.entity.ClienteEntity;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 * Class where the methods related to cliente are implemented
 *
 * @Author Joel Murillo Masa
 */
public class ClienteDAOImpl implements ClienteDAO {
    /**
     * Method to compare if the client is in the database
     *
     * @param dni  DNI from the client
     * @param pass Password for the client
     * @return Return the client
     */
    @Override
    public ClienteEntity login(String dni, String pass) {
        try (Session session = DAOSession.getSession()) {

            /**
             * Query to prove if the client is in the database
             */
            Query<ClienteEntity> query = session.createQuery("FROM ClienteEntity c WHERE c.dni = :dni " +
                            "AND c.pass = :pass", ClienteEntity.class)
                    .setParameter("dni", dni)
                    .setParameter("pass", pass)
                    .setReadOnly(true);
            //The client need to be unique.
            ClienteEntity cliente = query.uniqueResult();
            if (cliente != null) {
                Hibernate.initialize(cliente.getDirecciones());
            }
            return cliente;
        }

    }
}
