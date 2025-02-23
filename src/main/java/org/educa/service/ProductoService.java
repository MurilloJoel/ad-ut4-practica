package org.educa.service;

import org.educa.dao.ProductoDAO;
import org.educa.dao.ProductoDAOImpl;
import org.educa.entity.ProductoEntity;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Class with the methods related with the products
 *
 * @Author Joel Murillo Masa
 */
public class ProductoService {
    private final ProductoDAO productoDAO = new ProductoDAOImpl();


    /**
     * Method to return all products available
     * <p>
     * In this method the SQLException is not used but because in the statement said that the signature of the methods cannot be modified
     * I am not going to delete that part
     *
     * @return return a list of products
     * @throws SQLException SQL Exception
     */
    public List<ProductoEntity> findAllProducts() throws SQLException {
        List<ProductoEntity> productoEntities = new ArrayList<>();
        for (ProductoEntity producto : productoDAO.findAllProducts()) {
            //Method to set the final price aplying the discount
            producto.setPrecioFinal(calcularPrecioFinal(producto));
            productoEntities.add(producto);
        }
        return productoEntities;
    }

    /**
     * Method to return a product by name, size and color
     * <p>
     * In this method the SQLException is not used but because in the statement said that the signature of the methods cannot be modified
     * I am not going to delete that part
     *
     * @param name  Name from the product
     * @param size  Size of the product
     * @param color Color from the product
     * @return Return the first product
     * @throws SQLException SQL Exception
     */
    public ProductoEntity getFirstProductoByNameTallaAndColor(String name, String size, String color) throws SQLException {
        return productoDAO.getFirstProductoByNameTallaAndColor(name, size, color);
    }

    /**
     * Method to return a list of products by name
     * <p>
     * In this method the SQLException is not used but because in the statement said that the signature of the methods cannot be modified
     * I am not going to delete that part
     *
     * @param product Product to search
     * @return Return a list of products
     * @throws SQLException SQL Exception
     */
    public List<ProductoEntity> findByName(ProductoEntity product) throws SQLException {
        return productoDAO.findByName(product);
    }

    private BigDecimal calcularPrecioFinal(ProductoEntity producto) {
        //If the product does not have a discount, the precioFinal is the normal price
        if (producto.getDescuento() == null) {
            return producto.getPrecio().setScale(2, RoundingMode.HALF_UP);
        }
        BigDecimal descuento = producto.getDescuento().multiply(producto.getPrecio()).divide(BigDecimal.valueOf(100));
        return producto.getPrecio().subtract(descuento).setScale(2, RoundingMode.HALF_UP);
    }
}
