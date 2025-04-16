package com.lescours.volcaniaapi.repository;

import com.lescours.volcaniaapi.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> {
    List<Country> findAllByContinent(String continent);
    Country findByName(String name);
    boolean existsByName(String name);
}
