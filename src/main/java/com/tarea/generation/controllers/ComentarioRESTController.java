package com.tarea.generation.controllers;

import com.tarea.generation.models.Comentario;
import com.tarea.generation.services.ComentarioServiceImpl;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comentario")
public class ComentarioRESTController {

    @Autowired
    ComentarioServiceImpl comentarioService;
    @GetMapping("/lista")
    public List<Comentario> listarComentarios() {
        return comentarioService.listarComentario();
    }

    @PostMapping("/registrar")
    public ResponseEntity<?> guardarComentario(@RequestBody Comentario comentario) {
        return comentarioService.guardarComentario(comentario);
    }

    @DeleteMapping("/borrar")
    public ResponseEntity<?> borrarComentarioPorId(@RequestParam Long id){
        return comentarioService.borrarComentarioPorId(id);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<?> editarComentarioPorId(@PathVariable Long id, @RequestBody Comentario comentario) {
        return comentarioService.editarComentarioPorId(comentario, id);
    }
}