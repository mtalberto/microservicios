package com.microservicios.curso.models.services;

import java.util.List;



import com.microservicios.curso.models.entitys.Producto;


public interface ProductoService {




    List<Producto> findAll();

    Producto findById(Long id);

    Producto updateProducto(Producto producto, Long id);

    void deleteProductoById(Long id);
    
    Producto saveProducto(Producto producto);

    
}
