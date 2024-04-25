package com.riwi.primeraweb.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity //Entity indica que esta será una entidad y podrá ser mapeada
@Table(name = "coder") //Table nos permite dar configuraciones a la tabla
public class Coder {

    @Id //Id indica que el siguiente atributo será la llave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // GenerateValue permite que el id sea autoincrementable
    private Long id;
    private String nombre;
    private int age;
    private String clan;
    
    public Coder() {
    }

    public Coder(Long id, String nombre, int age, String clan) {
        this.id = id;
        this.nombre = nombre;
        this.age = age;
        this.clan = clan;
    }

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getClan() {
        return clan;
    }

    public void setClan(String clan) {
        this.clan = clan;
    }

    @Override
    public String toString() {
        return "Coder [id=" + id + ", nombre=" + nombre + ", age=" + age + ", clan=" + clan + "]";
    }

    
}
