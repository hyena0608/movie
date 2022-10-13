package movie.ticket.domain.movie;

import javax.swing.*;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static movie.ticket.exception.MovieException.MOVIE_NOT_FOUND_EXCEPTION;

public enum Movies {

    MOVIES(new HashMap<>());

    private final Map<Long, Movie> movies;

    Movies(Map<Long, Movie> movies) {
        this.movies = movies;
    }

    public static Collection<Movie> findAllMovies() {
        return MOVIES.movies.values()
                .stream()
                .collect(Collectors.toUnmodifiableList());
    }

    public static Movie findMovieById(Long id) {
        return MOVIES.movies.values()
                .stream()
                .filter(movie -> movie.checkSame(id))
                .findFirst()
                .orElseThrow(() -> new NullPointerException(MOVIE_NOT_FOUND_EXCEPTION.message));
    }
}
