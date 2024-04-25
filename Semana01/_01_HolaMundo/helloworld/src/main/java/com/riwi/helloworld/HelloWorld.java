package com.riwi.helloworld;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


//Se indica que esta clase será un controlador
@Controller
//Se crea la ruta del controlador con RequestMapping
@RequestMapping("/controller")
public class HelloWorld {

    //Se crea una ruta especifica para el proyecto con GetMapping
    @GetMapping("/helloworld")
    //ResponseBody nos permite responder al navegador
    @ResponseBody
    public String mostrarmensaje(){
        return "Hello World";
    }

    @GetMapping("/suma")
    @ResponseBody
    public String suma(){
        int a = 2, b = 2;
        return String.valueOf(a + b);
    }

    @GetMapping("/prueba")
    @ResponseBody
    public String prueba(){
        return mostrarmensaje() + " - " + suma() ;
    }
}
