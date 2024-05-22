package com.microservicios.curso.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.microservicios.curso.models.entitys.Producto;
import com.microservicios.curso.models.repository.ProductoRepository;

// PRODUCTOserviceimpl sirve como una capa entre controlador y repositori de datos que gestiona la logica de negocio
//utiliza el repositorio para interectuar con la bd y ofrece metodos especifcios.
@Service
public class ProductoServiceImpl implements ProductoService {

    // la injectamos Esta anotación le dice a Spring que inyecte automáticamente la
    // instancia apropiada de productorepository en esta clase.
    @Autowired
    private ProductoRepository productoRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Producto> findAll() {

        return  productoRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Producto findById(Long id) {

       return  productoRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Producto updateProducto(Producto producto, Long id) {

        throw new UnsupportedOperationException("Unimplemented method 'updateProducto'");
    }

    @Override
    @Transactional
    public void deleteProductoById(Long id) {

        throw new UnsupportedOperationException("Unimplemented method 'deleteProductoById'");
    }

    @Override
    @Transactional
    public Producto saveProducto(Producto producto) {

        throw new UnsupportedOperationException("Unimplemented method 'saveProducto'");
    }

}
