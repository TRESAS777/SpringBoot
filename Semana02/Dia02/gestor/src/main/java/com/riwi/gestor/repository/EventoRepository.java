package com.riwi.gestor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.riwi.gestor.entity.Eventos;

@Repository
public interface EventoRepository extends JpaRepository<Eventos, String> {
    public Eventos findByName(String name);
}
