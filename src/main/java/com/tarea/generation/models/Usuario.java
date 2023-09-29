package com.tarea.generation.models;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "usuarios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long usuarioId;

    @Column(name = "nombre", length = 20) //especificaciones SQL
    @NotNull
    private String nombreUsuario; //especificaciones JAVA

    @Column(name = "correo_electronico", length = 30)
    @NotNull
    private String email;

    @JsonManagedReference
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Tarea> tareas;


    public Usuario(long usuarioId) {
        this.usuarioId = usuarioId;
    }
}
