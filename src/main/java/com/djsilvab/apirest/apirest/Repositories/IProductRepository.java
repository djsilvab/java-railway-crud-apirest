package com.djsilvab.apirest.apirest.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.djsilvab.apirest.apirest.Entities.Producto;

public interface IProductRepository extends JpaRepository<Producto, Long> {

}
