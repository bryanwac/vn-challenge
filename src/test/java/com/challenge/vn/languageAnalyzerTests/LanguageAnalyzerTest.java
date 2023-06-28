package com.challenge.vn.languageAnalyzerTests;

import com.challenge.vn.languageAnalyzer.Country;
import com.challenge.vn.languageAnalyzer.LanguageAnalyzer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;


public class LanguageAnalyzerTest {

    @Test
    public void testParseJson() {
        String json = "[{\"country\":\"US\",\"languages\":[\"en\"]},{\"country\":\"BE\",\"languages\":[\"nl\",\"fr\",\"de\"]},{\"country\":\"NL\",\"languages\":[\"nl\",\"fy\"]},{\"country\":\"DE\",\"languages\":[\"de\",\"en\"]},{\"country\":\"ES\",\"languages\":[\"es\",\"en\",\"fr\"]},{\"country\":\"FR\",\"languages\":[\"fr\",\"en\"]},{\"country\":\"IT\",\"languages\":[\"it\",\"en\"]},{\"country\":\"RU\",\"languages\":[\"ru\"]}]";


        List<Country> countries = LanguageAnalyzer.parseJson(json);

        Assertions.assertEquals("US", countries.get(0).country());
        Assertions.assertEquals(List.of("en"), countries.get(0).languages());
    }

    @Test
    public void testGetTotalCountries() {
        List<Country> countries = Arrays.asList(
                new Country("US", Arrays.asList("en")),
                new Country("BE", Arrays.asList("nl", "fr", "de")),
                new Country("NL", Arrays.asList("nl", "fy"))
        );

        int totalCountries = LanguageAnalyzer.getTotalCountries(countries);

        Assertions.assertEquals(3, totalCountries);
    }

    @Test
    public void testGetCountryWithMostLanguages() {
        List<Country> countries = Arrays.asList(
                new Country("US", Arrays.asList("en")),
                new Country("BE", Arrays.asList("nl", "fr", "de")),
                new Country("NL", Arrays.asList("nl", "fy"))
        );

        Country countryWithMostLanguages = LanguageAnalyzer.getCountryWithMostLanguages(countries, "nl");

        Assertions.assertEquals("BE", countryWithMostLanguages.country());
    }

    @Test
    public void testCountTotalLanguages() {
        List<Country> countries = Arrays.asList(
                new Country("US", List.of("en")),
                new Country("BE", Arrays.asList("nl", "fr", "de")),
                new Country("NL", Arrays.asList("nl", "fy")),
                new Country("DE", Arrays.asList("de", "en")),
                new Country("ES", Arrays.asList("es", "en", "fr"))
        );

        int totalLanguages = LanguageAnalyzer.countTotalLanguages(countries);

        Assertions.assertEquals(6, totalLanguages);
    }

    @Test
    public void testGetCountryWithHighestLanguages() {
        List<Country> countries = Arrays.asList(
                new Country("US", List.of("en")),
                new Country("BE", Arrays.asList("nl", "fr", "de")),
                new Country("NL", Arrays.asList("nl", "fy")),
                new Country("DE", Arrays.asList("de", "en")),
                new Country("ES", Arrays.asList("es", "en", "fr"))
        );

        Country countryWithHighestLanguages = LanguageAnalyzer.getCountryWithHighestLanguages(countries);

        Assertions.assertEquals("BE", countryWithHighestLanguages.country());
    }

    @Test
    public void testGetMostCommonLanguages() {
        List<Country> countries = Arrays.asList(
                new Country("US", Arrays.asList("en")),
                new Country("BE", Arrays.asList("nl", "fr", "de")),
                new Country("NL", Arrays.asList("nl", "fy")),
                new Country("DE", Arrays.asList("de", "en")),
                new Country("ES", Arrays.asList("es", "en", "fr")),
                new Country("FR", Arrays.asList("fr", "en")),
                new Country("IT", Arrays.asList("it", "en")),
                new Country("RU", Arrays.asList("ru"))
        );

        List<String> mostCommonLanguages = LanguageAnalyzer.getMostCommonLanguages(countries);

        Assertions.assertEquals(List.of("en"), mostCommonLanguages);
    }
}