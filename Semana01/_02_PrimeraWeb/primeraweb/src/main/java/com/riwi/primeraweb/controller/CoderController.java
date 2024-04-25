package com.riwi.primeraweb.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.riwi.primeraweb.entity.Coder;
import com.riwi.primeraweb.services.CoderService;

@Controller
@RequestMapping("/")
public class CoderController {

    @Autowired
    private CoderService objCoderService;

    //Metodo para mostrar la vista y enviarle la lista de coders
    @GetMapping
    public String showViewGetAll(Model objModel, @RequestParam(defaultValue = "1" ) int page, @RequestParam(defaultValue = "3") int size){
        // Indico que se guade la lista de coders en service
        Page<Coder> list = this.objCoderService.fingPaginated(page-1, size);
        objModel.addAttribute("coderList", list); // Llave - valor
        objModel.addAttribute("currentPage", page); // Llave - valor
        objModel.addAttribute("totalPages", list.getTotalPages()); // Llave - valor
        return "viewCoder"; // Se debe retornar el nombre exacto de la vista HTML, ej: sí nombre index.html se coloca solo index
    }

    @GetMapping("/form")
    public String showViewFormCoder(Model objModel){
        objModel.addAttribute("coder", new Coder());
        objModel.addAttribute("action", "/coder/create");
        return "viewForm";
    }

    // Método para insertar un coder mediante el POST
    @PostMapping("/coder/create")
    public String createCoder(@ModelAttribute Coder objCoder){ //ModelAttribute se encarga de obtener la informacion de la vista
        this.objCoderService.insert(objCoder); //Llamamos al servicio enviándole el servicio a insertar
        return "redirect:/"; //Redireccionamos a la vista de todos los coders
    }

    //Método para mostrar el fomulario de actualizar un coder
    @GetMapping("/update/{id}")
    public String showFormUpdate(@PathVariable Long id, Model objModel){ //Se recibe como parametro con Path 
        Coder objCoderFind = this.objCoderService.findById(id);
        objModel.addAttribute("coder", objCoderFind);
        objModel.addAttribute("action", "/edit/" + id);
        return "viewForm";
    }

    //Método para actualizar
    @PostMapping("/edit/{id}") //Obtener por path el id
    public String updateCoder(@PathVariable Long id, @ModelAttribute Coder objCoder){
        this.objCoderService.update(id, objCoder);
        return "redirect:/";
    }

    //Método eliminar
    @GetMapping("/delete/{id}")
    public String deleteCoder(@PathVariable Long id){
        this.objCoderService.delete(id);
        return "redirect:/";
    }

}
