package com.spring.certicom_backend.models.service.implement;

import com.spring.certicom_backend.models.dao.VentaDao;
import com.spring.certicom_backend.models.entity.Venta;
import com.spring.certicom_backend.models.service.VentaServiceService;
import com.spring.certicom_backend.models.service.common.CrudImplService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class VentaImpl extends CrudImplService<Venta, Long> implements VentaServiceService {

    private final VentaDao ventaDao;

    @Override
    protected JpaRepository<Venta, Long> getRepository() {
        return ventaDao;
    }

    @Override
    public Page<Venta> findByFechaBetween(LocalDate dateStart, LocalDate dateEnd, Pageable pageable) {
        return ventaDao.findByFechaBetween(dateStart, dateEnd, pageable);
    }
}
