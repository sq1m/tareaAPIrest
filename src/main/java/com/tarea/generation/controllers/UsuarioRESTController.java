package com.tarea.generation.controllers;

import com.tarea.generation.models.Usuario;
import com.tarea.generation.services.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioRESTController {

    @Autowired
    UsuarioServiceImpl usuarioService;

    @GetMapping("/lista")
    public List<Usuario> listarUsuarios() {
        return usuarioService.listarUsuarios();
    }

    @PostMapping("/registrar")
    public Usuario crearUsuario(@RequestBody Usuario nuevoUsuario) {
        return usuarioService.guardarUsuario(nuevoUsuario);
    }

    @DeleteMapping("/borrar")
    public ResponseEntity<String> borrarUsuarioPorId(@RequestParam Long id){
        return usuarioService.borrarUsuarioPorId(id);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<?> editarUsuarioPorId(@PathVariable Long id, @RequestBody Usuario usuario){
        return usuarioService.editarUsuarioPorId(usuario, id);
    }
}
