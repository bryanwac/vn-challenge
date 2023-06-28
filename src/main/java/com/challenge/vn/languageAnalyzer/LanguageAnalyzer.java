package com.challenge.vn.languageAnalyzer;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.*;
import java.util.stream.Collectors;

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
        return countries.stream()
                .filter(country -> country.languages().contains(language))
                .max(Comparator.comparingInt(country -> country.languages().size()))
                .orElse(null);
    }

    public static int countTotalLanguages(List<Country> countries) {
        return countries.stream()
                .flatMap(country -> country.languages().stream())
                .collect(Collectors.toSet())
                .size();
    }

    public static Country getCountryWithHighestLanguages(List<Country> countries) {
        return countries.stream()
                .max(Comparator.comparingInt(country -> country.languages().size()))
                .orElse(null);
    }

    public static List<String> getMostCommonLanguages(List<Country> countries) {
        Map<String, Integer> languageCount = new HashMap<>();

        countries.forEach(country ->
                country.languages().forEach(language ->
                        languageCount.put(language, languageCount.getOrDefault(language, 0) + 1))
        );

        int maxCount = languageCount.values().stream()
                .max(Comparator.naturalOrder())
                .orElse(0);

        return languageCount.entrySet().stream()
                .filter(entry -> entry.getValue() == maxCount)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
}