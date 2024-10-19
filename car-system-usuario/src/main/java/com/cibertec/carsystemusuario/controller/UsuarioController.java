package com.cibertec.carsystemusuario.controller;


import com.cibertec.carsystemusuario.model.Usuario;
import com.cibertec.carsystemusuario.service.IUsuarioService;
import com.cibertec.carsystemusuario.service.dto.UsuarioResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/usuario/v1")
public class UsuarioController {

    @Autowired
    private IUsuarioService usuarioService;

    // Obtener información de un usuario por ID
    @GetMapping("/users/{id}")
    public ResponseEntity<UsuarioResponseDTO> getUsuarioById(@PathVariable Long id) {
        UsuarioResponseDTO usuario = usuarioService.getUsuarioById(id);
        if (usuario != null) {
            return ResponseEntity.ok(usuario);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //Actualizar la información de un usuario
    @PutMapping("/users/{id}")
    public ResponseEntity<?> updateUsuario(@PathVariable Long id, @RequestBody UsuarioResponseDTO usuarioDTO) {
        try {

            Usuario usuario = new Usuario();
            usuario.setNombre(usuarioDTO.getNombre());
            usuario.setApellidos(usuarioDTO.getApellidos());
            usuario.setCorreo(usuarioDTO.getCorreo());


            UsuarioResponseDTO updatedUsuario = usuarioService.updateUsuario(id, usuario);

            if (updatedUsuario != null) {
                return ResponseEntity.ok(updatedUsuario);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }


    // Eliminar un usuario
    @DeleteMapping("/users/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable Long id) {
        boolean isDeleted = usuarioService.deleteUsuario(id);
        if (isDeleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Obtener todos los usuarios
    @GetMapping("/users")
    public ResponseEntity<List<UsuarioResponseDTO>> getAllUsuarios() {
        List<UsuarioResponseDTO> usuarios = usuarioService.getAllUsuarios();
        return ResponseEntity.ok(usuarios);
    }
}
