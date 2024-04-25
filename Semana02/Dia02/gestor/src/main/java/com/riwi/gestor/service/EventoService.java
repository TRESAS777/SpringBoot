package com.riwi.gestor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.riwi.gestor.entity.Eventos;
import com.riwi.gestor.repository.EventoRepository;
import com.riwi.gestor.service.service_abstract.IEventoService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EventoService implements IEventoService {

    @Autowired
    private final EventoRepository objEventoRepository;

    @Override
    public Eventos save(Eventos eventos) {
        return this.objEventoRepository.save(eventos);
    }

    @Override
    public Page<Eventos> getAll( int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return this.objEventoRepository.findAll(pageable);
    }

    @Override
    public Eventos findById(String id) {
        return this.objEventoRepository.findById(id).orElseThrow();
    }

    @Override
    public void delete(String id) {
        Eventos eventosFind = this.objEventoRepository.findById(id).orElseThrow();
        this.objEventoRepository.delete(eventosFind);
    }

    @Override
    public Eventos update(String id, Eventos eventos) {
        this.objEventoRepository.findById(id).orElseThrow();
        eventos.setId(id);
        return this.objEventoRepository.save(eventos);
    }
    
}
