package com.lescours.volcaniaapi.service;

import com.lescours.volcaniaapi.model.Country;
import com.lescours.volcaniaapi.repository.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CountryService {

    private final CountryRepository countryRepository;

    public List<String> getAllCountriesForContinent(String continent) {
        return countryRepository.findAllByContinent(continent)
                .stream()
                .map(Country::getName)
                .toList();
    }

}
