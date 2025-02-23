package org.educa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "direccion")
/**
 * Class for directions of the clients
 * @Author Joel Murillo Masa
 */
public class DireccionEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "calle")
    private String calle;
    @Column(name = "ciudad")
    private String ciudad;
    @Column(name = "pais")
    private String pais;
    @Column(name = "cp")
    private String cp;
    @Column(name = "fec_cre")
    private Timestamp fecCre;
    @Column(name = "fec_mod")
    private Timestamp fecMod;
    @Column(name = "usu_cre")
    private String usuCre;
    @Column(name = "usu_mod")
    private String usuMod;
    //Many to One relation with a client
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cliente")
    private ClienteEntity clienteEntity;
}