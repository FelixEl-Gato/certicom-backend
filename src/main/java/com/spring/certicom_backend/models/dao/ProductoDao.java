package com.spring.certicom_backend.models.dao;

import com.spring.certicom_backend.models.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoDao extends JpaRepository<Producto, Long> {

//    @Query("select v from Venta v join fetch v.cliente c join fetch v.detalleVenta l join fetch l.producto where v.id=?1")
//    Producto fetchByIdWithClienteWithItemFacturaWithProducto(Long id);
}
