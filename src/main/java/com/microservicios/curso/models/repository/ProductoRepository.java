package com.microservicios.curso.models.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservicios.curso.models.entitys.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

}
