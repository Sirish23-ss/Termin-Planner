package com.example.app;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface dao extends CrudRepository<Termin, Long> {

    public List<Termin> findByIndex(Long index);

    @Query(value = "select * From xyz WHERE id <>:n",nativeQuery = true)
    public List<Termin> getAll(@Param("n") Long id);
}
