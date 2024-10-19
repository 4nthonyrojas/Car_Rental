package com.cibertec.carsystemauto.service.impl;

import com.cibertec.carsystemauto.model.Auto;
import com.cibertec.carsystemauto.model.repository.AutoRepository;
import com.cibertec.carsystemauto.service.IAutoService;
import com.cibertec.carsystemauto.service.dto.AutoResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AutoServiceImpl implements IAutoService {

    @Autowired
    private AutoRepository autoRepository;

    @Override
    public List<AutoResponseDTO> getAllAutos() {
        List<AutoResponseDTO> response = new ArrayList<>();
        List<Auto> autos = this.autoRepository.findAll();

        if (!autos.isEmpty()) {
            AutoResponseDTO autoResponseDTO;
            for (Auto auto : autos) {
                autoResponseDTO = new AutoResponseDTO();
                autoResponseDTO.setId(auto.getId());
                autoResponseDTO.setNombre(auto.getNombre());
                autoResponseDTO.setColor(auto.getColor());
                autoResponseDTO.setTransmision(auto.getTransmision());
                autoResponseDTO.setMarca(auto.getMarca());
                autoResponseDTO.setTipo(auto.getTipo());
                autoResponseDTO.setYearModelo(auto.getYearModelo());
                autoResponseDTO.setDescripcion(auto.getDescripcion());
                autoResponseDTO.setPrecio(auto.getPrecio());
                autoResponseDTO.setImagen(auto.getImagen());

                response.add(autoResponseDTO);
            }
        }

        return response;
    }

}
