package org.educa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "producto")
/**
 * Class for products
 * @Author Joel Murillo Masa
 */
public class ProductoEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String color;
    private BigDecimal descuento;
    private BigDecimal precio;
    private String talla;
    //Variable to keep the final price. Is transient to alert Hibernate not to be a table
    @Transient
    private BigDecimal precioFinal;
    @Column(name = "codigo_barra")
    private String codigoBarra;
    @Column(name = "usu_cre")
    private String usuCre;
    @Column(name = "usu_mod")
    private String usuMod;
    @Column(name = "fec_cre")
    private Timestamp fecCre;
    @Column(name = "fec_mod")
    private Timestamp fecMod;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "coleccion")
    private ColeccionEntity coleccionBean;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "estado")
    private EstadoProductoEntity estadoProducto;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tipo")
    private TipoProductoEntity tipoProducto;
    @ManyToMany(mappedBy = "productos")
    private List<PedidoEntity> pedidos;
}