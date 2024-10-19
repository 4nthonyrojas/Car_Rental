package com.cibertec.carsystemauto.service.dto;

import jakarta.persistence.Column;

public class AutoResponseDTO {

    private Long id;
    private String nombre;
    private String color;
    private String transmision;
    private String marca;
    private String tipo;
    private String yearModelo;
    private String descripcion;
    private Integer precio;
    private byte[] imagen;

    // Getters y setters
    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }

    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getColor() { return color; }

    public void setColor(String color) { this.color = color; }

    public String getTransmision() { return transmision; }

    public void setTransmision(String transmision) { this.transmision = transmision; }

    public String getMarca() { return marca; }

    public void setMarca(String marca) { this.marca = marca; }

    public String getTipo() { return tipo; }

    public void setTipo(String tipo) { this.tipo = tipo; }

    public String getYearModelo() { return yearModelo; }

    public void setYearModelo(String yearModelo) { this.yearModelo = yearModelo; }

    public String getDescripcion() { return descripcion; }

    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public Integer getPrecio() { return precio; }

    public void setPrecio(Integer precio) { this.precio = precio; }

    public byte[] getImagen() { return imagen; }

    public void setImagen(byte[] imagen) { this.imagen = imagen; }
}
