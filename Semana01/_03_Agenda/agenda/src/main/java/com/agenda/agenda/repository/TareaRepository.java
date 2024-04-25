package com.agenda.agenda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.agenda.agenda.entity.Tarea;

@Repository
public interface TareaRepository extends JpaRepository<Tarea, Long> {
    
}
