package org.educa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "estado_pedido")
/**
 * Class for the purchasing state
 * @Author Joel Murillo Masa
 */
public class EstadoPedidoEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "fec_cre")
    private Timestamp fecCre;
    @Column(name = "fec_mod")
    private Timestamp fecMod;
    @Column(name = "usu_cre")
    private String usuCre;
    @Column(name = "usu_mod")
    private String usuMod;
    //One to Many relation with purchases
    @OneToMany(mappedBy = "estadoPedido")
    private List<PedidoEntity> pedidos;
}