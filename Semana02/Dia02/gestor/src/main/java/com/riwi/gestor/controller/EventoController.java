package com.riwi.gestor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.gestor.entity.Eventos;
import com.riwi.gestor.service.service_abstract.IEventoService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/eventos")
@AllArgsConstructor
public class EventoController {
    
    @Autowired
    private final IEventoService objEventoService;

    @GetMapping
    public ResponseEntity<Page<Eventos>> getAll(@PageableDefault(page = 0, size = 1) @RequestParam int page, @RequestParam int size){

        return ResponseEntity.ok(this.objEventoService.getAll(page, size));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Eventos> get(@PathVariable String id){
        return ResponseEntity.ok(this.objEventoService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Eventos> insert(@RequestBody Eventos objEventos){
        return ResponseEntity.ok(this.objEventoService.save(objEventos));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Eventos> update
    (
        @PathVariable String id,
        @RequestBody Eventos eventos
    ){
        return ResponseEntity.ok(this.objEventoService.update(id, eventos));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        this.objEventoService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
