package com.tarea.generation.services;

import com.tarea.generation.models.Usuario;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UsuarioService {

    List<Usuario> listarUsuarios();

    Usuario guardarUsuario(Usuario usuarioNuevo);

    ResponseEntity<?> borrarUsuarioPorId(Long id);

    ResponseEntity<?> editarUsuarioPorId(Usuario usuario, Long id);
}
