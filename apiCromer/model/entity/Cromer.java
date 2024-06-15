package com.cromer.apiCromer.model.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString


@Entity
@Table(name="Cromer")

public class Cromer implements Serializable {

    @Id
    @Column(name = "id_cromer")
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id_cromer;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "naturaleza")
     private String naturaleza;

    @Column(name = "peso")
    private int peso;




}
