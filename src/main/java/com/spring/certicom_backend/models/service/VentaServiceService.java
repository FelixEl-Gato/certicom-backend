package com.spring.certicom_backend.models.service;

import com.spring.certicom_backend.models.entity.Venta;
import com.spring.certicom_backend.models.service.common.CrudService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;

public interface VentaServiceService extends CrudService<Venta, Long> {

    Page<Venta> findByFechaBetween(LocalDate dateStart, LocalDate dateEnd, Pageable pageable);
}
