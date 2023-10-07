package com.spring.certicom_backend.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ventas")
@Data
public class Venta{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    @NotNull(message = "La fecha no puede ser nula")
    @Column(nullable = false)
    private LocalDate fecha;

    @OneToMany(mappedBy = "venta", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<DetalleVenta> detallesVenta = new ArrayList<>();

    /**
     * Establece los detalles de venta y asegura la bidireccionalidad de la relación.
     *
     * @param detallesVenta lista de detalles de venta.
     */
    public void setDetallesVenta(List<DetalleVenta> detallesVenta) {
        detallesVenta.forEach(this::addDetalleVenta);
    }

    /**
     * Añade un detalle de venta y asegura la bidireccionalidad de la relación.
     *
     * @param detalleVenta detalle de venta a añadir.
     */
    private void addDetalleVenta(DetalleVenta detalleVenta) {
        detalleVenta.setVenta(this);
        this.detallesVenta.add(detalleVenta);
    }
}
