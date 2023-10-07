package com.spring.certicom_backend.models.service.common;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
public abstract class CrudImplService<T, ID> implements CrudService<T, ID> {

    /**
     * Provides the specific JpaRepository for the implementing service.
     *
     * @return the JpaRepository.
     */

    protected abstract JpaRepository<T,ID> getRepository();

    @Override
    public Page<T> getAll(Pageable p) {
        return getRepository().findAll(p);
    }

    @Override
    public Optional<T> getById(ID id) {
        return getRepository().findById(id);
    }

    @Override
    public T save(T t) {
        return getRepository().save(t);
    }

    @Override
    public void deleteById(ID id) {
        getRepository().deleteById(id);
    }
}
