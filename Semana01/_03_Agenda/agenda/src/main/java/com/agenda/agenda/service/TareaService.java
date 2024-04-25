package com.agenda.agenda.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agenda.agenda.entity.Tarea;
import com.agenda.agenda.repository.TareaRepository;

@Service
public class TareaService {

    @Autowired
    public TareaRepository objTareaRepository;

    public List<Tarea> findAll(){
        return this.objTareaRepository.findAll();
    }

    public Tarea insert(Tarea objTarea){
        return this.objTareaRepository.save(objTarea);
    }

    public Tarea update(Long id, Tarea objTarea){
        Tarea objTareaDB = this.findById(id);
        if (objTareaDB == null) return null;
        objTareaDB = objTarea;
        return this.objTareaRepository.save(objTareaDB);
    }

    public Tarea findById(Long id){
        return this.objTareaRepository.findById(id).orElse(null);
    }

    public void delete(Long id){
        this.objTareaRepository.deleteById(id);
    }
}
