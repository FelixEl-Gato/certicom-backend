package com.spring.certicom_backend.models.dao;

import com.spring.certicom_backend.models.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteDao extends JpaRepository<Cliente, Long> {

//    @Query("select c from Cliente c left join fetch c.ventas f where c.id=?1")
//    Cliente fetchByIdWithFacturas(Long id);
}
