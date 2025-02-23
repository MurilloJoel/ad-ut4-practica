package org.educa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pedido")
/**
 * Class for purchases
 * @Author Joel Murillo Masa
 */
public class PedidoEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "fecha")
    private Timestamp fecha;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cliente")
    private ClienteEntity cliente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "direccion")
    private DireccionEntity direccion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "estado")
    private EstadoPedidoEntity estadoPedido;
    /**
     * Many to Many relation or creating a new class with the foreign key if producto and pedido
     */
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "pedido_producto",
            joinColumns = {@JoinColumn(name = "id_pedido")},
            inverseJoinColumns = {@JoinColumn(name = "id_producto")})
    private List<ProductoEntity> productos = new ArrayList<>();

    @OneToOne(mappedBy = "pedido", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private HistoricoPedidoEntity historicos;
}