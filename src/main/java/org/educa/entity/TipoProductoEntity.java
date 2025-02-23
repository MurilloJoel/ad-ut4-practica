package org.educa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tipo_producto")
/**
 * Class for type of products
 * @Author Diego del Moral Gilo
 */
public class TipoProductoEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "usu_cre")
    private String usuCre;
    @Column(name = "fec_cre")
    private LocalDate fecCre;
    @Column(name = "usu_mod")
    private String usuMod;
    @Column(name = "fec_mod")
    private LocalDate fecMod;
    @OneToMany(mappedBy = "tipoProducto")
    private List<ProductoEntity> productos;
}
