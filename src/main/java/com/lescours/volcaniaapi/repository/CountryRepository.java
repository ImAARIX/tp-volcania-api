package com.lescours.volcaniaapi.repository;

import com.lescours.volcaniaapi.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> {
    Country findByName(String name);
    boolean existsByName(String name);
}
