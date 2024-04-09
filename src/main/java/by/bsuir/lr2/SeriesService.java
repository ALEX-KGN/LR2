package by.bsuir.lr2;

import jakarta.ejb.EJB;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Stateless
public class SeriesService {

    @EJB
    private SeriesRepository seriesRepository;

    public List<Series> getByRating(double rating) {
        return seriesRepository.getByRating(rating);
    }

    public void save(Series series) {
        seriesRepository.save(series);
    }

    public Series getById(String id) {
        return seriesRepository.getById(id);
    }
}
