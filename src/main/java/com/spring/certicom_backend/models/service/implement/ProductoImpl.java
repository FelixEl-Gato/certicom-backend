package com.spring.certicom_backend.models.service.implement;

import com.spring.certicom_backend.models.dao.ProductoDao;
import com.spring.certicom_backend.models.entity.Producto;
import com.spring.certicom_backend.models.service.ProductoServiceService;
import com.spring.certicom_backend.models.service.common.CrudImplService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductoImpl extends CrudImplService<Producto, Long> implements ProductoServiceService {

    private final ProductoDao productoDao;

    @Override
    protected JpaRepository<Producto, Long> getRepository() {
        return productoDao;
    }
}
