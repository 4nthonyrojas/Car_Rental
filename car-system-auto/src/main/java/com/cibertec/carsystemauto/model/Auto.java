package com.cibertec.carsystemauto.model;

import jakarta.persistence.*;

@Entity
@Table(name = "autos")
public class Auto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_auto")
    private Long id;

    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;

    @Basic(optional = false)
    @Column(name = "color")
    private String color;

    @Basic(optional = false)
    @Column(name = "transmision")
    private String transmision;

    @Basic(optional = false)
    @Column(name = "marca")
    private String marca;

    @Basic(optional = false)
    @Column(name = "tipo")
    private String tipo;

    @Basic(optional = false)
    @Column(name = "year_modelo")
    private String yearModelo;

    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;

    @Basic(optional = false)
    @Column(name = "precio")
    private Integer precio;

    @Basic(optional = false)
    @Column(name = "imagen")
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
