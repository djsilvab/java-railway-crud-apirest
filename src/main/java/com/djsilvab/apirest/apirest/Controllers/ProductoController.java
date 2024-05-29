package com.djsilvab.apirest.apirest.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.djsilvab.apirest.apirest.Entities.Producto;
import com.djsilvab.apirest.apirest.Repositories.IProductRepository;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private IProductRepository iproductoRepository;

    @GetMapping("/{id}")
    public Producto GetOneProduct(@PathVariable Long id)
    {
        return iproductoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontró el producto con ID:"+ id));
    }

    @GetMapping
    public List<Producto> GetAllProducts()
    {
        return iproductoRepository.findAll();
    }

    @PostMapping
    public Producto CreateProduct(@RequestBody Producto producto)
    {
        return iproductoRepository.save(producto);
    }

    @PutMapping("/{id}")
    public Producto UpdateProduct(@PathVariable Long id, @RequestBody Producto detalleProducto)
    {
        Producto producto = iproductoRepository.findById(id)
                                                .orElseThrow(() -> new RuntimeException("No se encontró el producto con ID:"+ id));
        
        producto.setNombre(detalleProducto.getNombre());
        producto.setPrecio(detalleProducto.getPrecio());

        return iproductoRepository.save(producto);
    }

    @DeleteMapping("/{id}")
    public String DeleteProduc(@PathVariable Long id){
        Producto producto = iproductoRepository.findById(id)
                                                .orElseThrow(() -> new RuntimeException("No se encontró el producto con ID:"+ id));

        iproductoRepository.delete(producto); 
        return "El producto con ID" + id +" fue eliminado";
    }

}
