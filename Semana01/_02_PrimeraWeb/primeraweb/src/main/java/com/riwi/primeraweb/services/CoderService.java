package com.riwi.primeraweb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.riwi.primeraweb.entity.Coder;
import com.riwi.primeraweb.repository.CoderRepository;

@Service // Indica que esta clase será un servicio
public class CoderService {
    
    @Autowired // Indica que es una inyección de dependencias
    private CoderRepository objCoderRepository;

    public List<Coder> findAll(){ // Servicio para listar todos los coders
        return this.objCoderRepository.findAll();
    }

    public Coder insert(Coder objCoder){
        return this.objCoderRepository.save(objCoder);
    }

    //Servicio para actualizar un coder
    public Coder update(Long id, Coder objCoder){ //Recibe id y coder actualizado
        Coder objCoderDB = this.findById(id); //Buscar al coder con el id
        if (objCoderDB == null) return null; //Verificar si existe
        objCoderDB = objCoder; // Actualizar el coder existente
        return this.objCoderRepository.save(objCoderDB);// Se guarda
    }

    public Coder findById(Long id){ 
        return this.objCoderRepository.findById(id).orElse(null); // si no lo encuentra devuelve null
    }

    //Metodo para eliminar
    public void delete(Long id){
        this.objCoderRepository.deleteById(id);
    }

    // Método para listar los coder con paginación
    public Page<Coder> fingPaginated(int page, int size){
        if (page < 0) {
            page =1;
        } 

        //Crear objeto de paginación
        Pageable objPageable = PageRequest.of(page, size);

        return this.objCoderRepository.findAll(objPageable);
    }

}
