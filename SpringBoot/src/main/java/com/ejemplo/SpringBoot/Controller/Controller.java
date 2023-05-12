
package com.ejemplo.SpringBoot.Controller;

//Tenemos q mapearla, indicandole mediante una annotation springboot

import com.ejemplo.SpringBoot.model.Persona;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    
    List<Persona> listaPersonas = new ArrayList();
    
    
    @GetMapping ("/hola/{nombre}/{apellido}/{edad}") // => la url donde está este mensaje es :  localhost:8080/hola/Manuco/Ollo/27   
                                                     //x ej, lo que esta entre {} es un campo que puede varuiar.
    public String decirHola(@PathVariable String nombre,
                            @PathVariable String apellido,
                            @PathVariable int edad){ //@PathVariable permite que la URL varie según nuestro gusto.
        return "Hola mundo :D  -------->  " + nombre + "  |  apellido: " + apellido + "  |  Edad: " + edad;
    }
    
    @GetMapping ("/chau")
    public String decirChau (@RequestParam String nombre,
                            @RequestParam String apellido,
                            @RequestParam int edad){ 
        return "Chau mundo " + nombre + "  |  apellido: " + 
                apellido + "  |  Edad: " + edad; //Para ver esto en postman o en el navegador 
                                                 //tengo que tipear localhost:8080/chau?nombre=Manuco&apellido=Ollo&edad=27
    }
    
    // ---CREATE---
    @PostMapping ("/new/persona") //Método POST
    public void agregarPersona (@RequestBody Persona pers) { //La persona en cuestión va a venir en el 
                                                             //Cuerpo (body) de la Solicitud (Request) al servidor
                                                             //Recibiremos un JSON, que tendrá los datos de la Persona en cuestión
                                                             
        listaPersonas.add(pers);
    }
    
    // ---READ---
    //Una vez cargadas tosdas las Personas que quiero cargar.
    @GetMapping ("/ver/personas") //localhost:8080/ver/personas
    @ResponseBody
    //Al comunicarse la API con el cliente queremos que lo haga mediante JSON, para esto usamos @ResponseBody
    //lenguaje que el cliente entiende, Response = respuesta que le da el servidor al cliente
    public List<Persona> verPersonas () {
        return listaPersonas;
    }
    
}







