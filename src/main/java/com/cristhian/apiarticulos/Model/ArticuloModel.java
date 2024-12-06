package com.cristhian.apiarticulos.Model;

import jakarta.persistence.*;

/*
Con los decoradores @ y la linea de codigo en
application.properties -> "spring.jpa.hibernate.ddl-auto=update"
Spring te crea la tabla en la base de datos segun la entidad
y sus definiciones
*/
@Entity
@Table(name = "articulo") //Se le declara un nombre para que genere una tabla por defecto
public class ArticuloModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true,nullable = false)
    private Long id;
    @Column(nullable = false)
    private String nombre;
    @Column
    private String descripcion;
    @Column(nullable = false)
    private double precio;
    @Column(nullable = false)
    private int stock;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}

