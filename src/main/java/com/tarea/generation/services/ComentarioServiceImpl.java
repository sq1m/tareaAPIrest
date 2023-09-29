package com.tarea.generation.services;


import com.tarea.generation.models.Comentario;
import com.tarea.generation.models.Tarea;
import com.tarea.generation.repositories.ComentarioRepository;
import com.tarea.generation.repositories.TareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComentarioServiceImpl implements ComentarioService{

    @Autowired
    ComentarioRepository comentarioRepository;

    @Autowired
    TareaRepository tareaRepository;

    @Override
    public List<Comentario> listarComentario() {
        return comentarioRepository.findAll();
    }

    @Override
    public ResponseEntity<?> guardarComentario(Comentario comentario) {
        if (comentario.getTarea() == null) {
            // Si el campo 'tarea' es null, establece el campo 'tarea' del comentario como null
            comentario.setTarea(null);
            comentarioRepository.save(comentario);
            return ResponseEntity.ok(comentario);
        } else {
            Optional<Tarea> tareaOptional = tareaRepository.findById(comentario.getTarea().getTareaId());
            if (tareaOptional.isPresent()) {
                comentario.setTarea(tareaOptional.get());
                comentarioRepository.save(comentario);
                return ResponseEntity.ok(comentario);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe una tarea con el ID: " + comentario.getTarea().getTareaId());
            }
        }
    }

    @Override
    public ResponseEntity<?> borrarComentarioPorId(Long id) {
        Optional<Comentario> comentarioOptional = comentarioRepository.findById(id);
        if (comentarioOptional.isPresent()) {
            comentarioRepository.deleteById(id);
            return ResponseEntity.ok("Comentario borrado con exito");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Comentario no encontrado. Id: " +id);
        }
    }

    @Override
    public ResponseEntity<?> editarComentarioPorId(Comentario comentario, Long id) {
        Optional<Comentario> comentarioOptional = comentarioRepository.findById(id);
        if (comentarioOptional.isPresent()) {
            Comentario comentarioEditado = comentarioOptional.get();

            comentarioEditado.setTarea(comentario.getTarea());
            comentarioEditado.setTexto(comentario.getTexto());
            comentarioEditado.setFechaCreacion(comentario.getFechaCreacion());

            comentarioRepository.save(comentarioEditado);

            return ResponseEntity.ok(comentarioEditado);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Comentario no encontrado. Id: " +id);
        }
    }
}
