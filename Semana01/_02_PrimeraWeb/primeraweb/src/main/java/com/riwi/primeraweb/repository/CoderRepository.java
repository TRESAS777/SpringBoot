package com.riwi.primeraweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.riwi.primeraweb.entity.Coder;

@Repository //
public interface CoderRepository extends JpaRepository<Coder, Long> { // Se usa la entidad y el tipo de dato de la llave primaria
    
}
