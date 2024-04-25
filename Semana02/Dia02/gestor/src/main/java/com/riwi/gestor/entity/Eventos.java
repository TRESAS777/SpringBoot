package com.riwi.gestor.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "eventos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Eventos {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, nullable = false)
    private String id;

    @NotNull
    @NotEmpty
    private String name;

    @Future
    @NotNull
    private Date fecha;

    @NotNull
    @NotEmpty
    private String ubicacion;

    @Min(2)
    private int capacidad; 
}
