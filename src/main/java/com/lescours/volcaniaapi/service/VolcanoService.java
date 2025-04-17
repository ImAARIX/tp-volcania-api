package com.lescours.volcaniaapi.service;

import com.lescours.volcaniaapi.model.Volcano;
import com.lescours.volcaniaapi.repository.VolcanoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class VolcanoService {

    private final VolcanoRepository volcanoRepository;
    private final CountryService countryService;

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
        return findVolcanoByContinent("Europe", true);
    }

    public List<Volcano> findTenMostRecentAmericanActivities() {
        return volcanoRepository.findTop10ByCountryOrderByLastKnownEruptionDesc("United States");
    }

    public List<Volcano> findTenStratovolcanoByElevationDesc() {
        return volcanoRepository.findTop10ByPrimaryVolcanoTypeOrderByElevationDesc("Stratovolcano");
    }

    public List<Volcano> findVolcanoByContinent(String continent, Boolean topTen) {
        ArrayList<Volcano> volcanoes = new ArrayList<>();

        countryService.getAllCountriesForContinent(continent)
                .forEach(country -> {
                    if (topTen) {
                        volcanoes.addAll(volcanoRepository.findTop10ByCountryOrderByLastKnownEruptionDesc(country));
                    } else {
                        volcanoes.addAll(volcanoRepository.findByCountry(country));
                    }
                });

        if (topTen) {
            ArrayList<Volcano> sortedVolcanoes = volcanoes;
            // On a pas besoin de ceux avec lastKnownEruption = null, donc on les vire
            sortedVolcanoes.removeIf(volcano -> volcano.getLastKnownEruption() == null);

            // On trie par date d'éruption
            sortedVolcanoes.sort((v1, v2) -> v2.getLastKnownEruption().compareTo(v1.getLastKnownEruption()));
            if (sortedVolcanoes.size() > 10) {
                // On garde que les 10 premiers
                sortedVolcanoes = new ArrayList<>(sortedVolcanoes.subList(0, 10));
            }

            return sortedVolcanoes;
        }

        return volcanoes;
    }

}
