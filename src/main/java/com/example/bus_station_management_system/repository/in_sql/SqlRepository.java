package com.example.bus_station_management_system.repository.in_sql;

import com.example.bus_station_management_system.model.Identifiable;
import com.example.bus_station_management_system.repository.IRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public abstract class SqlRepository<T extends Identifiable> implements IRepository<T> {

    protected final JpaRepository<T, String> jpaRepository;

    protected SqlRepository(JpaRepository<T, String> jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public T create(T entity) {
        return jpaRepository.save(entity);
    }

    @Override
    public T update(T entity) {
        return jpaRepository.save(entity);
    }

    @Override
    public List<T> findAll() {
        return jpaRepository.findAll();
    }

    @Override
    public Optional<T> findById(String id) {
        return jpaRepository.findById(id);
    }

    @Override
    public boolean existsById(String id) {
        return jpaRepository.existsById(id);
    }

    @Override
    public void delete(String id) {
        jpaRepository.deleteById(id);
    }
}
