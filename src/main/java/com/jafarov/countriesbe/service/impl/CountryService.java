package com.jafarov.countriesbe.service.impl;

import com.jafarov.countriesbe.entity.Country;
import com.jafarov.countriesbe.initializer.CountryInitializer;
import com.jafarov.countriesbe.repository.CountryRepository;
import com.jafarov.countriesbe.service.interfaces.ICountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CountryService implements ICountryService {

private final CountryRepository countryRepository;
    @Override
    public List<Country> getAllCountries() {
return countryRepository.findAll();
    }

    @Override
    public List<Country> insertCountries() {
        return countryRepository.saveAll(CountryInitializer.readCountries());
    }
}
