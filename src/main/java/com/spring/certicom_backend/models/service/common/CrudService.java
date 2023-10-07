package com.spring.certicom_backend.models.service.common;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Crud Service Interface para operaciones CRUD
 *
 * @param <T>  Type de la Identidad.
 * @param <ID> Tipo del identificador de la identidad.
 */
public interface CrudService<T, ID> {

    Page<T> getAll(Pageable p);
    Optional<T> getById(ID id);
    T save(T t);
    void deleteById(ID id);
}
