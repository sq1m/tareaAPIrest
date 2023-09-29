package com.tarea.generation.services;

import com.tarea.generation.models.Comentario;
import com.tarea.generation.models.Usuario;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ComentarioService {

    List<Comentario> listarComentario();

    ResponseEntity<?> guardarComentario(Comentario comentario);

    ResponseEntity<?> borrarComentarioPorId(Long id);

    ResponseEntity<?> editarComentarioPorId(Comentario comentario, Long id);
}
