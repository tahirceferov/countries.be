package com.jafarov.countriesbe.controller;

import com.jafarov.countriesbe.entity.Country;
import com.jafarov.countriesbe.service.interfaces.ICountryService;
import com.jafarov.countriesbe.util.constants.Api;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(Api.Country.BASE_URL)
@AllArgsConstructor
public class CountryController {
    private final ICountryService countryService;

@GetMapping
    public List<Country> getAllCountries(){
return countryService.getAllCountries();
}
    @PostMapping(Api.Country.INSERT_ALL)
    public List<Country> insertCountries(){
        return countryService.insertCountries();
    }

}
