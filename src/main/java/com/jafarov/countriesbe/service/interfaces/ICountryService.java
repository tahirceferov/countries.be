package com.jafarov.countriesbe.service.interfaces;

import com.jafarov.countriesbe.entity.Country;

import java.util.List;
import java.util.ListResourceBundle;

public interface ICountryService {

    List<Country> getAllCountries();
    List<Country> insertCountries();
}
