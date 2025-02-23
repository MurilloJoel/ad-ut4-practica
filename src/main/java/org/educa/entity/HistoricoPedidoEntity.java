package org.educa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "historico_pedido")
/**
 * Class with the history of purchases
 * @Author Joel Murillo Masa
 */
public class HistoricoPedidoEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "cambios")
    private String cambios;
    @Column(name = "usu_mod")
    private String usuMod;
    @Column(name = "fec_mod")
    private Timestamp fecMod;
    @OneToOne(fetch = FetchType.LAZY)
    //One to One relation with pedidoEntity
    @JoinColumn(name = "id_pedido")
    private PedidoEntity pedido;
}
