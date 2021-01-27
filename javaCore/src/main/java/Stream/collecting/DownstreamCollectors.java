package Stream.collecting;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.reducing;

/**
 * @author zzj
 * @date 2021/1/26 16:07
 **/
public class DownstreamCollectors {
    public static class City {
        private String name;
        private String state;
        private int population;

        public City(String name, String state, int population) {
            this.name = name;
            this.state = state;
            this.population = population;
        }

        public String getName() {
            return name;
        }

        public String getState() {
            return state;
        }

        public int getPopulation() {
            return population;
        }
    }

    public static Stream<City> readCities(String filename) throws IOException {
        return Files.lines(Paths.get(filename)).map(l -> l.split(","))
                .map((a -> new City(a[0], a[1], Integer.parseInt(a[2]))));
    }

    public static void main(String[] args) throws IOException {
        Stream<Locale> locales;
        locales = Stream.of(Locale.getAvailableLocales());
        Map<String, Set<Locale>> countryToLovalSet = locales.collect(Collectors.groupingBy(Locale::getCountry, Collectors.toSet()));
        System.out.println("countryToLocalSet: " + countryToLovalSet);

        locales = Stream.of(Locale.getAvailableLocales());
        Map<String, Long> countryToLovcaleCounts = locales.collect(Collectors.groupingBy(
                Locale::getCountry, Collectors.counting()
        ));
        System.out.println("countryToLocaleCounts:" + countryToLovcaleCounts);

        Stream<City> cities = readCities("cities.text");
        Map<String, Integer> stateToCityPopulation = cities.collect(Collectors.groupingBy(
                City::getState, Collectors.summingInt(City::getPopulation)
        ));
        System.out.println("stateToCityPopulation: " + stateToCityPopulation);

        cities = readCities("cities.text");
        Map<String, Optional<String>> stateToLongestCityName = cities.collect(Collectors.groupingBy(
                City::getState, Collectors.mapping(City::getName,
                        Collectors.maxBy((Comparator.comparing(String::length))))
        ));
        System.out.println("stateToLongestCityNama: " + stateToLongestCityName);

        locales = Stream.of(Locale.getAvailableLocales());
        Map<String, Set<String>> countryToLanguage = locales.collect(Collectors.groupingBy(
                Locale::getDisplayCountry, Collectors.mapping(Locale::getDisplayName,
                        Collectors.toSet())
        ));
        System.out.println("countryToLanguages: " + countryToLanguage);

        cities = readCities("cities.text");
        Map<String, IntSummaryStatistics> stateToCityPopulationSummary = cities.collect(Collectors.groupingBy(City::getState,
                Collectors.summarizingInt(City::getPopulation)));
        System.out.println(stateToCityPopulationSummary.get("NY"));

        cities = readCities("cities.text");
        Map<String, String> stateToCityNames = cities.collect(Collectors.groupingBy(
                City::getState, reducing("", City::getName, (s, t) -> s.length() == 0 ? t : s
                        + "," + t)
        ));

    }
}
