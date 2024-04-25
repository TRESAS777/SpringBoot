package com.agenda.agenda.entity;

import java.time.*;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tarea")
public class Tarea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 100, nullable = false)
    private String titulo;
    @Column(length = 255, nullable = false)
    private String descipcion;
    @Column(nullable = false)
    private LocalDate fechaEjecicion;
    @Column(nullable = false)
    private LocalTime horaEjecucion;
    @Column(length = 50, nullable = false)
    private String estado;
    
    public Tarea() {
    }
    
    public Tarea(Long id, String titulo, String descipcion, LocalDate fechaEjecicion, LocalTime horaEjecucion,
            String estado) {
        this.id = id;
        this.titulo = titulo;
        this.descipcion = descipcion;
        this.fechaEjecicion = fechaEjecicion;
        this.horaEjecucion = horaEjecucion;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescipcion() {
        return descipcion;
    }

    public void setDescipcion(String descipcion) {
        this.descipcion = descipcion;
    }

    public LocalDate getFechaEjecicion() {
        return fechaEjecicion;
    }

    public void setFechaEjecicion(LocalDate fechaEjecicion) {
        this.fechaEjecicion = fechaEjecicion;
    }

    public LocalTime getHoraEjecucion() {
        return horaEjecucion;
    }

    public void setHoraEjecucion(LocalTime horaEjecucion) {
        this.horaEjecucion = horaEjecucion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Tarea [id=" + id + ", titulo=" + titulo + ", descipcion=" + descipcion + ", fechaEjecicion="
                + fechaEjecicion + ", horaEjecucion=" + horaEjecucion + ", estado=" + estado + "]";
    }

    
}
