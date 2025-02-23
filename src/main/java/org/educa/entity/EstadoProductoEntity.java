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
@Table(name = "estado_producto")
/**
 * Clase que está compuesta por los datos de un estado de producto
 * @Author Diego del Moral Gilo
 */
public class EstadoProductoEntity implements Serializable {
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
    //Relación de uno a muchos ya que varios productos pueden tener un mismo estado
    @OneToMany(mappedBy = "estadoProducto")
    private List<ProductoEntity> productos;
}
