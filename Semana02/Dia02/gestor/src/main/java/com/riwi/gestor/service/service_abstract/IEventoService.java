package com.riwi.gestor.service.service_abstract;


import org.springframework.data.domain.Page;

import com.riwi.gestor.entity.Eventos;

public interface IEventoService {
    
    public Eventos save(Eventos eventos);

    public Page<Eventos> getAll(int page, int size);

    public Eventos findById(String id);

    public void delete(String id);

    public Eventos update(String id, Eventos eventos);
    
}
