package com.spring.certicom_backend.controllers;

import com.spring.certicom_backend.models.entity.Producto;
import com.spring.certicom_backend.models.service.ProductoServiceService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping(
        path = "/api/v1/productos",
        produces = "application/json"
)
public class ProductoController {

    private final ProductoServiceService productoService;

    @GetMapping
    public ResponseEntity<Page<Producto>> getAllProductos(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "20") Integer size
    ) {
        Pageable pageable = Pageable.ofSize(size).withPage(page);
        Page<Producto> pageProductos = this.productoService.getAll(pageable);
        return ResponseEntity.ok(pageProductos);
    }

    @PostMapping
    public ResponseEntity<Producto> createProducto(@Valid @RequestBody Producto producto) {
        Producto newProducto = this.productoService.save(producto);
        return ResponseEntity.ok(newProducto);
    }

    @PutMapping
    public ResponseEntity<Producto> updateProducto(@Valid @RequestBody Producto producto) {
        Producto newProducto = this.productoService.save(producto);
        return ResponseEntity.ok(newProducto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Producto> deleteProducto(@PathVariable Long id) {
        Optional<Producto> productoOptional = this.productoService.getById(id);
        if (productoOptional.isEmpty()) {return ResponseEntity.notFound().build();}

        this.productoService.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
