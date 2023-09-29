package com.tarea.generation.controllers;

import com.tarea.generation.models.Tarea;
import com.tarea.generation.services.TareaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tarea")
public class TareaRESTController {

    @Autowired
    TareaServiceImpl tareaService;

    @GetMapping("/lista")
    public List<Tarea> listarTareas(){
        return tareaService.listarTarea();
    }

    @PostMapping("/registrar")
    public ResponseEntity<?> nuevaTarea(@RequestBody Tarea tarea) { return tareaService.guardarTarea(tarea); }

    @DeleteMapping("/borrar")
    public ResponseEntity<?> borrarTareaPorId (@RequestParam Long id){
        return tareaService.borrarTareaPorId(id);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<?> editarTareaPorId(@PathVariable Long id, @RequestBody Tarea tarea) {
        return tareaService.editarTareaPorId(tarea, id);
    }

}
