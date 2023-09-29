package com.tarea.generation.services;

import com.tarea.generation.models.Tarea;
import com.tarea.generation.models.Usuario;
import com.tarea.generation.repositories.TareaRepository;
import com.tarea.generation.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TareaServiceImpl implements TareaService{

    @Autowired
    TareaRepository tareaRepository;

    @Autowired
    UsuarioRepository usuarioRepository;
    @Override
    public List<Tarea> listarTarea() {
        return tareaRepository.findAll();
    }

    @Override
    public ResponseEntity<?> guardarTarea(Tarea tarea) {
        if (tarea.getUsuario() == null) {
            // Si el campo 'usuario' es null, establece el campo 'usuario' de la tarea como null
            tarea.setUsuario(null);
            tareaRepository.save(tarea);
            return ResponseEntity.ok(tarea);
        } else {
            Optional<Usuario> usuarioOptional = usuarioRepository.findById(tarea.getUsuario().getUsuarioId());
            if (usuarioOptional.isPresent()) {
                tarea.setUsuario(usuarioOptional.get());
                tareaRepository.save(tarea);
                return ResponseEntity.ok(tarea);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe un usuario con ese ID");
            }
        }
    }

    @Override
    public ResponseEntity<?> borrarTareaPorId(Long id) {
        Optional<Tarea> tareaOptional = tareaRepository.findById(id);
        if (tareaOptional.isPresent()){
            tareaRepository.deleteById(id);
            return ResponseEntity.ok("Tarea borrada con exito");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se ha encontrado una tarea con ese Id");
        }
    }

    @Override
    public ResponseEntity<?> editarTareaPorId(Tarea tarea, Long id) {
        Optional<Tarea> tareaOptional = tareaRepository.findById(id);

        if (tareaOptional.isPresent()) {
            Tarea tareaEditada = tareaOptional.get();

            tareaEditada.setTitulo(tarea.getTitulo());
            tareaEditada.setComentarios(tarea.getComentarios());
            tareaEditada.setDescripcion(tarea.getDescripcion());
            tareaEditada.setFechaVencimiento(tarea.getFechaVencimiento());

            tareaRepository.save(tareaEditada);

            return ResponseEntity.ok(tareaEditada);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe una tarea con el ID solicitado");
        }

    }
}
