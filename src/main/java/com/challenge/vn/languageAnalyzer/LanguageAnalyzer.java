package com.challenge.vn.languageAnalyzer;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.*;

public class LanguageAnalyzer {

    public static List<Country> parseJson(String json) {
        Gson gson = new Gson();
        Type countryListType = new TypeToken<List<Country>>() {}.getType();
        return gson.fromJson(json, countryListType);
    }

    public static int getTotalCountries(List<Country> countries) {
        return countries.size();
    }

    public static Country getCountryWithMostLanguages(List<Country> countries, String language) {
        Country countryWithMostLanguages = null;
        int maxLanguages = 0;

        for (Country country : countries) {
            if (country.languages().contains(language) && country.languages().size() > maxLanguages) {
                countryWithMostLanguages = country;
                maxLanguages = country.languages().size();
            }
        }

        return countryWithMostLanguages;
    }

    public static int countTotalLanguages(List<Country> countries) {
        Set<String> allLanguages = new HashSet<>();

        for (Country country : countries) {
            allLanguages.addAll(country.languages());
        }

        return allLanguages.size();
    }

    public static Country getCountryWithHighestLanguages(List<Country> countries) {
        Country countryWithHighestLanguages = null;
        int maxLanguages = 0;

        for (Country country : countries) {
            if (country.languages().size() > maxLanguages) {
                countryWithHighestLanguages = country;
                maxLanguages = country.languages().size();
            }
        }

        return countryWithHighestLanguages;
    }

    public static List<String> getMostCommonLanguages(List<Country> countries) {
        Map<String, Integer> languageCount = new HashMap<>();

        for (Country country : countries) {
            for (String language : country.languages()) {
                languageCount.put(language, languageCount.getOrDefault(language, 0) + 1);
            }
        }

        int maxCount = 0;
        for (int count : languageCount.values()) {
            if (count > maxCount) {
                maxCount = count;
            }
        }

        List<String> mostCommonLanguages = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : languageCount.entrySet()) {
            if (entry.getValue() == maxCount) {
                mostCommonLanguages.add(entry.getKey());
            }
        }

        return mostCommonLanguages;
    }
}
