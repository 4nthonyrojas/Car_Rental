package com.cibertec.carsystemusuario.service;

import com.cibertec.carsystemusuario.model.Usuario;
import com.cibertec.carsystemusuario.service.dto.UsuarioResponseDTO;

import java.util.List;

public interface IUsuarioService {

    public List<UsuarioResponseDTO> getAllUsuarios();

    UsuarioResponseDTO getUsuarioById(Long id);

    UsuarioResponseDTO updateUsuario(Long id, Usuario usuario);

    boolean deleteUsuario(Long id);
}
