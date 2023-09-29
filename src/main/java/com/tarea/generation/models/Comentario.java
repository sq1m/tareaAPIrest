package com.tarea.generation.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "comentario")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long comentarioId;

    @Column(name = "texto")
    private String texto;

    @Column(name = "fecha_de_creacion", length = 40)
    private String fechaCreacion;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "tarea_id")
    private Tarea tarea;

    public Comentario(long comentarioId) {
        this.comentarioId = comentarioId;
    }
}
