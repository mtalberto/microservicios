package com.microservicios.curso.models.entitys;

import java.math.BigDecimal;

import java.util.*;
import java.io.Serializable;



import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;



@Entity
@Table(name = "productos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//con serializable nos da la opcion de convertidos los datos en bytes para un archivo de texto o guardarlos en un bd

public class Producto implements Serializable{

    // para pagar 
    // con con control iz + espacio te saca lo metodos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Size(min = 4)
    @Column(name="nombre")
    private String nombre;

    @Column(name="precio")
    private BigDecimal precio;

    @Temporal(TemporalType.DATE)
    @Column(name="fecha_creacion")
    private Date fechaCreacion;


    @Transient
    private Integer port;
    
    private static final long serialVersionUID = new Random().nextLong();
}
