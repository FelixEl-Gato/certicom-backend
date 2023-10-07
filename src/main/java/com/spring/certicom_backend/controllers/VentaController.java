package com.spring.certicom_backend.controllers;

import com.spring.certicom_backend.models.entity.Venta;
import com.spring.certicom_backend.models.service.VentaServiceService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping(
        path = "/api/v1/ventas",
        produces = "application/json"
)
public class VentaController {

    private final VentaServiceService ventaService;

    @GetMapping(params = {"page", "size"})
    public ResponseEntity<Page<Venta>> getAllVentas(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "20") Integer size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Venta> pageVentas = this.ventaService.getAll(pageable);
        return ResponseEntity.ok(pageVentas);
    }

    @GetMapping("{id}")
    public ResponseEntity<Venta> getVentaById(@PathVariable Long id) {

        Optional<Venta> optionalVenta = this.ventaService.getById(id);

        return optionalVenta
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping(params = {"dateStart", "dateEnd", "page", "size"})
    public ResponseEntity<Page<Venta>> getVentasByDate(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateStart,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateEnd,
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "20") Integer size
    ) {
        Page<Venta> pageVentas = this.ventaService.findByFechaBetween(dateStart, dateEnd, PageRequest.of(page, size));
        return ResponseEntity.ok(pageVentas);
    }

    @PostMapping
    public ResponseEntity<Venta> createVenta(@Valid @RequestBody Venta venta) {
        Venta newVenta = this.ventaService.save(venta);
        return ResponseEntity.ok(newVenta);
    }
}
