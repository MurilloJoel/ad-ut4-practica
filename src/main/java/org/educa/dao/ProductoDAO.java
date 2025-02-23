package org.educa.dao;

import org.educa.entity.ProductoEntity;

import java.util.List;

/**
 * Interface to implement the methods of product
 *
 * @Author Joel Murillo Masa
 */
public interface ProductoDAO {
    /**
     * Method to return a list of products
     *
     * @return Return a list of products
     */
    List<ProductoEntity> findAllProducts();

    /**
     * Method to return the first product with the parameters
     *
     * @param name  Name of the product
     * @param size  Size of the product
     * @param color Color of the product
     * @return Return the product
     */
    ProductoEntity getFirstProductoByNameTallaAndColor(String name, String size, String color);

    /**
     * Method to return a list of products by name
     *
     * @param product Product to search
     * @return Return a list of products
     */
    List<ProductoEntity> findByName(ProductoEntity product);
}
