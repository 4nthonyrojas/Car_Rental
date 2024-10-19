package com.cibertec.carsystemusuario.service.impl;

import com.cibertec.carsystemusuario.model.Usuario;
import com.cibertec.carsystemusuario.model.repository.UsuarioRepository;
import com.cibertec.carsystemusuario.service.IUsuarioService;
import com.cibertec.carsystemusuario.service.dto.UsuarioResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<UsuarioResponseDTO> getAllUsuarios() {
        List<UsuarioResponseDTO> response = new ArrayList<>();
        List<Usuario> usuarios = this.usuarioRepository.findAll();

        if (!usuarios.isEmpty()) {
            UsuarioResponseDTO usuResponseDTO;
            for (Usuario usuario : usuarios) {
                usuResponseDTO = new UsuarioResponseDTO();
                usuResponseDTO.setId(usuario.getId());
                usuResponseDTO.setNombre(usuario.getNombre());
                usuResponseDTO.setApellidos(usuario.getApellidos());
                usuResponseDTO.setCorreo(usuario.getCorreo());

                response.add(usuResponseDTO);
            }
        }

        return response;
    }

    @Override
    public UsuarioResponseDTO getUsuarioById(Long id) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
        if (usuarioOptional.isPresent()) {
            Usuario usuario = usuarioOptional.get();
            UsuarioResponseDTO usuResponseDTO = new UsuarioResponseDTO();
            usuResponseDTO.setId(usuario.getId());
            usuResponseDTO.setNombre(usuario.getNombre());
            usuResponseDTO.setApellidos(usuario.getApellidos());
            usuResponseDTO.setCorreo(usuario.getCorreo());

            return usuResponseDTO;
        } else {
            return null;
        }
    }

    @Override
    public UsuarioResponseDTO updateUsuario(Long id, Usuario usuario) {
        Optional<Usuario> usuarioExistente = usuarioRepository.findById(id);
        if (usuarioExistente.isPresent()) {
            Usuario usuarioActual = usuarioExistente.get();
            usuarioActual.setNombre(usuario.getNombre());
            usuarioActual.setApellidos(usuario.getApellidos());
            usuarioActual.setCorreo(usuario.getCorreo());

            usuarioRepository.save(usuarioActual);

            UsuarioResponseDTO usuResponseDTO = new UsuarioResponseDTO();
            usuResponseDTO.setId(usuarioActual.getId());
            usuResponseDTO.setNombre(usuarioActual.getNombre());
            usuResponseDTO.setApellidos(usuarioActual.getApellidos());
            usuResponseDTO.setCorreo(usuarioActual.getCorreo());


            return usuResponseDTO;
        } else {
            return null;
        }
    }

    @Override
    public boolean deleteUsuario(Long id) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
        if (usuarioOptional.isPresent()) {
            usuarioRepository.deleteById(id); // Elimina el usuario
            return true;
        } else {
            return false; // Retorna false si no se encuentra el usuario
        }
    }
}
