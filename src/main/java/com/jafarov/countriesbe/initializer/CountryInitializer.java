package com.jafarov.countriesbe.initializer;
import com.jafarov.countriesbe.entity.Country;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.util.*;

@Slf4j
public class CountryInitializer {

    public static List<Country> readCountries() {
        String root = System.getProperty("user.dir");

        List<Country> countryList = new ArrayList<>();
        try {
            File countryJson = new File(root + "/assets/countries.json");
            Map<String,Map<String, Object>> result = new ObjectMapper().readValue(countryJson, HashMap.class);
            for (String code : result.keySet()){
                Map<String,Object> valueMap = result.get(code);
                String name = valueMap.get("name").toString();
                String nativeName = valueMap.get("native").toString();
                String continent = valueMap.get("continent").toString();
                String capital = valueMap.get("capital").toString();
                String currency = valueMap.get("currency").toString();
                String language = valueMap.get("languages").toString();
                int phone;
                try{
                    phone = Integer.parseInt(valueMap.get("phone").toString());
                }catch (NumberFormatException exception){
                    phone = -1;
                }
                String flagUrl = generateFlagUrl(code);
                Country c = Country.builder()
                        .code(code)
                        .name(name)
                        .nativeName(nativeName)
                        .phone(phone)
                        .capital(capital)
                        .continent(continent)
                        .currency(currency)
                        .language(language)
                        .flag(flagUrl)
                        .build();
                countryList.add(c);
            }
        }catch (Exception exception){
            System.out.println("Dosya işlemlerinde bir hata meydana geldi.");
            log.error("Dosya işlemlerinde bir hata meydana geldi. Exception Detail: " + exception.getMessage());
        }
        return countryList;
    }

    private static String generateFlagUrl(String id){
        return "http://aedemirsen.bilgimeclisi.com/country_flags/" + id + ".svg";
    }
}