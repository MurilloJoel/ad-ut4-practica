package org.educa.dao;

import org.educa.dao.hibernate.DAOSession;
import org.educa.entity.ProductoEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

/**
 * Class with the methods related with the products
 *
 * @Author Joel Murillo Masa
 */
public class ProductoDAOImpl implements ProductoDAO {
    /**
     * Method to return all the products
     *
     * @return Return a list of products
     */
    @Override
    public List<ProductoEntity> findAllProducts() {
        try (Session session = DAOSession.getSession()) {
            //This query is for avoid repeated products
            List<ProductoEntity> lista = session.createNativeQuery("SELECT p.*  " +
                    "FROM producto p " +
                    "WHERE p.id = ( " +
                    "SELECT MIN(p2.id) " +
                    "FROM producto p2 " +
                    "WHERE p2.nombre = p.nombre " +
                    ");", ProductoEntity.class).list();
            return lista;
        }
    }

    /**
     * Method to return the first product by name, size and color
     *
     * @param name  Name of the product
     * @param size  Size of the product
     * @param color Color of the product
     * @return Return the product
     */
    @Override
    public ProductoEntity getFirstProductoByNameTallaAndColor(String name, String size, String color) {
        try (Session session = DAOSession.getSession()) {
            /**
             * We make a query with the parameters of name, size and color. And we force to make unique by the method uniqueResult.
             */
            Query<ProductoEntity> query = session.createQuery("FROM ProductoEntity p WHERE p.nombre =:name " +
                            "AND p.talla =:size AND p.color =:color", ProductoEntity.class)
                    .setParameter("name", name)
                    .setParameter("size", size)
                    .setParameter("color", color)
                    .setMaxResults(1);
            return query.uniqueResult();
        }
    }

    /**
     * Method to search a product by name
     *
     * @param product Product to search
     * @return Return a list of products
     */
    @Override
    public List<ProductoEntity> findByName(ProductoEntity product) {
        try (Session session = DAOSession.getSession()) {
            //Native Query where the distinct clause avoid duplicates from the size or name
            return session.createNativeQuery("SELECT DISTINCT on (talla, nombre) * from producto p " +
                            " where p.nombre = :name", ProductoEntity.class)
                    .setParameter("name", product.getNombre())
                    .list();
        }
    }
}
