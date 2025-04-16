package com.lescours.volcaniaapi.repository;

import com.lescours.volcaniaapi.model.Volcano;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VolcanoRepository extends JpaRepository<Volcano, Long> {

    Volcano findVolcanoById(Long id);
    List<Volcano> findByCountry(String country);
    List<Volcano> findTop10ByOrderByElevationDesc();
    List<Volcano> findTop10ByOrderByElevationAsc();
    List<Volcano> findTop10ByOrderByLastKnownEruptionDesc();
    List<Volcano> findTop10ByPrimaryVolcanoTypeOrderByElevationDesc(String primaryVolcanoType);
    List<Volcano> findTop10ByCountryOrderByLastKnownEruptionDesc(String country);
    boolean existsVolcanoById(Long id);
    Volcano findVolcanoByName(String name);
    boolean existsVolcanoByName(String name);
}
