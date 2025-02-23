package org.educa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

/**
 * Cliente class
 *
 * @Author Joel Murillo Masa
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cliente")
public class ClienteEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "dni")
    private String dni;
    @Column(name = "email")
    private String email;
    @Column(name = "fec_cre")
    private Timestamp fecCre;
    @Column(name = "fec_mod")
    private Timestamp fecMod;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "pass")
    private String pass;
    @Column(name = "primer_apellido")
    private String primerApellido;
    @Column(name = "segundo_apellido")
    private String segundoApellido;
    @Column(name = "telefono")
    private String telefono;
    @Column(name = "usu_cre")
    private String usuCre;
    @Column(name = "usu_mod")
    private String usuMod;
    //One to Many relation with direcciones.
    @OneToMany(mappedBy = "clienteEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<DireccionEntity> direcciones;

}