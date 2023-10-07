package com.spring.certicom_backend.controllers;

import com.spring.certicom_backend.models.entity.Cliente;
import com.spring.certicom_backend.models.service.ClienteServiceService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(
        path = "/api/v1/clientes",
        produces = "application/json"
)
public class ClienteController {

    private final ClienteServiceService clienteService;

    @GetMapping
    public ResponseEntity<Page<Cliente>> getAllClientes(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "20") Integer size
    ) {
        Pageable pageable = Pageable.ofSize(size).withPage(page);
        Page<Cliente> pageClientes = this.clienteService.getAll(pageable);
        return ResponseEntity.ok(pageClientes);
    }

    @PostMapping
    public ResponseEntity<Cliente> createCliente(@Valid @RequestBody Cliente cliente) {
        Cliente newCliente = this.clienteService.save(cliente);
        return new ResponseEntity<>(newCliente, HttpStatus.CREATED);
    }
}
