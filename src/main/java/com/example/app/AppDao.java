package com.example.app;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AppDao extends CrudRepository<Appointment, Long> {
    List<Appointment> findByIndex(Long index);
}
