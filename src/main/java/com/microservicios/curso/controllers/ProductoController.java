package com.microservicios.curso.controllers;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RestController;

import com.microservicios.curso.models.entitys.Producto;
import com.microservicios.curso.models.services.ProductoService;



import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


//indicar que un controlador rest controller
@RestController
public class ProductoController {

    @Autowired
    private ProductoService productoService;


    @Autowired
    private Environment env;
    int port ;
    
    @GetMapping("/listaProductos")
    public List<Producto> lista(){
         port = Integer.parseInt(env.getProperty("local.server.port"));
        return productoService.findAll().stream().map(producto ->{
		producto.setPort(port);
			return producto;
		}).collect(Collectors.toList());

    }

    @GetMapping("/ver/{id}")
    public Producto verProducto(@PathVariable Long id) throws InterruptedException{
         port = Integer.parseInt(env.getProperty("local.server.port"));
        //TESTING
         if(id.equals(10L)){
            throw new IllegalStateException("Producto no encontrado!");
         }
         //TESTING
        if(id.equals(7L)){
            TimeUnit.SECONDS.sleep(5L);
         }
        Producto producto = productoService.findById(id);
      
        producto.setPort(port);
        return producto;

    }



}
