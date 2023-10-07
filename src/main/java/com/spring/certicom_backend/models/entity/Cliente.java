package com.spring.certicom_backend.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "clientes")
@Data
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "El nombre no puede ser nulo")
    @Column(nullable = false)
    private String nombres;

    @NotNull(message = "Los apellidos no pueden ser nulos")
    @Column(nullable = false)
    private String apellidos;

    @NotNull(message = "El DNI no puede ser nulo")
    @Size(min = 8, max = 8, message = "El DNI debe tener 8 caracteres")
    @Column(nullable = false, unique = true)
    private String dni;
    private String telefono;

    @Email(message = "El email no es válido")
    private String email;

    @OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY, orphanRemoval = true)
    @JsonIgnore
    private List<Venta> ventas = new ArrayList<>();

    @Serial
    private static final long serialVersionUID = 1L;
}
