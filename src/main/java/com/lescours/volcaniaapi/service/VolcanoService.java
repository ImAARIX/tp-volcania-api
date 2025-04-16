package com.lescours.volcaniaapi.service;

import com.lescours.volcaniaapi.model.Volcano;
import com.lescours.volcaniaapi.repository.VolcanoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VolcanoService {

    @Autowired
    private VolcanoRepository volcanoRepository;

    public List<Volcano> getAll() {
        return volcanoRepository.findAll();
    }

    public Volcano findById(Long id) {
        return volcanoRepository.findVolcanoById(id);
    }

    public List<Volcano> findTenHighest() {
        return volcanoRepository.findTop10ByOrderByElevationDesc();
    }

    public List<Volcano> findTenLowest() {
        return volcanoRepository.findTop10ByOrderByElevationAsc();
    }

    public List<Volcano> findTenMostRecentActivities() {
        return volcanoRepository.findTop10ByOrderByLastKnownEruptionDesc();
    }

    public List<Volcano> findTenMostRecentEuropeanActivities() {
        return List.of();
    }

    public List<Volcano> findTenMostRecentAmericanActivities() {
        return volcanoRepository.findTop10ByCountryOrderByLastKnownEruptionDesc("United States");
    }

    public List<Volcano> findTenStratovolcanoByElevationDesc() {
        return volcanoRepository.findTop10ByPrimaryVolcanoTypeOrderByElevationDesc("Stratovolcano");
    }

}
