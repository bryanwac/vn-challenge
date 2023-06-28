package com.challenge.vn;

import com.challenge.vn.languageAnalyzer.Country;
import com.challenge.vn.languageAnalyzer.LanguageAnalyzer;
import com.challenge.vn.numberPrinter.NumberPrinter;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class VnApplication {

	private static final String JSON = "[{\"country\":\"US\",\"languages\":[\"en\"]},{\"country\":\"BE\",\"languages\":[\"nl\",\"fr\",\"de\"]},{\"country\":\"NL\",\"languages\":[\"nl\",\"fy\"]},{\"country\":\"DE\",\"languages\":[\"de\"]},{\"country\":\"ES\",\"languages\":[\"es\"]}]";

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		NumberPrinter numberPrinter = new NumberPrinter();

		while (true) {
			System.out.println("Menu:");
			System.out.println("1. Execute NumberPrinter");
			System.out.println("2. Execute LanguageAnalyzer");
			System.out.println("0. Exit");

			int choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
				case 1 -> {
					System.out.println("NumberPrinter Output:");
					numberPrinter.printNumbers(1, 100);
				}
				case 2 -> {
					System.out.println("JSON:");
					System.out.println(formatJson());
					System.out.println("LanguageAnalyzer Results:");
					List<Country> countries = LanguageAnalyzer.parseJson(JSON);
					int totalCountries = LanguageAnalyzer.getTotalCountries(countries);
					Country countryWithMostLanguages = LanguageAnalyzer.getCountryWithMostLanguages(countries, "de");
					int totalLanguages = LanguageAnalyzer.countTotalLanguages(countries);
					Country countryWithHighestLanguages = LanguageAnalyzer.getCountryWithHighestLanguages(countries);
					List<String> mostCommonLanguages = LanguageAnalyzer.getMostCommonLanguages(countries);
					System.out.println("Total Countries: " + totalCountries);
					System.out.println("Country with Most Languages: " + countryWithMostLanguages.country());
					System.out.println("Total Languages: " + totalLanguages);
					System.out.println("Country with Highest Languages: " + countryWithHighestLanguages.country());
					System.out.println("Most Common Languages: " + mostCommonLanguages);
				}
				case 0 -> {
					System.out.println("Finishing application...");
					return;
				}
				default -> System.out.println("Invalid option. Please choose a valid option.");
			}

			System.out.println();
		}
	}

	private static String formatJson() {
		StringBuilder formattedJson = new StringBuilder();
		int indentLevel = 0;

		for (char c : VnApplication.JSON.toCharArray()) {
			if (c == '{' || c == '[') {
				formattedJson.append(c).append("\n");
				indentLevel++;
				appendIndentation(formattedJson, indentLevel);
			} else if (c == '}' || c == ']') {
				formattedJson.append("\n");
				indentLevel--;
				appendIndentation(formattedJson, indentLevel);
				formattedJson.append(c);
			} else if (c == ',') {
				formattedJson.append(c).append("\n");
				appendIndentation(formattedJson, indentLevel);
			} else {
				formattedJson.append(c);
			}
		}

		return formattedJson.toString();
	}

	private static void appendIndentation(StringBuilder stringBuilder, int indentLevel) {
		stringBuilder.append("    ".repeat(Math.max(0, indentLevel))); // 4 spaces for each indentation level
	}
}
