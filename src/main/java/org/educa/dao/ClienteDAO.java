package org.educa.dao;

import org.educa.entity.ClienteEntity;

/**
 * Interface to implement the methods of cliente
 *
 * @Author Joel Murillo Masa
 */
public interface ClienteDAO {
    /**
     * Method that compare if the client is in the database
     *
     * @param dni  DNI from client
     * @param pass Password from the client
     * @return return a client
     */
    ClienteEntity login(String dni, String pass);
}
