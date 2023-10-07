package com.spring.certicom_backend.models.service.implement;

import com.spring.certicom_backend.models.dao.ClienteDao;
import com.spring.certicom_backend.models.entity.Cliente;
import com.spring.certicom_backend.models.service.ClienteServiceService;
import com.spring.certicom_backend.models.service.common.CrudImplService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClienteImpl extends CrudImplService<Cliente, Long> implements ClienteServiceService {

    private final ClienteDao clienteDao;

    @Override
    protected JpaRepository<Cliente, Long> getRepository() {
        return this.clienteDao;
    }
}
