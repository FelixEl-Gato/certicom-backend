package com.spring.certicom_backend.models.dao;

import com.spring.certicom_backend.models.entity.Venta;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface VentaDao extends JpaRepository<Venta, Long>{

    /**
     * Encuentra todas las ventas entre dos fechas dadas.
     *
     * @param dateStart La fecha de inicio para buscar.
     * @param dateEnd La fecha final para buscar.
     * @param pageable El objeto pageable para paginación.
     * @return Un objeto Page conteniendo las ventas encontradas.
     */
    Page<Venta> findByFechaBetween(LocalDate dateStart, LocalDate dateEnd, Pageable pageable);
}
