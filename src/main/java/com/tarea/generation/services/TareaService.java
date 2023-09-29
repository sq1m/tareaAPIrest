package com.tarea.generation.services;

import com.tarea.generation.models.Comentario;
import com.tarea.generation.models.Tarea;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TareaService {

    List<Tarea> listarTarea();

    ResponseEntity<?> guardarTarea(Tarea tarea);

    ResponseEntity<?> borrarTareaPorId(Long id);

    ResponseEntity<?> editarTareaPorId(Tarea tarea, Long id);
}
