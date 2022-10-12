package movie.ticket.repository;

import movie.ticket.domain.movie.Movie;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static movie.ticket.exception.MovieException.MOVIE_NOT_FOUND_EXCEPTION;

public class MovieRepository {

    private static final Map<Long, Movie> movies = new HashMap<>();

    public Collection<Movie> findAllMovies() {
        return movies.values()
                .stream()
                .collect(Collectors.toUnmodifiableList());
    }

    public Movie findMovieById(Long id) {
        return movies.values()
                .stream()
                .filter(movie -> movie.checkSame(id))
                .findFirst()
                .orElseThrow(() -> new NullPointerException(MOVIE_NOT_FOUND_EXCEPTION.message));
    }
}
