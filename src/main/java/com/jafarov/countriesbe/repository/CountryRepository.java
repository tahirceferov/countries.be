package com.jafarov.countriesbe.repository;

import com.jafarov.countriesbe.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country,String> {
}
