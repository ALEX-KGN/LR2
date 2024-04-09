package by.bsuir.lr2;

import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateful;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Stateful
@LocalBean
public class SeriesRepository implements Serializable {
    private Map<String, Series> seriesMap = new HashMap<>();

    public SeriesRepository() {

        Series theBoyes = Series.builder()
                .name("The Boys")
                .rating(7.5)
                .numbers(12)
                .build();

        Series breakingBad = Series.builder()
                .name("Breaking Bad")
                .rating(9.5)
                .numbers(62)
                .build();

        Series strangerThings = Series.builder()
                .name("Stranger Things")
                .rating(8.7)
                .numbers(25)
                .build();

        Series gameOfThrones = Series.builder()
                .name("Game of Thrones")
                .rating(9.3)
                .numbers(73)
                .build();

        Series theMandalorian = Series.builder()
                .name("The Mandalorian")
                .rating(8.8)
                .numbers(16)
                .build();

        seriesMap.put(theBoyes.getName(), theBoyes);
        seriesMap.put(breakingBad.getName(), breakingBad);
        seriesMap.put(strangerThings.getName(), strangerThings);
        seriesMap.put(gameOfThrones.getName(), gameOfThrones);
        seriesMap.put(theMandalorian.getName(), theMandalorian);

    }

    public void save(Series series) {
        seriesMap.put(series.getName(), series);
    }

    public List<Series> getByRating(Double rating) {
        return seriesMap.values().stream().filter(series -> series.getRating() >= rating).collect(Collectors.toList());
    }

    public Series getById(String id) {
        return seriesMap.get(id);
    }
}
