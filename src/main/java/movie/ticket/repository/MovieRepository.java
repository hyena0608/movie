package movie.ticket.repository;

import movie.ticket.domain.movie.Movie;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class MovieRepository {

    private static final Map<Long, Movie> movies = new HashMap<>();

    public Collection<Movie> findAllMovies() {
        return movies.values()
                .stream()
                .collect(Collectors.toUnmodifiableList());
    }
}
