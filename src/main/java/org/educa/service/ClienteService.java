package org.educa.service;

import org.educa.dao.ClienteDAO;
import org.educa.dao.ClienteDAOImpl;
import org.educa.entity.ClienteEntity;

/**
 * Class with the methods of client
 *
 * @Author Joel Murillo Masa
 */
public class ClienteService {
    private final ClienteDAO clienteDAO = new ClienteDAOImpl();

    /**
     * Method to compare if the client is registered in the database
     *
     * @param dni  DNI del cliente
     * @param pass Password of the client
     * @return Return a client.
     */
    public ClienteEntity login(String dni, String pass) {
        return clienteDAO.login(dni, pass);
    }
}
